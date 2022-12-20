
public class Tile {
	enum SpecialTile {
	    DOUBLELETTERSCORE("DL", 2),
	    TRIPLELETTERSCORE("TL", 3),
	    DOUBLEWORDSCORE("DW", 2),
	    TRIPLEWORDSCORE("TW", 3);

	    private final String abbreviation;
	    private final int multiplier;

	    SpecialTile(String abbreviation, int multiplier) {
	        this.abbreviation = abbreviation;
	        this.multiplier = multiplier;
	    }

	    public String getAbbreviation() {
	        return abbreviation;
	    }

	    public int getMultiplier() {
	        return multiplier;
	    }
	}

	public void applyStar() {
		Board.board[7][7] = "\u2606";
	}

	public void applyDW() {
		for(int i = 1; i < 5; i++) {
			Board.board[i][i] = "*";
		}


		for(int j = 1; j < 5; j++)
			Board.board[j][14 - j] = "*";

		for(int k = 10; k < 14; k++)
            Board.board[k][14 - k] = "*";

        for(int l = 10; l < 14; l++) 
            Board.board[l][l] = "*";
	}

	public void applyDL() {

	}

	public void applyTW() {

	}

	public void applyTL() {
		
	}
}