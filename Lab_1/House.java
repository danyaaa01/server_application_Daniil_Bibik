package ru.prokhor.lab_1;
public class House {
	private int id;
	private int number;
	private float square;
	private int floor;
	private int rooms;
	private String street;
	private int type;
	private int term;
	
	public House(int id) {
		this.id = id;
	}
	
	public House(int id, int number, float square, int floor, int rooms) {
		this.id = id;
		this.number = number;
		this.square = square;
		this.floor = floor;
		this.rooms = rooms;
	}

	public int getId() {
		return id;
	}
	
	public int getNumber() {
		return number;
	}
	
	public float getSquare() {
		return square;
	}
	
	public int getFloor() {
		return floor;
	}
	
	public int getRooms() {
		return rooms;
	}
	
	@Override
	public String toString() {
		return Integer.toString(id)+") flat number "+Integer.toString(number);
	}
	
	@Override
	public int hashCode() {
		return id+number+rooms+floor;
	}
}