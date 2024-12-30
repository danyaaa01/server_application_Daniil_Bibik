package ru.prokhor.lab_3;

class Lab3NoSync {
	public static void main(String args[]) {
		int m = 5;
		int n = 5;
		Counter counter = new Counter();
		int k;
		if (m>n) k=m; else k=n;
		for (int i=0; i<k; i++) {
			if (m>=0) {
				MyThreadInc threadInc = new MyThreadInc(counter,i);
				m--;
				threadInc.start();
			}
			if (n>=0) {
				MyThreadDec threadDec = new MyThreadDec(counter,i);
				n--;
				threadDec.start();
			}
		}

	}
}
