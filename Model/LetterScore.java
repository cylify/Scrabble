public enum LetterScore {
	A(1),
	B(),
	C(),
	D(),
	E(),
	F(),
	G(),
	H(),
	I(),
	J(),
	K(),
	L(),
	M(),
	N(),
	O(),
	P(),
	Q(),
	R(),
	S(),
	T(),
	U(),
	V(),
	W(),
	X(),
	Y(),
	Z();

	private final int score;

	LetterScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}
}