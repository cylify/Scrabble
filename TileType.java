public enum TileType {
	PLAINTILE(" ", 1),
    DOUBLELETTERSCORE("=", 2),
    TRIPLELETTERSCORE("#", 3),
    DOUBLEWORDSCORE("!", 2),
    TRIPLEWORDSCORE("%", 3),
	STAR("\u2606", 2);

    private final String symbol;
    private final int multiplier;

    TileType(String symbol, int multiplier) {
        this.symbol = symbol;
        this.multiplier = multiplier;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getMultiplier() {
        return multiplier;
    }
}