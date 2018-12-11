/*
 * Class Name:    trial
 *
 * Author:        Your Name
 * Creation Date: Sunday, April 10 2016, 14:03 
 * Last Modified: Sunday, April 10 2016, 14:11
 * 
 * Class Description:
 *
 */

public class trial
{
   public static void main(String[] args)
   {
      String number = "12.67";
      char w = number.charAt(0);
      char x = number.charAt(1);
      char y = number.charAt(2);
      char z = number.charAt(3);
      System.out.println(w);
      System.out.println(x);
      System.out.println(y);
      System.out.println(z);
      double w1 = (w - '0')*10;
      double x1 = (x - '0')*1;
      double y1 = (y - '0')*0.1;
      double z1 = (z - '0')*0.01;
      System.out.println(w1);
      System.out.println(x1);
      System.out.println(y1);
      System.out.println(z1);
      double result = w1 + x1 + y1 + z1;
      System.out.println(result);
   }

}

