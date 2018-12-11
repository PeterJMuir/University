/*
 * Class Name:    ManySpeciesTank
 *
 * Author:        Your Name
 * Creation Date: Tuesday, March 21 2017, 14:09 
 * Last Modified: Tuesday, March 21 2017, 15:34
 * 
 * Class Description:
 *
 */

public class ManySpeciesTank extends Tank
{
   private final int SMALL = 3;
   private final int MEDIUM = 6;
   private final int LARGE = 10;
   private Fish[] fish;
   private int numberOfFish;
   private int maxFish;

   public ManySpeciesTank(String id, char tankTemperature, char tankSalinity, char size)
   {
      super(id, tankTemperature, tankSalinity);
      switch(size)
      {
         case 's':
         case 'S':
            fish = new Fish[SMALL];
            maxFish = SMALL;
            break;
         case 'm':
         case 'M':
            fish = new Fish[MEDIUM];
            maxFish = MEDIUM;
            break;
         case 'l':
         case 'L':
            fish = new Fish[LARGE];
            maxFish = LARGE;
            break;
         default:
            fish = new Fish[0];
            maxFish = 0;
      }
      numberOfFish = 0;
   }

   public void display()
   {
      String temp = "";
      for(int i = 0; i < maxFish; i++)
      {
         if(fish[i] != null)
         {
            temp += fish[i].toString();
         }
      }

      System.out.println(getClass().getName() + ": tankId " + getId() + "\n" + temp);
   }

   public boolean canAddFish(Fish theFish)
   {
      return ( (theFish.waterSuitable( getTankTemperature(), getTankSalinity() ) ) && ( numberOfFish < maxFish ) );
   }

   public boolean canRemoveFish(String species)
   {
      for(int i = 0; i < fish.length; i++)
      {
         if(fish[i] != null)
         {
            if(fish[i].getSpecies().equals(species))
            {
               return true;
            }
         }
      }
      return false;
   }

   public boolean addFish(Fish theFish)
   {
      if(canAddFish(theFish))
      {
         int i;
         for(i = 0; (i < fish.length) && (fish[i] != null); i++);
         fish[i] = theFish;
         numberOfFish++;
         return true;
      }else return false;
   }

   public Fish removeFish(String species)
   {
      if(canRemoveFish(species))
      {
         int i;
         for(i = 0; i < maxFish; i++)
         {
            if(fish[i] != null)
            {
               if(fish[i].getSpecies().equals(species))
               {
                  Fish theFish = fish[i];
                  fish[i] = null;
                  numberOfFish--;
                  return theFish;
               }
            }
         }
      }
      return null;
   }
}

