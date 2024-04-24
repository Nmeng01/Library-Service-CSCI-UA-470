package classes;

import java.util.ArrayList;

public class Book extends LibraryItem {

	private String author;
	private String illustrator;
	private ArrayList<String> awards;
	private String levelOfReading;
	
	public Book(String name, boolean isBorrowed, String genre) {
		super(name, isBorrowed, genre);
		
	}

}
