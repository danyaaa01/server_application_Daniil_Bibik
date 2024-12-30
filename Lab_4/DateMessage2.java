package ru.prokhor.lab_4;

import java.io.Serializable;

public class DateMessage2 implements Serializable {
	
	private String [] message;
	
	public DateMessage2(int n) {
		this.message = new String[n];
	}
		
	public String getMessage(int n) {
		return message[n];
	}
	
	public void setMessage(int n, String message) {
		this.message[n] = message;
	}
}