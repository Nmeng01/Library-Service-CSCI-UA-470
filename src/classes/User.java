package classes;

import java.util.ArrayList;
import java.util.Iterator;
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
		Iterator<LibraryItem> borrowedItr = borrowed.iterator();
		while (borrowedItr.hasNext()) { 
			LibraryItem item = borrowedItr.next();
			if (item.getName().equals(o.getName())) {
		    	borrowedItr.remove();
			}
        } 
//		for(LibraryItem item: borrowed) {
//			  if (item.getName().equals(o.getName())) {
//                  borrowed.remove(item);
//			  }
//      	} 
//using for loop with remove causes an error
//source: https://www.geeksforgeeks.org/remove-element-arraylist-java/
		
	}
	public void request() {
		
	}
	public ArrayList<LibraryItem> viewItems() {
		return this.borrowed;
	}

}
