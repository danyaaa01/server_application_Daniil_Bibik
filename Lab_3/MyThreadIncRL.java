package ru.prokhor.lab_3;
import java.util.concurrent.locks.ReentrantLock;
public class MyThreadIncRL extends Thread {
	
	Counter counter;
	int number;
	ReentrantLock lock;
	long nano;
	
	public MyThreadIncRL(Counter counter, int number, ReentrantLock lock, long nano){
		this.counter = counter;
		this.number = number;
		this.lock = lock;
		this.nano = nano;
	}
	
	public void run() {
		System.out.println("ThreadInc #"+String.valueOf(number)+" started!");
		int i = 100000;
		while (i>0) {
			lock.lock();
			counter.inc();
			lock.unlock();
			i--;
		}
		i = counter.x;
		long n = System.nanoTime();
		System.out.println("ThreadInc #"+String.valueOf(number)+" finished! Value is "+String.valueOf(i));
		if (i==0) System.out.println("Time usage "+String.valueOf(n-nano)+" nanoseconds");
	}
}

