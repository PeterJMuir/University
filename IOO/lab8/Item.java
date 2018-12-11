/*
 * Class Name:    Item
 *
 * Author:        Your Name
 * Creation Date: Tuesday, May 02 2017, 14:23 
 * Last Modified: Tuesday, May 02 2017, 14:43
 * 
 * Class Description:
 *
 */

public class Item implements Sellable
{
   private String barcode;
   private String description;
   private double unitPrice;

   public Item(String barcode, String description, double unitPrice)
   {
      this.barcode = barcode;
      this.description = description;
      this.unitPrice = unitPrice;
   }

   public String toString()
   {
      return getClass().getName() + "[\nbarcode: " + barcode
         + "\ndescription: " + description
         + "\nunitPrice: " + unitPrice
         + "\n]";
   }

   public double getPrice()
   {
      return unitPrice;
   }

   public String getReceiptLine()
   {
      return String.format("%13.13s: %-26.26s $%7.2f",barcode, description, unitPrice);
   }
}
