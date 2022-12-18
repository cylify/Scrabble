class Tile {
	enum SpecialTile {
	    DoubleLettterScore("DL", 2),
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
}