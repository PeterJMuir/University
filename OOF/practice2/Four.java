/*
 * Class Name:    Four
 *
 * Author:        Your Name
 * Creation Date: Tuesday, May 31 2016, 08:48 
 * Last Modified: Tuesday, May 31 2016, 08:51
 * 
 * Class Description:
 *
 */
import java.util.*;
public class Four
{
   public static void main(String[] args)
   {
      System.out.print("Enter sentence >> ");
      Scanner kb = new Scanner(System.in);
      String input = kb.nextLine();
      String word1 = input.split(" ",2)[0];
      String word2 = input.split(" ",2)[1];
      if(word1.length() >= word2.length())
      {
         System.out.println(word1);
      }else
      {
         System.out.println(word2);
      }
   }
}
