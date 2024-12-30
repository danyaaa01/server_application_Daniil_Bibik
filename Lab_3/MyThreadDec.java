package ru.prokhor.lab_3;

public class MyThreadDec extends Thread {
	
	Counter counter;
	int number;
	
	public MyThreadDec(Counter counter, int number){
		this.counter = counter;
		this.number = number;
	}
	
	public void run() {
		System.out.println("ThreadDec #"+String.valueOf(number)+" started!");
		int i = 100000;
		while (i>0) {
			counter.dec();
			i--;
		}
		i = counter.x;
		System.out.println("ThreadDec #"+String.valueOf(number)+" finished! Value is "+String.valueOf(i));
	}
}

