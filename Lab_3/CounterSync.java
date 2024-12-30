package ru.prokhor.lab_3;

public class CounterSync {
	int x = 0;
	public synchronized void inc() {
		x++;
	}
	public synchronized void dec() {
		x--;
	}
}

