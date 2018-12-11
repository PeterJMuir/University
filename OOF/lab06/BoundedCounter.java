/*
 * Class Name:    BoundedCounter
 *
 * Author:        Your Name
 * Creation Date: Tuesday, April 12 2016, 13:08 
 * Last Modified: Tuesday, April 12 2016, 13:42
 * 
 * Class Description:
 *
 */

public class BoundedCounter
{
   public final int MAXIMUM = 999;
   private int counter;
   public BoundedCounter()
   {
      counter = 0;
   }
   public void next()
   {
      if(counter < MAXIMUM)
      {
      ++counter;
      }
   }
   public void reset()
   {
      counter = 0;
   }
   public int getCounter()
   {
      return counter;
   }
   public String toString()
   {
      String a = "" + counter;
      return a;
   }
}
