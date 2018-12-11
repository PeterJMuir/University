/*
 * Class Name:    Two
 *
 * Author:        Your Name
 * Creation Date: Tuesday, May 31 2016, 08:41 
 * Last Modified: Tuesday, May 31 2016, 08:45
 * 
 * Class Description:
 *
 */
import java.util.*;
public class Two
{
   public static void main(String[] args)
   {
      System.out.print("Enter a Fahrenheit temperature: ");
      Scanner kb = new Scanner(System.in);
      double fahrenheit = kb.nextDouble();
      double celsius = (5 * (fahrenheit - 32))/9;
      System.out.printf("%.2f Fahrenheit is equivalent to %.2f Celsius\n",fahrenheit,celsius);
   }
}
