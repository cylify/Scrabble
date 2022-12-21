public enum TileType {
	PLAINTILE(" ", 1),
    DOUBLELETTER("=", 2),
    TRIPLELETTER("#", 3),
    DOUBLEWORD("!", 2),
    TRIPLEWORD("%", 3),
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