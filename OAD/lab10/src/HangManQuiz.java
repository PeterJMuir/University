import java.util.Scanner;

public class  HangManQuiz
{
	public static void main( String [ ] args ) throws Exception
	{
		Scanner keyboard = new Scanner(System.in);

		// Read a word at random from the text file HangmanWords.txt
		String word = Helper.getRandomWord();

		// Create a Hangman game and play it
		HangMan game = new HangMan( word );

		while (! game.playerWon() && ! game.playerLost())
		{
			// display necessary information and get a new letter
			System.out.println( "\nMysterious words: " + game.getMaskedWord());
			System.out.println( "Number of errors: " + game.getErrors() );
			System.out.println("Incorrect letters: " + game.getIncorrectLetters());

			// get a letter and play it
			System.out.print("Select a letter: " );
			char letter = keyboard.nextLine().charAt(0);

			game.play( letter );
		}

		// Display result
		if( game.playerWon() )
		{
			System.out.println("\nYou have won!");
		}
		else
		{
			System.out.println( "\nYou have lost!");
		}

		System.out.println( "The word is " + word );
	}
}