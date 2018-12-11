// The text file contains one word per line
// The file can contain up to 200 words

import java.io.File;
import java.util.Scanner;

public class Helper
{
	public static String getRandomWord() throws Exception
	{
		final int SIZE = 200;
		String [] words = new String[ SIZE ];
File temp = new File("src/HangManWords.txt");
		Scanner file = new Scanner(temp);

		// reads words into an array
		int index = 0;
		while (file.hasNextLine())
		{
			String word = file.nextLine();
			words[ index ] = word;
			index ++;
		}

		int numberOfWords = index;
		int randomIndex = (int) (Math.random() * numberOfWords );

		return words[ randomIndex ];
	}

	public static void main(String [] args) throws Exception
	{
		System.out.println( "random word: " + getRandomWord());
	}
}