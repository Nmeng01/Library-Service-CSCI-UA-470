package classes;

public abstract class LibraryItem {
	private String name;
	private boolean isBorrowed;
	private String genre;
	
	public LibraryItem(String name, boolean isBorrowed, String genre) {
		this.name = name;
		this.isBorrowed = isBorrowed;
		this.genre = genre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isBorrowed() {
		return isBorrowed;
	}

	public void setBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	

}
