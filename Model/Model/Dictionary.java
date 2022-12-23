package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Dictionary {
	private static ArrayList<String> words;
	private static Dictionary dict = new Dictionary();

	public Dictionary() {
		try {
			Dictionary.words = new ArrayList<>();
			File fileOfWords = new File("wordList.txt");
			Scanner inwords = new Scanner(fileOfWords);

			while(inwords.hasNextLine()) {
				String word = inwords.nextLine();
				Dictionary.words.add(word);
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

		for(String m : Dictionary.words) {
			if(m.length() == size) {
				w.add(m);
			}
		}
		return w;
	}

	public static boolean wordFits(String letters, String word) {
        ArrayList<Character> l = new ArrayList<Character>();
        ArrayList<Character> w = new ArrayList<Character>();

        for(int i = 0; i < letters.length(); i++)
            l.add(letters.charAt(i));
        for(int i = 0; i < word.length(); i++)
            w.add(word.charAt(i));

        return wordFits(l, w);
    }	

    private static boolean wordFits(ArrayList<Character> letters, ArrayList<Character> word) {
        ArrayList<Character> l = new ArrayList<>(letters);
        for(char c : word) {
            if(l.contains(c))
                l.remove(l.indexOf(c));
            else
                return false;
        }
        return true;
    }

    public static ArrayList<String> getWordsWith(ArrayList<Character> letters) {
        ArrayList<String> validWords = new ArrayList<>();
        for(String w : Dictionary.words) {
            ArrayList<Character> word = new ArrayList<>();
            for(int i = 0; i < w.length(); i++)
                word.add(w.charAt(i));
            if(wordFits(letters, word))
                validWords.add(w);
        }
        return validWords;
    }

    // public static ArrayList<Word> getWordsForMiddle(ArrayList<Letter> letters) {
    //     ArrayList<Word> words = new ArrayList<>();

    //     ArrayList<Character> letter = new ArrayList<>();
    //     for (Letter l : letters)
    //         letter.add(l.getLetter());

    //     for (String str : getWordsWith(letter)) {
    //         ArrayList<Letter> l = new ArrayList<>();
    //         ArrayList<Letter> wordPieces = new ArrayList<>();
    //         l.addAll(letters);

    //         for (char c : str.toCharArray()) {
    //             for (Letter ls : l) {
    //                 //if (letter.getLetter() == c.)
    //             }
    //         }
    //     }

    //     return words;
    // }

    public static ArrayList<String> getWordsContaining(ArrayList<Character> letters, String substring) {
        ArrayList<String> words = new ArrayList<>();

        for (String word : Dictionary.words) {
            String w = word;
            if (w.contains(substring.toLowerCase()) && (word.length() != substring.length())) {
                w = w.replace(substring.toLowerCase(), "");
                ArrayList<Character> l = new ArrayList<>(letters);
                boolean insert = true;
                for (int i = 0; i < w.length() && insert; i++) {
                    if (l.contains(w.charAt(i)))
                        l.remove((Object) w.charAt(i));
                    else
                        insert = false;
                }
                if (insert) words.add(word);
            }
        }

        return words;
    }
}