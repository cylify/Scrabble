class Player {
	private String name;
	private int playerScore;
	private ArrayList<Letter> playerRack;
	private int playerRackSize;

	public Player(String name, int playerScore) {
		this.playerRackSize = 7;
		this.playerRack = getPlayerRack();
		this.name = name;
		this.playerScore = playerScore;
	}

	private ArrayList<Letter> getPlayerRack() {
		ArrayList<Letter> bag = getBag();
		ArrayList<Letter> playerRack = new ArrayList<>();
		Collections.shuffle(bag);

		for(int i = 0; i < this.playerRackSize; i++) {
			playerRack.add(bag.get(i));
		}
		return playerRack;

	}

	public int getPlayerScore() {
		return this.playerScore
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