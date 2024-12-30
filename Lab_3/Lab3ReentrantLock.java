package ru.prokhor.lab_3;
import java.util.concurrent.locks.ReentrantLock;
class Lab3ReentrantLock {
	public static void main(String args[]) {
		long nano = System.nanoTime();
		int m = 5;
		int n = 5;
		Counter counter = new Counter();
		ReentrantLock lock = new ReentrantLock();
		int k;
		if (m>n) k=m; else k=n;
		for (int i=0; i<k; i++) {
			if (m>=0) {
				MyThreadIncRL threadInc = new MyThreadIncRL(counter,i,lock,nano);
				m--;
				threadInc.start();
			}
			if (n>=0) {
				MyThreadDecRL threadDec = new MyThreadDecRL(counter,i,lock,nano);
				n--;
				threadDec.start();
			}
		}
	}
}
