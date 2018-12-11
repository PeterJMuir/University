/*
 * Class Name:    taylorA
 *
 * Author:        Your Name
 * Creation Date: Tuesday, March 22 2016, 14:08 
 * Last Modified: Tuesday, March 22 2016, 14:58
 * 
 * Class Description:
 *
 */
import java.util.*;
public class taylorA
{
   public static void main(String[] args)
   {
   double e = 0; //calculated exponential
   long fact = 1;
   Scanner kb = new Scanner(System.in);
   System.out.print("Enter your x value: ");
   double x = kb.nextDouble();
   for(int n = 0; n < 11; n++)//exp
   {
      if(n == 0)
      {
         fact = 1;
      }
      else
      {
      fact *= n;
      }
      e += (Math.pow(x,n))/(fact);
   }
   for(int n = 0,long factCos = 1; n < 11; n++)//cos(x)
   {
      factCos = 1;
      if(n == 0)
      {
         factCos = 1;
      }
      else
      {
      for(int i = 2*n;i > 1;i--)
      {
         factCos *= i
      }
      }
      e += (Math.pow(x,n))/(factCos);
   }
   System.out.println("Estimated value = " + e);
   System.out.println("Expected value = " + (Math.exp(x)));
   }
}

