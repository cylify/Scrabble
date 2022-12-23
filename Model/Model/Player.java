import java.util.ArrayList;
import java.util.Collections;

public class Player {
	private String name;
	private int playerScore;
	private ArrayList<Letter> playerRack;
	protected final int rackSize = 7;

	public Player(String name) {
		this.playerRack = new ArrayList<>();
		this.name = name;
		this.playerScore = 0;
		this.playerRack = getPlayerRack();
	}

	private ArrayList<Letter> getPlayerRack() {
		ArrayList<Letter> bag = Bag.getBag();
		ArrayList<Letter> rack = new ArrayList<>();
		Collections.shuffle(bag);
		int playerRackSize = 7;

		for(int i = 0; i < playerRackSize; i++) {
			rack.add(bag.get(i));
		}
		return rack;
	}

	public void increaseScore(int val) {
		this.playerScore += val;
	}

	public int getPlayerScore() {
		return this.playerScore;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}

	public boolean rackFilled() {
		return playerRack.size() >= rackSize;
	}

	public void addLetter(Letter letter) {
		playerRack.add(letter);
	}

	public void removeLetter(Letter letter) {
		playerRack.remove(letter);
	}

	public void refillRack(Bag bag) {
		while(!rackFilled()) {
			addLetter(bag.takeLetter());
		}
	}
}