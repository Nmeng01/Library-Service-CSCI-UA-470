package classes;

import java.util.ArrayList;

public class User extends People {
	private ArrayList<LibraryItem> borrowed;
	
	public User(String name) {
		super(name);
	}
	
	public void borrowItem() {
		
	}
	public void returnItem() {
		
	}
	public void request() {
		
	}
	public ArrayList<LibraryItem> viewItems() {
		return this.borrowed;
	}

}
