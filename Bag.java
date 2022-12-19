class Bag {
	public static final int bagSize;
	public static ArrayList<Letter> bagOfLetters;

	public Bag() {
		this.bagSize = 100;
		this.bagOfLetters = applyBag(getBag());
	}

	public <K, V> ArrayList<Letter> applyBag(HashMap<K, V> tempBag) {
		ArrayList<Letter> newbag = new ArrayList<>();
		for(int i = 0; i < 100; i++) {
			for(Entry<K,V> entry : tempBag.entrySet()) {
				for(int j = 0; j < entry.getValue(); j++) {
					newbag.add(entry.getKey());
				}
			}
		}
		return newbag;
	}

	public HashMap<Character, Integer> getTempBag() {
		HashMap<Character, Integer> bag = new HashMap<>() {{
			put('A', 9);
			put('E', 12);
			put('I', 9);
			put('O', 8);
			put('U', 4); 
			put('L', 4);
			put('N', 6); 
			put('S', 4); 
			put('T', 6); 
			put('R', 6); 
			put('D', 4); 
			put('G', 3); 
			put('B', 2);
			put('C', 2);
			put('M', 2);
			put('P', 2);
			put('F', 2);
			put('H', 2);
			put('V', 2);
			put('W', 2);
			put('Y', 2);
			put('K', 1);
			put('J', 1);
			put('X', 1);
			put('Q', 1);
			put('Z', 1);
			put(' ', 2);
		}};
		return bag;
	}

	public ArrayList<Letter> getBag() {
		return this.bagOfLetters;
	}
}