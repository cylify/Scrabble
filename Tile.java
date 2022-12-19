class Tile {
	enum SpecialTile {
	    DoubleLetterScore("DL", 2),
	    TripleLetterScore("TL", 3),
	    DoubleWordScore("DW", 2),
	    TripleWordScore("TW", 3);

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


	public void placeTile(int row, int col, char tile) {
		board[row][col] = tile;
	}

	public char getTile(int row, int col) {
    	return board[row][col];
  	}

	public char[][] applyDW() {
		char[][] temp = new temp[15][15];

		for(int i= 0; i < 5; ++i)
			temp[i][i] = '*';

		for(int j = 0; j < 5; ++j)
			temp[j][14-j] = '*';

		for(int k = 10; k < 14; ++k)
            temp[k][14 - k] = '*';
        

        for(int l = 10; l < 14; ++l) 
            temp[l][l] = '*';
        
        return temp;
	}

	public char[][] applyDL() {
		
	}
}