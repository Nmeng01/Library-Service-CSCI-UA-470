package classes;

import java.util.ArrayList;

public class Game extends LibraryItem {
	private ArrayList<String> reviews;
	private int numberOfPlayers;
	public Game(String name, boolean isBorrowed, String genre, ArrayList<String> reviews, int numberOfPlayers) {
		super(name, isBorrowed, genre);
		this.reviews = reviews;
		this.numberOfPlayers = numberOfPlayers;
	}
	public ArrayList<String> getReviews() {
		return reviews;
	}
	public void setReviews(ArrayList<String> reviews) {
		this.reviews = reviews;
	}
	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}
	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}
	
	

}
