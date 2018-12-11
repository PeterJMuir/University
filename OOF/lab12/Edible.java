/*
 * Class Name:    Edible
 *
 * Author:        Your Name
 * Creation Date: Tuesday, May 24 2016, 13:43 
 * Last Modified: Tuesday, May 24 2016, 14:02
 * 
 * Class Description:
 *
 */

public class Edible extends Plant
{
   private String season;
   private boolean canHarvest;

   public Edible(String name, String comments, String season, Boolean canHarvest)
   {
      super(name,comments);
      this.season = season;
      this.canHarvest = canHarvest;
   }

   public String getSeason()
   {
      return season;
   }

   public boolean getCanHarvest()
   {
      return canHarvest;
   }

   public void display()
   {
      super.display();
      System.out.println("Season: " + season + "\nReady to harvest: " + canHarvest);
   }
}
