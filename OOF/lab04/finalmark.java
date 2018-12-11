/*
 * Class Name:    finalmark
 *
 * Author:        Your Name
 * Creation Date: Tuesday, March 22 2016, 13:56 
 * Last Modified: Tuesday, March 22 2016, 14:03
 * 
 * Class Description:
 *
 */
import java.util.*;
public class finalmark
{
   public static void main(String[] args)
   {
      char grade;
      Scanner kb = new Scanner(System.in);
      System.out.print("Please enter the student's final mark (0 to 100): ");
      int mark = kb.nextInt();
      mark /= 10; //divide by 10 to make the cases easier to work with.
      switch(mark)
      {
         case(10):
         case(9):
         case(8):
            grade = 'A';
            break;
         case(7):
            grade = 'B';
            break;
         case(6):
            grade = 'C';
            break;
         case(5):
            grade = 'D';
            break;
         default:
            grade = 'F';
            break;
      }
      System.out.println("The student's grade is " + grade);
   }
}

