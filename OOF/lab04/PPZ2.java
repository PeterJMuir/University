/*
 * Class Name:    PPZ2
 *
 * Author:        Your Name
 * Creation Date: Tuesday, March 22 2016, 13:19 
 * Last Modified: Tuesday, March 22 2016, 13:52
 * 
 * Class Description:
 *
 */
import java.util.*;
public class PPZ2
{
   public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
      String selection;
      int adultTickets = 0, childTickets = 0, familyTickets = 0, cost = 0;
      do
      {
         System.out.println("Ticket menu:\nA - Adult ticket\nC - Child ticket\nF - Family ticket\nQ - Quit");
         System.out.print("Selection is: ");
         selection = kb.next();
         switch(selection)
         {
            case "A":
            case "a":
               ++adultTickets;
               break;
            case "C":
            case "c":
               ++childTickets;
               break;
            case "F":
            case "f":
               ++familyTickets;
               break;
            default:
               break;
         }
         System.out.printf("\n%d adult tickets, %d child tickets, %d family tickets\n\n",adultTickets,childTickets,familyTickets);
      }while(selection.compareToIgnoreCase("q") != 0);
      cost = (adultTickets*10) + (childTickets*5) + (familyTickets*26);
      System.out.println("\n Receipt:\n----------");
      System.out.printf("%d adult tickets\n%d child tickets\n%d family tickets\n----------\n",adultTickets,childTickets,familyTickets);
      System.out.println("Total: $" + cost);
   }
}

