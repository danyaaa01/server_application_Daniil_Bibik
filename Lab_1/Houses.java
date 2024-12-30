package ru.prokhor.lab_1;
import java.io.*;

public class Houses {
	
	static private House [] Items;
	
	static private int size;
	
	private Houses(int n) {
		Items = new House[n];
		size = n;
	}
	
	static private void getByRooms(int rooms){
		for (int i=0; i<size;i++) {
			if (Items[i].getRooms()==rooms)
				System.out.println("Flat with ID " + String.valueOf(Items[i].getId()) + " has " + String.valueOf(rooms) + " room(s)");
		}
	}
	
	static private void getByRoomsAndFloorRange(int rooms, int minFloor, int MaxFloor){
		for (int i=0; i<size;i++) {
			if ((Items[i].getRooms()==rooms)&&(Items[i].getFloor()>=minFloor)&&(Items[i].getFloor()<=MaxFloor))
				System.out.println("Flat with ID " + String.valueOf(Items[i].getId()) + " has " + String.valueOf(rooms) + " room(s) on floor "  + String.valueOf(Items[i].getFloor()));
		}
	}
	
	static private void getByGreaterSquare(float square){
		for (int i=0; i<size;i++) {
			if (Items[i].getSquare()>square)
				System.out.println("Flat with ID " + String.valueOf(Items[i].getId()) + " has square greater then " + String.valueOf(square));
		}
	}
	
	public static void main(String[ ] args){
		System.out.println("Started");
		int c = 0;
		String file = "houses.txt";
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
				if(c%5!=0){
					System.out.println("Error: invalid number of strings");
				}
				else {
					int n = c/5;
					System.out.println("File is OK. Found " + String.valueOf(n) + " flats");
					new Houses(n);
					FileReader reader2 = new FileReader(file);
					br = new BufferedReader(reader2);
					int id, number, floor, rooms;
					float square;
					for(int i=0;i<n;i++){
						id = Integer.parseInt(br.readLine());
						number = Integer.parseInt(br.readLine());
						square = Float.parseFloat(br.readLine());
						floor = Integer.parseInt(br.readLine());
						rooms = Integer.parseInt(br.readLine());
						Items[i] = new House(id,number,square,floor,rooms);
					}
					System.out.println("Data loaded to array of objects");
					
					getByRooms(2);
					getByRoomsAndFloorRange(2,3,3);
					getByGreaterSquare(42.0f);
				}
			}
			
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        }   
			
	}
	

}