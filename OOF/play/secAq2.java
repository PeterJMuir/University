/*
 * Class Name:    secAq2
 *
 * Author:        Your Name
 * Creation Date: Wednesday, June 08 2016, 19:04 
 * Last Modified: Wednesday, June 08 2016, 20:32
 * 
 * Class Description:
 *
 */

public class secAq2
{
   /**
    * Does nothing at all.
    * @param args command line arguments.
    * */
   public static void main(String[] args)
   {
      int duration = 3750;
      int seconds = duration % 60;
      int minutes = (duration/60) %60;
      int hours = (duration/3600)%24;
      int days = duration/(3600*24);
      System.out.println("The event lasts for " + days + " days, "+ hours + " hours, " + minutes + " minutes and " + seconds + " seconds.");
   }
}
