/*
 * Class Name:    tables
 *
 * Author:        Your Name
 * Creation Date: Tuesday, April 05 2016, 14:21 
 * Last Modified: Tuesday, April 05 2016, 14:27
 * 
 * Class Description:
 *
 */

public class tables
{
   public static void main(String[] args)
   {
      for(int i = 1;i < 13;++i)
      {
         for(int j = 1;j < 13;++j)
         {
            System.out.printf("%4d",(i*j));
         }
         System.out.println();
      }
   }
}
