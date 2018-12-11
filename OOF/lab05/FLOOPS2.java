/*
 * Class Name:    FLOOPS2
 *
 * Author:        Your Name
 * Creation Date: Tuesday, April 05 2016, 13:10 
 * Last Modified: Tuesday, April 05 2016, 13:17
 * 
 * Class Description:
 *
 */
import java.util.*;
public class FLOOPS2
{
   public static void main(String[] args)
   {
   System.out.print("Enter number of # to be displayed: ");
   Scanner kb = new Scanner(System.in);
   for(int i = kb.nextInt();i > 0;--i)
   {
      System.out.print("#");
   }
   System.out.println();
   }
}
