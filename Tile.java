
public class Tile {
	enum SpecialTile {
	    DOUBLELETTERSCORE("=", 2),
	    TRIPLELETTERSCORE("#", 3),
	    DOUBLEWORDSCORE("!", 2),
	    TRIPLEWORDSCORE("%", 3),
		STAR("\u2606", 2);

	    private final String symbol;
	    private final int multiplier;

	    SpecialTile(String symbol, int multiplier) {
	        this.symbol = symbol;
	        this.multiplier = multiplier;
	    }

	    public String getsymbol() {
	        return symbol;
	    }

	    public int getMultiplier() {
	        return multiplier;
	    }
	}

	public void applyStar() {
		Board.board[7][7] = SpecialTile.STAR.symbol;
	}

	public void applyDW() {
		for(int i = 1; i < 5; i++) {
			Board.board[i][i] = SpecialTile.DOUBLEWORDSCORE.symbol;
		}

		for(int j = 1; j < 5; j++) {
			Board.board[j][14 - j] = SpecialTile.DOUBLEWORDSCORE.symbol;
		}

		for(int k = 10; k < 14; k++) {
            Board.board[k][14 - k] = SpecialTile.DOUBLEWORDSCORE.symbol;
		}

        for(int l = 10; l < 14; l++) {
            Board.board[l][l] = SpecialTile.DOUBLEWORDSCORE.symbol;
        }
	}

	public void applyDL() {
		Board.board[0][3] = SpecialTile.DOUBLELETTERSCORE.symbol;
		Board.board[0][11] = SpecialTile.DOUBLELETTERSCORE.symbol;
		Board.board[3][0] = SpecialTile.DOUBLELETTERSCORE.symbol;
		Board.board[3][15] = SpecialTile.DOUBLELETTERSCORE.symbol;
	}

	public void applyTW() {

	}

	public void applyTL() {
		
	}
}