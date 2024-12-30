package ru.prokhor.lab_3;

class Lab3Savages1 {
	public static void main(String args[]) {
		int m = 20;
		int n = 8;
		Pot pot = new Pot(n);

		MyThreadCook threadCook = new MyThreadCook(pot,m);
		threadCook.start();
		
		for (int i=0; i<m; i++) {
			MyThreadSavage threadSavage = new MyThreadSavage(pot,i);
			threadSavage.start();
		}
	}
}
