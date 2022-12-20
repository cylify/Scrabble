import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Word {
	private boolean ifValid;
	ArrayList<String> words;


	public Word() throws FileNotFoundException {
		try {
			this.words = new ArrayList<>();
			File fileOfWords = new File("wordList.txt");
			Scanner in = new Scanner(fileOfWords);

			while(in.hasNextLine()) {
				String word = in.nextLine();
				this.words.add(word);
			}
			in.close();

		} catch(FileNotFoundException e) {
			System.out.println("File does not exist");
		}
	}

	// public boolean confirmWord(String word) {

	// }
}