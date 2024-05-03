package classes;

import java.util.ArrayList;
import java.io.Serializable;

public class Inventory implements Serializable {
	private ArrayList<LibraryItem> inventory;
	private ArrayList<String> requestList;
	
	public Inventory() {
		this.inventory = new ArrayList<LibraryItem>();
		this.requestList = new ArrayList<String>();
	}
	
	public void addItem(LibraryItem l) {
		this.inventory.add(l);
	}
	public void removeItem(int index) {
		this.inventory.remove(index);
	}
	
	public void removeItem(LibraryItem item) {
		this.inventory.remove(item);
	}
	
	public void removeRequest(String s) {
		this.requestList.remove(s);
	}
	
	public ArrayList<LibraryItem> filterBy(String type) {
		return new ArrayList<LibraryItem>();
	}
	
	public ArrayList<LibraryItem> availableItems() {
		return new ArrayList<LibraryItem>();
	}
	
	public ArrayList<LibraryItem> displayAll() {
		return this.inventory;
	}

	public void setInventory(ArrayList<LibraryItem> inventory) {
		this.inventory = inventory;
	}

	public ArrayList<String> getRequestList() {
		return this.requestList;
	}

	public void setRequestList(ArrayList<String> requestList) {
		this.requestList = requestList;
	}
	
	
	

}
