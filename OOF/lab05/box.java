/*
 * Class Name:    box
 *
 * Author:        Your Name
 * Creation Date: Tuesday, April 05 2016, 14:35 
 * Last Modified: Tuesday, April 05 2016, 14:52
 * 
 * Class Description:
 *
 */
import java.util.*;
public class box
{
   public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
      System.out.print("How big is the box? ");
      int size = kb.nextInt();
      for(int i = 1;i <= size;++i)
      {
         for(int j = 1;j <= size;++j)
         {
            if(j == 1 ||j == size || i == 1 || i == size)
            {
               System.out.print(" *");
            }
            else
            {
               System.out.print("  ");
            }
         }
         System.out.println();
      }
   }
}
