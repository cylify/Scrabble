import java.util.ArrayList;
import java.util.Collections;

class Player {
	private String name;
	private int playerScore;
	private ArrayList<Letter> playerRack;
	private int currentRackSize;

	public Player(String name, int playerScore, int currentRackSize) {
		this.playerRack = new ArrayList<>();
		this.name = name;
		this.currentRackSize = currentRackSize;
		this.playerScore = playerScore;
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
}