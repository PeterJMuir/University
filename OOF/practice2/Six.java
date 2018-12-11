/*
 * Class Name:    Six
 *
 * Author:        Your Name
 * Creation Date: Tuesday, May 31 2016, 08:54 
 * Last Modified: Tuesday, May 31 2016, 09:00
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
      grade = grade.toLowerCase();
      if(grade.equals("high distinction"))
      {
         System.out.println("Very well done");
      }else if(grade.equals("pass"))
      {
         System.out.println("well done");
      }else if(grade.equals("not pass"))
      {
         System.out.println("need to work harder");
      }else
      {
         System.out.println("Questions are a good thing");
      }
   }
}
