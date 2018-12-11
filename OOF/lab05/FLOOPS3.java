/*
 * Class Name:    FLOOPS3
 *
 * Author:        Your Name
 * Creation Date: Tuesday, April 05 2016, 13:19 
 * Last Modified: Tuesday, April 05 2016, 13:24
 * 
 * Class Description:
 *
 */

public class FLOOPS3
{
   public static void main(String[] args)
   {
      double balance = 25000;
      System.out.println("Initial investment balance: $" + balance);
      for(int i = 1;i < 11;++i)
      {
         balance *=1.04;
         System.out.println("Investment balance after year " + i + " is: $" + balance);
      }
   }
}
