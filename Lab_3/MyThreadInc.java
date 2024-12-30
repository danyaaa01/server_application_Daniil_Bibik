package ru.prokhor.lab_3;

public class MyThreadInc extends Thread {
	
	Counter counter;
	int number;
	
	public MyThreadInc(Counter counter, int number){
		this.counter = counter;
		this.number = number;
	}
	
	public void run() {
		System.out.println("ThreadInc #"+String.valueOf(number)+" started!");
		int i = 100000;
		while (i>0) {
			counter.inc();
			i--;
		}
		i = counter.x;
		System.out.println("ThreadInc #"+String.valueOf(number)+" finished! Value is "+String.valueOf(i));
	}
}

