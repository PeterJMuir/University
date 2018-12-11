import java.util.*;

public class Seven
{
   public static void main( String [ ] args )
   {
      Scanner kb = new Scanner( System.in );

      // assume ticket length is always entered as 5
      boolean valid = false;
      while( !valid )
      {
         valid = true;                                                         
         System.out.print("Enter ticket >> ");
         String ticket = kb.nextLine( ); 
         if( ticket.charAt( 0 ) < 'A' 
               || ticket.charAt( 0 ) > 'Z' )
         {
            valid  = false; 
            System.out.println("Ticket must start with an" + 
                  " uppercase character"); 
         } 
         // This is solving this the long way, a for loop would 
         // be better and quicker for the three digits 
         if( valid && ( ticket.charAt( 1 ) < '0' || 
                  ticket.charAt( 1 ) > '9' )) 
         { 
            valid = false; 
            System.out.println("Ticket must have a digit as" + 
                  " the second character" ); 
         }
         if( valid && ( ticket.charAt( 2 ) < '0' || 
                  ticket.charAt( 2 ) > '9' )) 
         { 
            valid = false; 
            System.out.println("Ticket must have a digit as" + 
                  " the third character" ); 
         } 
         if( valid && ( ticket.charAt( 3 ) < '0' || 
                  ticket.charAt( 3 ) > '9' )) 
         { 
            valid = false; 
            System.out.println("Ticket must have a digit as" +
                  " the fourth character" );
         }
         if( valid && ( ticket.charAt( 4 ) < 'a' || 
                  ticket.charAt( 4 ) > 'z'  )) 
         { 
            System.out.println("Ticket must have " + 
                  "lowercase character as the " + 
                  "fifth character"); 
            valid = false; 
         } 
      } 
      System.out.println( "Ticket is valid" ); 
   } 
}
