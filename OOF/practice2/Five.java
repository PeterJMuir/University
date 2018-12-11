/*
 * Class Name:    Five
 *
 * Author:        Your Name
 * Creation Date: Tuesday, May 31 2016, 08:52 
 * Last Modified: Tuesday, May 31 2016, 08:54
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
