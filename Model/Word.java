import java.util.ArrayList;

public class Word {
	private Tile start;
	private Direction dir;
	private ArrayList<Letter> letters;

	public Word(Tile start, Direction dir, ArrayList<Letter> letters) {
		this.start = start;
		this.dir = dir;
		this.letters = letters;
	}

	public Direction getDirection() {
		return dir;
	}

	public ArrayList<Letter> getLetters() {
		return letters;
	}

	public int getOriginX() {
		return start.getX();
	}

	public int getOriginY(){
        return start.getY();
    }

    public Tile getOrigin(){
        return start;
    }

	@Override
	public String toString() {
		String str = "Origin: " + start.getX() + ", " + start.getY() + " Word: ";
		for(Letter l : letters) {
			str += l.getLetter();
		}

		str += " Orientation : " + dir.toString();

		return str;
	}
}