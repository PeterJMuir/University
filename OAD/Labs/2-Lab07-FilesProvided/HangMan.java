public class  HangMan
{
	public static final char BLANK = ' ';
	public static final char UNKNOWN_CHARACTER = '-';
	public static final int MAX_ERRORS = 9;
	
	private String word;
	private String maskedWord;
	private String incorrectLetters;
	private int errors;

	HangMan( String word ) 
	{
		this.word = word;

		// form intial word to be displayed ..

		maskedWord = new String();
		for( int i = 0; i < word.length(); i++) 
		{
			maskedWord = maskedWord + (word.charAt(i) == BLANK ? BLANK : UNKNOWN_CHARACTER);	
		}
		
		errors = 0;
		incorrectLetters = new String();
	}

	public void play( char letter ) {
	
		// if letter in word, copy character to maskedWord. 
		// Otherwise, update errors and incorrectletters.

		if ( characterOf( letter, word ) )
		{	
			String oldMaskedWord = maskedWord;
			maskedWord = "";
			for( int i = 0; i < word.length(); i++ )
			{
				if ( word.charAt(i) == letter )
				{
					maskedWord = maskedWord + letter;
				}
				else
				{
					maskedWord = maskedWord + oldMaskedWord.charAt(i);
				}	
			}
		}
		else 
		{	
			errors ++;
			incorrectLetters +=  letter;
		}				
	} // play

		
	private boolean characterOf( char ch , String word ) 
	{
		// returns true if ch is in word, false otherwise

		boolean result = false;
		for( int i = 0; i < word.length(); i++ ) 
			if ( ch == word.charAt(i) )
				result = true;
		return result;
	}

	public  boolean playerWon( ) 
	{
		return word.equals( maskedWord ) ;
	}

	public  boolean playerLost( ) 
	{
		return errors == MAX_ERRORS;
	}
	
	public String getWord()
	{
		return word;
	}
		
	public String getMaskedWord() 
	{
		return maskedWord;
	}

	public int getErrors() 
	{
		return errors;
	}

	public String getIncorrectLetters() 
	{
		return incorrectLetters;
	}	
	
} // class