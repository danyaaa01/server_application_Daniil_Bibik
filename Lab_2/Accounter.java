package ru.prokhor.lab_2;
import java.io.*;
import java.util.ArrayList;
public class Accounter {
	
	static private AccountBl findAccount(ArrayList<AccountBl> arrayList, long number) {
		AccountBl r = null;
		for(int i=0;i<arrayList.size();i++){
			if (arrayList.get(i).getNumber()==number)
				r = arrayList.get(i);
		}
		return r;
	}
	
	static private float getTotal(ArrayList<AccountBl> arrayList){
		float r = 0.0f;
		for(int i=0;i<arrayList.size();i++){
			r += arrayList.get(i).getAmount();
		}
		return r;
	}
	static private float getTotalP(ArrayList<AccountBl> arrayList){
		float r = 0.0f;
		for(int i=0;i<arrayList.size();i++){
			if (arrayList.get(i).getAmount()>0)
				r += arrayList.get(i).getAmount();
		}
		return r;
	}

	static private float getTotalN(ArrayList<AccountBl> arrayList){
		float r = 0.0f;
		for(int i=0;i<arrayList.size();i++){
			if (arrayList.get(i).getAmount()<0)
				r += arrayList.get(i).getAmount();
		}
		return r;
	}
	
	public static void main(String[ ] args){
		System.out.println("Started");
		int c = 0;
		String file = "accounts.txt";
        try(FileReader reader = new FileReader(file))
        {
            BufferedReader br = new BufferedReader(reader);
			String s;
            while((s=br.readLine())!=null){
                c++;
            }
			if(c==0) {
				System.out.println("Error: no strings found");
			}
			else {
				if(c%3!=0){
					System.out.println("Error: invalid number of strings");
				}
				else {
					int n = c/3;
					System.out.println("File is OK. Found " + String.valueOf(n) + " accounts");
					ArrayList<AccountBl> arrayList = new ArrayList<>();
					FileReader reader2 = new FileReader(file);
					br = new BufferedReader(reader2);
					long number;
					int blocked;
					float amount;
					for(int i=0;i<n;i++){
						AccountBl ab = new AccountBl();
						number = Long.parseLong(br.readLine());
						ab.setNumber(number);
						blocked = Integer.parseInt(br.readLine());
						if (blocked>0) ab.setBlocked();
						amount = Float.parseFloat(br.readLine());
						ab.setAmount(amount);
						arrayList.add(ab);
					}
					System.out.println("Data loaded to array of objects");
					System.out.println("Findings");
					long f = 32432433;
					if (findAccount(arrayList,f)!=null)
						System.out.println("Account "+Long.toString(f)+" found");
					else
						System.out.println("Account "+Long.toString(f)+" not found");
					f = 12345678;
					if (findAccount(arrayList,f)!=null)
						System.out.println("Account "+Long.toString(f)+" found");
					else
						System.out.println("Account "+Long.toString(f)+" not found");
					System.out.println("Total amount is " + Float.toString(getTotal(arrayList)));
					System.out.println("Total positive amount is " + Float.toString(getTotalP(arrayList)));
					System.out.println("Total negative amount is " + Float.toString(getTotalN(arrayList)));					
				}
			}
			
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        }   
		
	}
}