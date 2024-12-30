package ru.prokhor.lab_2;
public class AccountBl extends Account {
	private boolean blocked;
	
	public void setBlocked() {
		blocked = true;
	}
	
	public boolean getBlocked() {
		return blocked;
	}
	
	@Override
	public void setAmount(float a) {
		if (blocked == false) super.setAmount(a);
	}
}