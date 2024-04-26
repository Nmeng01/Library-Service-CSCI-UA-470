package classes;

import java.util.ArrayList;
import java.io.Serializable;
import classes.*;

public class Assistant extends People implements Serializable{

	
	public Assistant(String name) {
		super(name);
	}

	public void buyItem() {
		
	}
	
	public void removeItem() {
		
	}
	
	public void addItem(LibraryItem l, Inventory i) {
		i.addItem(l);
	}
	
	public ArrayList<LibraryItem> viewRequestList() {
		return new ArrayList<LibraryItem>();
	}
}
