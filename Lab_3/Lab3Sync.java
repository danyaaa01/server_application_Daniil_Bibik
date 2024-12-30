package ru.prokhor.lab_3;

class Lab3Sync {
	public static void main(String args[]) {
		int m = 5;
		int n = 5;
		CounterSync counter = new CounterSync();
		int k;
		if (m>n) k=m; else k=n;
		for (int i=0; i<k; i++) {
			if (m>=0) {
				MyThreadIncSync threadInc = new MyThreadIncSync(counter,i);
				m--;
				threadInc.start();
			}
			if (n>=0) {
				MyThreadDecSync threadDec = new MyThreadDecSync(counter,i);
				n--;
				threadDec.start();
			}
		}

	}
}
