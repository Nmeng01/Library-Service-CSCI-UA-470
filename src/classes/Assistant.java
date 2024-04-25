package classes;

import java.util.ArrayList;
import java.io.Serializable;

public class Assistant extends People implements Serializable{

	
	public Assistant(String name) {
		super(name);
	}

	public void buyItem() {
		
	}
	
	public void removeItem() {
		
	}
	
	public void updateItem() {
		
	}
	
	public ArrayList<LibraryItem> viewRequestList() {
		return new ArrayList<LibraryItem>();
	}
}
