package ru.prokhor.lab_4;

import java.io.ObjectInputStream;
import java.net.Socket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIClient {
	private final static String newline = "\n";
	
	private static JTextArea textArea;
	
    public static void main(String[] args) {
		
		
        JFrame frame = new JFrame("Сообщения о погоде");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
		
		JButton but = new JButton("Получить");
		but.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// Создается объект Socket для соединения с сервером
					Socket clientSocket = new Socket("localhost", 1500);
					// Получаем ссылку на поток, связанный с сокетом
					ObjectInputStream in = 	new ObjectInputStream(clientSocket.getInputStream());
					// Извлекаем объект из входного потока
					DateMessage2 dateMessage = (DateMessage2) in.readObject();
					for(int n=0; n<5; n++) {
						textArea.append(dateMessage.getMessage(n) + newline);
					}

				} catch (Exception er) {
					//er.printStackTrace();
					textArea.append("Ошибка приема данных !" + newline);
				}
		}
		});
        
		frame.add(but, BorderLayout.SOUTH);
		
		textArea = new JTextArea(5, 20);
		textArea.setEditable(false);
		frame.add(textArea, BorderLayout.NORTH);
		
		textArea.append("Программа запущена..." + newline);
		
        frame.setVisible(true);
		

    }
}