package ru.prokhor.lab_3;

public class MyThreadSavage extends Thread {
	
	Pot pot;
	int i;
	
	public MyThreadSavage(Pot pot, int i){
		this.pot = pot;
		this.i = i;
	}
	
	public void run() {
		
		while (Pot.get()==false) {
			System.out.println("Savage #"+String.valueOf(i)+" want to eat, but pot is empty. Waiting...");
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				System.out.println("Sleep failed!");
			}
		}
		System.out.println("Savage #"+String.valueOf(i)+" feeded.");
	}
}