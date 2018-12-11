import java.util.*;
public class Six
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Please enter a grade >> ");
      String grade = keyboard.nextLine( );

      // We could use .equalsIgnoreCase in our if statements
      // but the easiest way is convert the user input to all
      // upper case or lower case. That way we only need to
      // use equals( ) and we save ourselves time by having
      // to write only half the if statements ( no &&'s) 
      //
      // This question could also be solved using the a switch
      // statement. If you use the switch statement, which is
      // actually easier than the if/else-if, then you really
      // must convert all the user input to one case, 
      // which can be done on the input line or in the
      // condition of the switch, otherwise you will have to
      // write many, many case statements to cover all the 
      // possible combinations of entering the input.

      // convert the input to all lowercase.
      grade = grade.toLowerCase( );

      if( grade.equals( "high distinction" ) )
      {
         System.out.println("Very well done" );
      }
      else if( grade.equals( "pass" ) )
      {
         System.out.println("well done" );
      }
      else if( grade.equals( "not pass" ) )
      {
         System.out.println("need to work harder" );
      }
      else
      {
         System.out.println("Questions are a good thing" );
      }
      
   } 
}
