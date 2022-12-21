import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Word {
	private boolean ifValid;
	ArrayList<String> words;
	private static Scanner in = new Scanner(System.in);


	public Word() throws FileNotFoundException {
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

	public void placeWord() {
		String word = in.nextLine();
	}

	// public String coordsOfWords() {

	// }
}