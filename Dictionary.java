import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Dictionary {
	public static Scanner in = new Scanner(System.in);

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
}