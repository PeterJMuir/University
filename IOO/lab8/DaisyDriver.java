// Laboratory 08 Question 4
public class DaisyDriver
{
   public static void main(String[] args)
   {
      Sellable[] goods = new Sellable[5];

      goods[0] = new Item("123456789012345", "Large Orange Screwdriver", 55.55);
      goods[1] = new Timber("Treated Pine", 4, 18, 325, 11);
      goods[2] = new Item("12312312","Self Sealing Stem Bolts", 0.99);
      goods[3] = new Item("P100000000000", "White & Flattener Corded Drill",
                          123);
      goods[4] = new Timber("Shellacked Window Frame", 2.8, 2.8, 1200, 4);

      double total = 0;
      for (int i = 0; i < goods.length; ++i)
      {
         System.out.println(goods[i].getReceiptLine()); 
         total += goods[i].getPrice();
      }

      for (int i = 0; i < 50; ++i)
      {
         System.out.print("-");
      } 
      System.out.println();

      String priceTotal = String.format("Total $%.2f", total);
      System.out.printf("%50.50s\n", priceTotal);
   }
}
