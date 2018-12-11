/*
 * Class Name:    Two
 *
 * Author:        Your Name
 * Creation Date: Monday, May 30 2016, 11:22 
 * Last Modified: Monday, May 30 2016, 11:29
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
      double ftemp = kb.nextDouble();
      double ctemp = (ftemp - 32)*((double)5/9);
      System.out.printf("%.2f Fahrenheit is equivalent to %.2f Celsius\n",ftemp,ctemp);
   }
}
