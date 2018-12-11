/*
 * Class Name:    Poisonous
 *
 * Author:        Your Name
 * Creation Date: Tuesday, May 24 2016, 13:51 
 * Last Modified: Tuesday, May 24 2016, 14:03
 * 
 * Class Description:
 *
 */

public class Poisonous extends Plant
{
   private int dangerRating;
   public Poisonous(String name, String comments, int dangerRating)
   {
      super(name, comments);
      if(dangerRating < 1)
      {
         this.dangerRating = 1;
      }else if(dangerRating > 10)
      {
         this.dangerRating = 10;
      }else
      {
         this.dangerRating = dangerRating;
      }
   }
   public int getDangerRating()
   {
      return dangerRating;
   }
   public void display()
   {
      super.display();
      System.out.println("Danger Rating: " + dangerRating);
   }
}
