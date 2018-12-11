/*
 * Class Name:    Five
 *
 * Author:        Your Name
 * Creation Date: Monday, May 30 2016, 11:57 
 * Last Modified: Monday, May 30 2016, 12:03
 * 
 * Class Description:
 *
 */
import java.util.*;
public class Five
{
   public static void main(String[] args)
   {
      System.out.print("How many lines should the box be (enter an integer > 2): ");
      Scanner kb = new Scanner(System.in);
      int size = kb.nextInt();
      for(int i = size; i > 0; --i)
      {
         for(int j = size; j > 0; --j)
         {
            System.out.print("*");
         }
         System.out.println();
      }
   }
}
