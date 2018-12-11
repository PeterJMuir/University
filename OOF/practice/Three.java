/*
 * Class Name:    Three
 *
 * Author:        Your Name
 * Creation Date: Monday, May 30 2016, 11:30 
 * Last Modified: Monday, May 30 2016, 11:37
 * 
 * Class Description:
 *
 */
import java.util.*;
public class Three
{
   public static void main (String[] args)
   {
      for(int i = 1; i < 11; ++i)
      {
         System.out.printf("%-3d %.0f\n",i,Math.pow(i,2));
      }
   }
}
