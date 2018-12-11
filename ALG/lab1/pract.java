/*
 * Class Name:    pract
 *
 * Author:        Your Name
 * Creation Date: Wednesday, November 09 2016, 12:29 
 * Last Modified: Wednesday, November 09 2016, 12:42
 * 
 * Class Description:
 *
 */

import java.util.*;

public class pract
{
   public static void main(String[] args)
   {
   String[] array = {"a", "g", "f", "d", "m", "1"};
   System.out.println(array[0]);
   for(int i = 0; i< (array.length-1); i++)
   {
      System.out.print(array[i+1] + "   ");
      System.out.println(array[i].compareTo(array[i+1]));
   }
   }
}

