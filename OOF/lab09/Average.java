/*
 * Class Name:    Average
 *
 * Author:        Your Name
 * Creation Date: Tuesday, May 03 2016, 13:07 
 * Last Modified: Tuesday, May 03 2016, 13:40
 * 
 * Class Description:
 *
 */
import java.util.*;
public class Average
{
   public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
      System.out.println("Please enter ten numbers: ");
      int[] numbers = new int[10];
      for(int i = 0; i < numbers.length; ++i)
      {
         numbers[i] = kb.nextInt();
      }
      double average = calculateAverage(numbers);
      System.out.println("Average: " + average);
      System.out.println("Above Average: " + totalAboveAverage(numbers,average)); 
      System.out.println("Below Average: " + totalBelowAverage(numbers,average));
   }

   public static double calculateAverage(int[] data)
   {
      double avg = 0;
      for(int a : data)
      {
         avg += a;
      }
      return (avg / data.length);
   }

   public static int totalBelowAverage(int[] data, double average)
   {
      int total = 0;
      for(int i : data)
      {
         if(i < average)
         {
            ++total;
         }
      }
      return total;
   }

   public static int totalAboveAverage(int[] data, double average)
   {
      int total = 0;
      for(int i : data)
      {
         if(i > average)
         {
            ++total;
         }
      }
      return total;
   }

}
