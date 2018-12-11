/*
 * Class Name:    absolute
 *
 * Author:        Your Name
 * Creation Date: Tuesday, April 05 2016, 14:30 
 * Last Modified: Tuesday, April 05 2016, 14:34
 * 
 * Class Description:
 *
 */
import java.util.*;
public class absolute
{
   public static void main(String[] args)
   {
      System.out.print("Enter an integer: ");
      Scanner kb = new Scanner(System.in);
      int x = kb.nextInt();
      int x1 = (x >= 0) ? x : -x;
      System.out.println("The absolute value of " + x + " is " + x1);
   }
}
