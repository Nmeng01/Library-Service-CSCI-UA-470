package classes;

import java.util.ArrayList;
import java.io.Serializable;

public class User extends People implements Serializable {
	private ArrayList<LibraryItem> borrowed;
	
	public User(String name) {
		super(name);
		borrowed = new ArrayList<>();
	}
		
	public void borrowItem(LibraryItem n) {
		//add item to borrowed
		borrowed.add(n);
	}
	public void returnItem(LibraryItem o) {
		//remove from borrowed
		for(LibraryItem item: borrowed) {
			  if (item.getName().equals(o.getName())) {
                  borrowed.remove(item);
			  }
      	}
		
	}
	public void request() {
		
	}
	public ArrayList<LibraryItem> viewItems() {
		return this.borrowed;
	}

}
