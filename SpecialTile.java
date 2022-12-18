enum SpecialTile {
    DLScore("DL", 2),
    TLScore("TL", 3),
    DWScore("DW", 2),
    TWScore("TW", 3);

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
