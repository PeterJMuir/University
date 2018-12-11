/*
 * Class Name:    Timber
 *
 * Author:        Your Name
 * Creation Date: Tuesday, May 02 2017, 14:44 
 * Last Modified: Tuesday, May 02 2017, 14:53
 * 
 * Class Description:
 *
 */

public class Timber implements Sellable
{
   private String type;
   private double thickness, width, length, pricePerMetre;

   public Timber(String type, double thickness, double width, double length, double pricePerMetre)
   {
      this.type = type;
      this.thickness = thickness;
      this.width = width;
      this.length = length;
      this.pricePerMetre = pricePerMetre;
   }

   public String toString()
   {
      return getClass().getName()   + "[\ntype: " + type
                                    + "\nthickness: " + thickness
                                    + "\nwidth: " + width
                                    + "\nlength: " + length
                                    + "\npricePerMetre: " + pricePerMetre
                                    + "\n]";
   }

   public double getPrice()
   {
      return pricePerMetre*(length/100);
   }

   public String getReceiptLine()
   {
      String part1 = String.format ("%.2fm of %.2fcm x %.2fcm %s",
      length/100 , thickness , width , type );
      return String.format("%-41.41s $%7.2f", part1 , getPrice());
   }
}
