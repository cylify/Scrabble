import java.util.*;
import java.util.Map.Entry;

public class Bag {
	public static final int bagSize = 100;
	public static ArrayList<Letter> bagOfLetters;

	public Bag() {
		bagOfLetters = applyBag(getTempBag());
	}

	public <K> ArrayList<K> applyBag(HashMap<K, Integer> tempBag) {
		ArrayList<K> newbag = new ArrayList<>();
		for(int i = 0; i < 100; i++) {
			for(Entry<K, Integer> entry : tempBag.entrySet()) {
				for(int j = 0; j < entry.getValue(); j++) {
					newbag.add(entry.getKey());
				}
			}
		}
		return newbag;
	}

	public HashMap<Letter, Integer> getTempBag() {
		HashMap<Letter, Integer> bag = new HashMap<>() {{
			put(new Letter('A', 1), 9);
			put(new Letter('E', 1), 12);
			put(new Letter('I', 1), 9);
			put(new Letter('O', 1), 8);
			put(new Letter('U', 1), 4); 
			put(new Letter('L', 1), 4);
			put(new Letter('N', 1), 6); 
			put(new Letter('S', 1), 4); 
			put(new Letter('T', 1), 6); 
			put(new Letter('R', 1), 6); 
			put(new Letter('D', 2), 4); 
			put(new Letter('G', 2), 3); 
			put(new Letter('B', 3), 2);
			put(new Letter('C', 3), 2);
			put(new Letter('M', 3), 2);
			put(new Letter('P', 3), 2);
			put(new Letter('F', 4), 2);
			put(new Letter('H', 4), 2);
			put(new Letter('V', 4), 2);
			put(new Letter('W', 4), 2);
			put(new Letter('Y', 4), 2);
			put(new Letter('K', 5), 1);
			put(new Letter('J', 8), 1);
			put(new Letter('X', 8), 1);
			put(new Letter('Q', 10), 1);
			put(new Letter('Z', 10), 1);
			put(new Letter(' ', 0), 2);
		}};
		return bag;
	}

	public static ArrayList<Letter> getBag() {
		return bagOfLetters;
	}
}