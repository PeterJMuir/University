/*
 * Class Name:    task4
 *
 * Author:        Your Name
 * Creation Date: Tuesday, April 05 2016, 13:25 
 * Last Modified: Tuesday, April 05 2016, 14:18
 * 
 * Class Description:
 *
 */
import java.util.*;
public class task4
{
   public static void main(String[] args)
   {
      System.out.println("Test for a palindrome:");
      Scanner kb = new Scanner(System.in);
      String pal = kb.nextLine();
      int palLength = pal.length();
      String lap = "";
      for(int i = palLength;i > 0;--i)
      {
         String temp = pal.substring((i-1),(i));
         lap = lap.concat(temp);
      }
      if(pal.compareTo(lap) == 0)
      {
         System.out.println(pal + " is a palindrome");
      }
      else
      {
         System.out.println(pal + " is not a palindrome");
      }
   }
}
