import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Dictionary {
	public static Scanner in = new Scanner(System.in);
	private static ArrayList<String> words;
	private static Dictionary dict = new Dictionary();

	public Dictionary() {
		try {
			this.words = new ArrayList<>();
			File fileOfWords = new File("wordList.txt");
			Scanner inwords = new Scanner(fileOfWords);

			while(inwords.hasNextLine()) {
				String word = inwords.nextLine();
				this.words.add(word);
			}
			inwords.close();

		} catch(FileNotFoundException e) {
			System.out.println("File does not exist");
		}
	}

	public static boolean wordExists(String word) {
		if(word.contains("_")) {
			boolean exists = false;

			for(char i = 'a'; i < 'z'; i++) {
				if(wordExists(word.replace("_", String.valueOf(i))));
				exists = true;
			}
			return exists;
		}
		return words.contains(word.toLowerCase());
	}

	public static ArrayList<String> getWords(int size) {
		ArrayList<String> w = new ArrayList<>();

		for(String m : dict.words) {
			if(m.length() == size) {
				w.add(m);
			}
		}
		return w;
	}

	public static boolean wordFits(String letters, String word) {
        ArrayList<Character> l = new ArrayList<Character>();
        ArrayList<Character> w = new ArrayList<Character>();

        for (int i = 0; i < letters.length(); i++)
            l.add(letters.charAt(i));
        for (int i = 0; i < word.length(); i++)
            w.add(word.charAt(i));

        return wordFits(l, w);
    }	

    private static boolean wordFits(ArrayList<Character> letters, ArrayList<Character> word) {
        ArrayList<Character> l = new ArrayList<>(letters);
        for (char c : word) {
            if (l.contains(c))
                l.remove(l.indexOf(c));
            else
                return false;
        }
        return true;
    }

    public static ArrayList<String> getWordsWith(ArrayList<Character> letters) {
        ArrayList<String> validWords = new ArrayList<>();
        for (String w : dic.words) {
            ArrayList<Character> word = new ArrayList<>();
            for (int i = 0; i < w.length(); i++)
                word.add(w.charAt(i));
            if (wordFits(letters, word))
                validWords.add(w);
        }
        return validWords;
    }

    public static ArrayList<Word> getWordsForMiddle(ArrayList<Letter> letters) {
        ArrayList<Word> words = new ArrayList<>();

        ArrayList<Character> letters = new ArrayList<>();
        for (Letter l : letters)
            letters.add(l.getLetter());

        for (String str : getWordsWith(letters)) {
            ArrayList<Letter> l = new ArrayList<>();
            ArrayList<Letter> wordPieces = new ArrayList<>();
            l.addAll(pieces);

            for (char c : str.toCharArray()) {
                for (Letter letter : l) {
                    //if (letter.getLetter() == c.)
                }
            }
        }

        return words;
    }
}