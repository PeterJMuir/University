import java.util.*;

public class PPZ
{
   public static void main(String[] args)
   {
      Scanner kbd = new Scanner(System.in);
      System.out.print("Number of Adults: ");
      int numberAdults = kbd.nextInt();
      System.out.print("Number of Children: ");
      int numberChildren = kbd.nextInt();
      int familyTickets;
      if(numberAdults <= numberChildren)
      {
         familyTickets = numberAdults/2;
      }
      else
      {
         familyTickets = numberChildren/2;
      }
      int adultTickets = numberAdults - (2*familyTickets);
      int childTickets = numberChildren - (2*familyTickets);
      int cost = (familyTickets*26)+(adultTickets*10)+(childTickets*5);
      System.out.println();
      if(familyTickets != 0)
      {
         System.out.println("Number of family tickets: "+familyTickets);
      }
      if(adultTickets != 0)
      {
         System.out.println("Number of adult tickets: "+adultTickets);
      }
      if(childTickets != 0)
      {
         System.out.println("Number of child tickets: "+childTickets);
      }
      System.out.println("Total cost: $" +cost);
   }
}
