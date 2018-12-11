/*
 * Class Name:    OneSpeciesTank
 *
 * Author:        Your Name
 * Creation Date: Tuesday, March 21 2017, 09:56 
 * Last Modified: Tuesday, March 21 2017, 15:27
 * 
 * Class Description:
 *
 */

public class OneSpeciesTank extends Tank
{
   private final int MAX_FISH = 6;
   private Fish[] fish;
   private int numberOfFish;

   public OneSpeciesTank(String id, char tankTemperature, char tankSalinity)
   {
      super(id,tankTemperature,tankSalinity);
      fish = new Fish[MAX_FISH];
      numberOfFish = 0;
   }

   public void display()
   {
      String temp = "";
      for(int i = 0; i < numberOfFish; i++)
      {
         temp += fish[i].toString();
      }

      System.out.println(getClass().getName() + ": tankId " + getId() + "\n" + temp);
   }

   public boolean canAddFish(Fish theFish)
   {
      if (theFish.waterSuitable( getTankTemperature(), getTankSalinity() ) && (numberOfFish < MAX_FISH) )
      {
         for(int i = 0; i < MAX_FISH; i++)
         {
            if(fish[i] != null)
            {
               if( !(fish[i].getSpecies().equals(theFish.getSpecies()) ))
               {
                  return false;
               }
            }
         }
         return true;
      }
      return false;
   }


   public boolean canRemoveFish(String species)
   {
      for(int i = 0; i < fish.length;i++)
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
         if(i < fish.length)
         {
            fish[i] = theFish;
            numberOfFish++;
            return true;
         }
      }
      return false;
   }

   public Fish removeFish(String species)
   {
      if(canRemoveFish(species))
      {
         int i;
         for(i = 0; i < fish.length; i++)
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
