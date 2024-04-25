package classes;

import java.util.ArrayList;
import java.io.Serializable;

public class User extends People implements Serializable {
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
