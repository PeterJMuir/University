/*
 * Class Name:    Fridge
 *
 * Author:        Your Name
 * Creation Date: Tuesday, May 03 2016, 13:44 
 * Last Modified: Tuesday, May 03 2016, 14:18
 * 
 * Class Description:
 *
 */
import java.util.*;
public class Fridge
{
   public static void main(String[] args)
   {
      System.out.print("How many hours of data are available? ");
      Scanner kb = new Scanner(System.in);
      int hours = kb.nextInt();
      double[] temp = new double[hours];
      System.out.println("Enter " + hours + " temperature reading(s):");
      for(int i = 0; i < hours; ++i)
      {
         temp[i] = kb.nextDouble();
      }
      System.out.printf("Average Temperature: %.2f\n",calculateAverage(temp));
      System.out.printf("Highest Temperature: %.2f\n",calculateHighest(temp));
      System.out.printf("Lowest Temperature: %.2f\n",calculateLowest(temp));
      differenceFromAverage(temp,calculateAverage(temp));
   }

   public static double calculateHighest(double[] data)
   {
      double max = data[0];
      for(double a : data)
      {
         if(max < a)
         {
            max = a;
         }
      }
      return max;
   }

   public static double calculateLowest(double[] data)
   {
      double min = data[0];
      for(double a : data)
      {
         if(min > a)
         {
            min = a;
         }
      }
      return min;
   }

   public static double calculateAverage(double[] data)
   {
      double avg = 0;
      for(double a : data)
      {
         avg += a;
      }
      return (avg / data.length);
   }

   public static void differenceFromAverage(double[] data, double average)
   {
      for(double a : data)
      {
         System.out.printf("%.2f is %.2f from the average.\n",a,(a - average));
      }
   }
}
