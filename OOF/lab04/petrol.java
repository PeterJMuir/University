/*
 * Class Name:    petrol
 *
 * Author:        Your Name
 * Creation Date: Tuesday, March 22 2016, 13:06 
 * Last Modified: Tuesday, March 22 2016, 13:13
 * 
 * Class Description:
 *
 */
import java.util.*;
public class petrol
{
   public static void main(String[] args)
   {
      double costPerLitre = 1.75;
      Scanner kb = new Scanner(System.in);
      System.out.print("How many litres are you purchasing?: ");
      int litres = kb.nextInt();
      int count = 0;
      while(count <= litres)
      {
         System.out.println("Litre " + count + ":\t$" + (count*costPerLitre));
         count++;
      }

   }
}

