package ru.prokhor.lab_3;

public class MyThreadCook extends Thread {
	
	Pot pot;
	int m;
	
	public MyThreadCook(Pot pot, int m){
		this.pot = pot;
		this.m = m;
	}
	
	public void run() {
		
		System.out.println("Cook start work");
		while (Pot.feeded<m) {
			while ((Pot.x>0)&&(Pot.feeded<m)) {
				try {
					Thread.sleep(1000);
				}
				catch (InterruptedException e) {
					System.out.println("Sleep failed!");
				}
			}
			if (Pot.feeded<m ){
				System.out.println("Cook put new food into pot.");
				Pot.put();
			}
		}
		System.out.println("Cook finish work");
	}
}

