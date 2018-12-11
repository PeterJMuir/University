/*
 * Class Name:    Six
 *
 * Author:        Your Name
 * Creation Date: Monday, May 30 2016, 12:04 
 * Last Modified: Monday, May 30 2016, 12:09
 * 
 * Class Description:
 *
 */
import java.util.*;
public class Six
{
   public static void main(String[] args)
   {
      System.out.print("Please enter a grade >> ");
      Scanner kb = new Scanner(System.in);
      String grade = kb.nextLine();
      if(grade.equalsIgnoreCase("high distinction"))
      {
         System.out.println("Very well done");
      }else if(grade.equalsIgnoreCase("pass"))
      {
         System.out.println("well done");
      }else if(grade.equalsIgnoreCase("not pass"))
      {
         System.out.println("need to work harder");
      }else
      {
        System.out.println("Questions are a good thing");
      }
   }
}
