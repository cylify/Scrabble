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

	public static wordExists(String word) {
		if(word.contains("_")) {
			boolean exists = false;

			for(char i = 'a'; i < 'z'; i++) {
				if(wordExists(word.replace("_"), String.valueOf(i)));
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
}