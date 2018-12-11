/*
 * Class Name:    Rocks
 *
 * Author:        Your Name
 * Creation Date: Tuesday, May 02 2017, 14:56 
 * Last Modified: Tuesday, May 02 2017, 15:07
 * 
 * Class Description:
 *
 */

public class Rocks implements Sellable, HasMass
{
   private String description;
   private double pricePerCubicMetre;
   private double purchasedVolume;

   public Rocks(String description, double pricePerCubicMetre, double purchasedVolume)
   {
      this.description = description;
      this.pricePerCubicMetre = pricePerCubicMetre;
      this.purchasedVolume = purchasedVolume;
   }

   public String toString()
   {
      return getClass().getName()   + "[\ndescription: " + description
                                    + "\npricePerCubicMetre: " + pricePerCubicMetre
                                    + "\npurchasedVolume: " + purchasedVolume
                                    + "\n]";
   }

   public double getPrice()
   {
      return pricePerCubicMetre * purchasedVolume;
   }

   public double getVolume()
   {
      return purchasedVolume;
   }

   public String getReceiptLine()
   {
      String part1 = String.format("%.2f cubic metres of %s",getVolume(),description);
      return String.format("%-41.41s $%7.2f",part1,getPrice());
   }
}
