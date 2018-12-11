/*
 * Class Name:    ENUM
 *
 * Author:        Your Name
 * Creation Date: Wednesday, June 08 2016, 18:57 
 * Last Modified: Wednesday, June 08 2016, 19:00
 * 
 * Class Description:
 *
 */

public class ENUM
{
   enum Temperature {HOT, WARM, MILD, COOL, COLD}

   public static void main(String[] args)
   {
//      int t1 = Temperature.valueOf("HOT");
      System.out.println(Temperature.valueOf("HOT"));
   }
}
