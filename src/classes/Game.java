package classes;

import java.util.ArrayList;

public class Game extends LibraryItem {
	private ArrayList<String> reviews;
	private int numberOfPlayers;
	public Game(String name, boolean isBorrowed, String genre) {
		super(name, isBorrowed, genre);
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
	@Override
	public String toString() {
		return this.getName() + " (Game)";

	}
	
	
	

}
