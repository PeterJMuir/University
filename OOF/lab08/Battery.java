/*
 * Class Name:    Battery
 *
 * Author:        Your Name
 * Creation Date: Tuesday, April 26 2016, 13:48 
 * Last Modified: Tuesday, April 26 2016, 14:26
 * 
 * Class Description:
 *
 */

public class Battery
{
   private String location;
   private int monthsOfLife;
   private int currentAge;

   public Battery(String location, int monthsOfLife)
   {
      this.location = location;
      if((monthsOfLife > 60) || (monthsOfLife <= 0))
      {
         this.monthsOfLife = 60;
      }else
      {
         this.monthsOfLife = monthsOfLife;
      }
      currentAge = 0;
   }

   public String getLocation()
   {
      return location;
   }

   public int getMonthsOfLife()
   {
      return monthsOfLife;
   }

   public int getCurrentAge()
   {
      return currentAge;
   }

   public void incrementAge()
   {
      ++currentAge;
   }

   public boolean replaceBattery()
   {
      int lifeRemaining = (monthsOfLife - currentAge);
      if(lifeRemaining <= 1)
      {
         return true;
      }else
      {
         return false;
      }
   }

   public String toString()
   {
      return ("[location: " + getLocation() + " monthsOfLife: " + getMonthsOfLife() + " currentAge: " + getCurrentAge() + "]");
   }
}
