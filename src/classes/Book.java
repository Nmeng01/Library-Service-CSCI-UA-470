package classes;

import java.util.ArrayList;

public class Book extends LibraryItem {

	private String author;
	private String illustrator;
	private ArrayList<String> awards;
	private String levelOfReading;
	
	public Book(String name, boolean isBorrowed, String genre, String a) {
		super(name, isBorrowed, genre);
		this.author = a;
	}
	
	public void setIllustrator(String i) {
		this.illustrator = i;
	}
	
	public void setAwards(ArrayList<String> a) {
		this.awards = a;
	}
	
	public void setLevelOfReading(String l) {
		this.levelOfReading = l;
	}

	@Override
	public String toString() {
		return this.getName() + " (Book)";

	}
	

}
