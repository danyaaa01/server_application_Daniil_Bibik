package ru.prokhor.lab_4;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.*;
import java.util.Objects;
/**
* Класс сервера (выполняется в отдельном процессе)
*/
public class Middle extends Thread {
	// Объявляется ссылка на объект - сокет сервера
	ServerSocket serverSocket = null;
	
	private static InetAddress address;
	private static byte[] buffer;
	private static DatagramPacket packet;
	private static String str;
	private static MulticastSocket socket;
	private static DateMessage2 dateMessage;
	
	 /**
	 * Конструктор по умолчанию
	 */
	 public Middle() {
		 try {
				dateMessage = new DateMessage2(5);
			 	System.out.println("Ожидание сообщений от сервера");
				int c=0;
			
				try {
					// Создание объекта MulticastSocket, чтобы получать
					// данные от группы, используя номер порта 1502
					socket = new MulticastSocket(1502);
					address = InetAddress.getByName("233.0.0.1");
					// Регистрация клиента в группе
					socket.joinGroup(address);
					while (c<5) {
						buffer = new byte[256];
						packet = new DatagramPacket(buffer, buffer.length);
						// Получение данных от сервера
						socket.receive(packet);
						str = new String(packet.getData());
						if (c>0) {
							if(Objects.equals(dateMessage.getMessage(c-1),str.trim()))
								System.out.println("Повтор");
							else {
								dateMessage.setMessage(c, str.trim());
								c++;
								System.out.println("Получено сообщение: "+str.trim());
							}
						}
						else {
							dateMessage.setMessage(c, str.trim());
							c++;
							System.out.println("Получено сообщение: "+str.trim());
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						// Удаление клиента из группы
						socket.leaveGroup(address);
						// Закрытие сокета
						socket.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				System.out.println("Сообщения получены");
			 // Создается объект ServerSocket, который получает
			 // запросы клиента на порт 1500
			 serverSocket = new ServerSocket(1500);
			 System.out.println("Starting the server ");
			 // Запускаем процесс
			 start();
		 } catch (Exception e) {
			e.printStackTrace();
		 }
	 }
	 /**
	 * Запуск процесса
	 */
	 public void run() {
		 try {
			 while (true) {
				// Ожидание запросов соединения от клиентов
				Socket clientSocket = serverSocket.accept();
				System.out.println("Connection accepted from " + clientSocket.getInetAddress().getHostAddress());
				// Получение выходного потока, связанного с объектом Socket
				ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
				// Создание объекта для передачи клиентам
				
				 // Запись объекта в выходной поток
				out.writeObject(dateMessage);
				out.close();
			 }
		 } catch (Exception e) {
		 e.printStackTrace();
		 }
	 }
 public static void main(String args[]) {
	// Запуск сервера
	new Middle();
 }
}
