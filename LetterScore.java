public enum LetterScore {
	A(1),
	B(2);

	private final int score;

	LetterScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}
}