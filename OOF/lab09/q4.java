/*
 * Class Name:    q4
 *
 * Author:        Your Name
 * Creation Date: Tuesday, May 03 2016, 14:26 
 * Last Modified: Tuesday, May 03 2016, 14:51
 * 
 * Class Description:
 *
 */
import java.util.*;
public class q4
{
   public static void main(String[] args)
   {
      System.out.println("Enter a string:");
      Scanner kb = new Scanner(System.in);
      String myString = kb.nextLine().toLowerCase();
      for(char ch = 'a'; ch <= 'z' ; ++ch)
      {
         int count = 0;
         for(int i = 0; i < myString.length(); ++i)
         {
            if(myString.charAt(i) == ch)
            {
               ++count;
            }
         }
         if(count > 0)
         {
            if(1 == count)
            {
               System.out.println(ch + " occurs once.");
            }else
            {
               System.out.println(ch + " occurs " + count + " times.");
            }
         }
      }
   }
}
