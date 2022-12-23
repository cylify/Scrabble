public class Tile {
	private Letter letter;
	private int x;
	private int y;

	private TileType type;

	public Tile(int x, int y, TileType type) {
		if(checkCoordinates(x,y)) {
			this.x = x;
			this.y = y;
			this.type = type;
			this.letter = null;
		}
	}

	public Tile(Tile tile) {
		setLetter(tile.getLetter());
		this.x = tile.getX();
		this.y = tile.getY();
		this.type = tile.getType();
	}


	@Override
	public String toString() {
		return (char)(this.x + 'A') + Integer.toString(this.y + 1);
	}

	public boolean checkCoordinates(int xCoord, int yCoord) {
		boolean correct = true;
		if(xCoord < 0 || yCoord < 0 || xCoord > 14 || yCoord > 14) { correct = false; }
		return correct;
    }

	public boolean isEmpty() {
        return letter == null;
    }

    public int getWordMultiplier() {
        if (type == TileType.DOUBLEWORD || type == TileType.STAR) 
			return 2;
        if (type == TileType.TRIPLEWORD) 
			return 3;
        return TileType.PLAINTILE.getMultiplier();
    }

    public int getLetterMultiplier() {
        if(type == TileType.DOUBLELETTER)
			return TileType.DOUBLELETTER.getMultiplier();
        if(type == TileType.TRIPLELETTER) 
			return TileType.DOUBLELETTER.getMultiplier();
		return TileType.PLAINTILE.getMultiplier();
    }

	public Letter getLetter() {
		return letter;
	}

	public void setLetter(Letter letter) {
		this.letter = letter;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public TileType getType() {
		return type;
	}

	public void setType(TileType type) {
		this.type = type;
	}
}