/*
 * Class Name:    FourAlt
 *
 * Author:        Your Name
 * Creation Date: Monday, May 30 2016, 11:38 
 * Last Modified: Monday, May 30 2016, 11:56
 * 
 * Class Description:
 *
 */
import java.util.*;
public class FourAlt
{
   public static void main(String[] args)
   {
      System.out.print("Enter sentence >> ");
      Scanner kb = new Scanner(System.in);
      String input = kb.nextLine();
      int index = input.indexOf(" ");
      String word1 = input.substring(0,index);
      String word2 = input.substring(index+1);
      int cmp = word1.length() - word2.length();
         if(cmp >= 0)
         {
            System.out.println(word1);
         }else if(cmp < 0)
         {
            System.out.println(word2);
         }
   }
}
