/*
 * Class Name:    Tank
 *
 * Author:        Your Name
 * Creation Date: Tuesday, March 21 2017, 09:50 
 * Last Modified: Tuesday, March 21 2017, 15:05
 * 
 * Class Description:
 *
 */

public abstract class Tank
{
   private String id;
   private char tankTemperature, tankSalinity;

   public Tank(String id, char tankTemperature, char tankSalinity)
   {
      this.id = id;
      this.tankTemperature = tankTemperature;
      this.tankSalinity = tankSalinity;
   }

   public String getId()
   {
      return this.id;
   }

   public char getTankTemperature()
   {
      return this.tankTemperature;
   }

   public char getTankSalinity()
   {
      return this.tankSalinity;
   }

   public abstract void display();

   public abstract boolean canAddFish(Fish f);

   public abstract boolean addFish(Fish theFish);

   public abstract boolean canRemoveFish(String species);

   public abstract Fish removeFish(String species);
}
