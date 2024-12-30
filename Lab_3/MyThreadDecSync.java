package ru.prokhor.lab_3;

public class MyThreadDecSync extends Thread {
	
	CounterSync counter;
	int number;
	
	public MyThreadDecSync(CounterSync counter, int number){
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

