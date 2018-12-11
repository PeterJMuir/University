/*
 * Class Name:    Colony
 *
 * Author:        Your Name
 * Creation Date: Tuesday, April 12 2016, 13:56 
 * Last Modified: Tuesday, April 12 2016, 14:52
 * 
 * Class Description:
 *
 */

public class Colony
{
   final int START_PAIRS = 1;
   private int month;
   private int newBornPairs;
   private int oneMonthPairs;
   private int maturePairs;

   public Colony()
   {
      month = 2;
      newBornPairs = 0;
      oneMonthPairs = 1;
      maturePairs = 0;
   }

   public void aheadAMonth()
   {
      ++month;
      maturePairs += oneMonthPairs;
      oneMonthPairs = newBornPairs;
      newBornPairs = maturePairs;
   }

   public int getMonth()
   {
      return month;
   }

   public int getNewBornPairs()
   {
      return newBornPairs;
   }

   public int getOneMonthPairs()
   {
      return oneMonthPairs;
   }

   public int getMaturePairs()
   {
      return maturePairs;
   }

   public int getPopulation()
   {
      return ((newBornPairs + oneMonthPairs + maturePairs)*2);
   }

   public String toString()
   {
      String all = "Month: " + month + "\nNew Born Pairs: " + newBornPairs + "\nOne Month Pairs: " + oneMonthPairs + "\nMature Pairs: " + maturePairs + "\nPopulation: " + getPopulation() + "\n";
      return all;
   }
}
