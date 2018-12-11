import java.util.*;
import java.io.*;
public class OOSDriver1
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      Scanner inputStream = null;
      StockList stockList = new StockList();
      
      try
      {
         inputStream = new Scanner(new FileInputStream("OOSItems.txt"));
         stockList.display();

         while (inputStream.hasNextLine())
         {
            String description = inputStream.nextLine();
            double price = inputStream.nextDouble();
            inputStream.nextLine(); // read over \n
            String barcode = inputStream.nextLine();
            Item item = new Item(description, price, barcode);
            stockList.addToFront(item);
            System.out.println("\nNew item added...");
            stockList.display();
         }
         inputStream.close();

         System.out.println("\nFile loaded...");

         System.out.print("Do you wish to search for an item? (y/n): ");
         char response = keyboard.nextLine().charAt(0);

         while (response == 'y')
         {
            System.out.print("Enter barcode of item: ");
            String barcode = keyboard.nextLine();
            Item item = stockList.find(barcode);
            if (item == null)
            {
               System.out.println("No item with barcode " + barcode);
            }
            else
            {
               System.out.println(item);
            }
            System.out.print("Search again? (y/n): ");
            response = keyboard.nextLine().charAt(0);
         }
      }
      catch(FileNotFoundException e)
      {
         System.out.println(e.getMessage() + " ...no items to load...");
      }
   }
}
