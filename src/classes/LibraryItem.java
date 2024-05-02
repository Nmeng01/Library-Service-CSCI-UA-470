package classes;

import java.io.Serializable;

public abstract class LibraryItem implements Serializable {
	private String name;
	private boolean isBorrowed;
	private String genre;
	
	public LibraryItem(String name, boolean isBorrowed, String genre) {
		this.name = name;
		this.isBorrowed = isBorrowed;
		this.genre = genre;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isBorrowed() {
		return this.isBorrowed;
	}

	public void setBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Name: " + name + ", Type: " + this.getClass();
	}
	
	
	
	

}
