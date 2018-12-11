// Laboratory 09
public class Item
{
   private String description;
   private double price;
   private String barcode;

   public Item(String description, double price, String barcode)
   {
      this.description = description;
      this.price = price;
      this.barcode = barcode;
   }

   public String getDescription()
   {
      return description;
   }

   public double getPrice()
   {
      return price;
   }

   public String getBarcode()
   {
      return barcode;
   }

   public String toString()
   {
      return  getClass().getName() + "["
                                   + " description: " + description
                                   + "\nprice: " + price
                                   + " barcode: " + barcode
                                   + " ]";
   }
}
