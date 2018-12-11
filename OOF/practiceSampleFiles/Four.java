import java.util.*;
public class Four
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Enter a sentence >> ");
      String sentence = keyboard.nextLine();
      
      // First thing that we need to do is extract the 2 words
      // from the sentence.
      //
      // If you know how the split method works in the String class
      // then this is a good choice, especially as we now know how
      // arrays work.
      //
      // We will show an alternate way of doing this, based on
      // Lecture/Workshop 2 - the String class
      //
      // first find the index of the space
      int space = sentence.indexOf( ' ' );

      // now we can extract the 2 words
      String word1 = sentence.substring( 0, space );
      String word2 = sentence.substring( space + 1 );

      // now compare the lengths of the 2 words
      if( word1.length( ) >= word2.length( ) )
      {
         System.out.println( word1 );
      }
      else
      {
         System.out.println( word2 );
      }

   } 
}
