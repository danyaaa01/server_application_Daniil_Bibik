package ru.prokhor.lab_3;

public class Pot {
	public static int x = 0;
	static int n;
	public static int feeded = 0;
	
	public Pot(int n) {
		this.n=n;
	}
	
	public static synchronized boolean get() {
		if (x==0) return false;
		else {
			x--;
			feeded++;
			return true;
		}
	}
	public static void put() {
		x=n;
	}
}

