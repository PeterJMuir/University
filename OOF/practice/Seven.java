/*
 * Class Name:    Seven
 *
 * Author:        Your Name
 * Creation Date: Monday, May 30 2016, 12:10 
 * Last Modified: Monday, May 30 2016, 12:23
 * 
 * Class Description:
 *
 */
import java.util.*;
public class Seven
{
   public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
      boolean valid = false;
      while(!valid)
      {
         System.out.print("Enter ticket >> ");
         String input = kb.nextLine();
         char[] ticket = new char[5];
         for(int i = 0; i < ticket.length; ++i)
         {
            ticket[i] = input.charAt(i);
         }
         if((ticket[0] >= 'A') && (ticket[0] <= 'Z'))
         {
            if((ticket[1] >= '1') && (ticket[1] <= '9'))
            {
               if((ticket[2] >= '1') && (ticket[2] <= '9'))
               {
                  if((ticket[3] >= '1') && (ticket[3] <= '9'))
                  {
                     if((ticket[4] >= 'a') && (ticket[4] <= 'z'))
                     {
                        valid = true;
                     }else
                     {
                        System.out.println("Ticket must have lowercase character as the fifth character");
                     }
                  }else
                  {
                     System.out.println("Ticket must have a digit as the fourth character");
                  }
               }else
               {
                  System.out.println("Ticket must have a digit as the third character");
               }
            }else
            {
               System.out.println("Ticket must have a digit as the second character");
            }
         }else
         {
            System.out.println("Ticket must start with an uppercase character");
         }
      }
      System.out.println("Ticket is valid");
   }
}
