package ru.prokhor.lab_4;

import java.io.*;
import java.net.*;
import java.util.concurrent.TimeUnit;

public class WeatherServer {
	
	private BufferedReader in = null;
	private String str = null;
	private byte[] buffer;
	private DatagramPacket packet;
	private InetAddress address;
	private DatagramSocket socket;
	
	public WeatherServer() throws IOException {
		System.out.println("Sending messages");
	// Создается объект DatagramSocket, чтобы
	// принимать запросы клиента
		socket = new DatagramSocket();
	// Вызов метода transmit(), чтобы передавать сообщение всем
	// клиентам, зарегистрированным в группе
		transmit();
	}
	public void transmit() {
		String file = "weather.txt";
		try(FileReader reader = new FileReader(file))
        {
            BufferedReader br = new BufferedReader(reader);
			String str;
			int c = 0;
            while((str=br.readLine())!=null){
				try {
					c++;
					buffer = str.getBytes();
					address = InetAddress.getByName("233.0.0.1");
					// Посылка пакета датаграмм на порт номер 1502
					packet = new DatagramPacket(
						buffer,
						buffer.length,
						address,
						1502);
					// Посылка сообщений всем клиентам в группе
					socket.send(packet);
					System.out.println("Sending: "+str);
				} catch (Exception e) {
					e.printStackTrace();
				} 
				try {
					Thread.sleep(10000);
					} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
            }
			if (c>0)
				try {
					// Закрытие потока и сокета
					socket.close();
					System.out.println("Завершение работы.");
				} catch (Exception e) {
					e.printStackTrace();
				}
			
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        }   
 }
 
 public static void main(String arg[]) throws Exception {
	// Запуск сервера
	new WeatherServer();
 }
}