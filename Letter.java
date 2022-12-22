import java.util.HashMap;

public class Letter {
	private Character letter;
	private Integer val;

	public Letter(Character letter, Integer val) {
		this.val = val;
		this.letter = letter;
	}

	public Character getLetter() {
		return this.letter;
	}

	public Integer getVal() {
		return this.val;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public void getVal(int val) {
		this.val = val;
	}
}