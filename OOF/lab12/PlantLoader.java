import java.util.*;
import java.io.*;
public class PlantLoader
{
   public static Plant[] loadFromFile(String filename) throws IOException
   {
      // Open file for reading
      Scanner fileInput = new Scanner(new File(filename));
      // Read number of plants in file
      int numRecords = fileInput.nextInt();
      fileInput.nextLine();
      // Initialise array of plants
      Plant planty[] = new Plant[numRecords];
      // Read in
      for(Plant a : planty)
      {
         String type = fileInput.nextLine();
         String name = fileInput.nextLine();
         String comments = fileInput.nextLine();
         if(type.equals("Plant"))
         {
            a = new Plant(name,comments);
         }else if(type.equals("Poisonous"))
         {
            int dangerRating = fileInput.nextInt();
            fileInput.nextLine();
            a = new Poisonous(name,comments,dangerRating);
         }else if(type.equals("Edible"))
         {
            String season = fileInput.nextLine();
            boolean canHarvest = fileInput.nextBoolean();
            fileInput.nextLine();
            a = new Edible(name,comments,season,canHarvest);
         }else
         {
            System.out.println("Unknown plant type: \"" + type + "\" found in file.");
         }
         //a.display();
      }
      // Close the file and return the array
      fileInput.close();
      return planty;
   }

   public static void main(String[] args) throws IOException
   {
      if (args.length < 1)
      {
         System.out.println
                ("Error! Command line argument for filename not given!");
         System.exit(0);
      }else if(args.length > 1)
      {
         System.out.println("Error! Too many command line arguments! (Give only one)");
         System.exit(0);
      }else
      // Call method to load plants from file
      // then display to screen
      {
         Plant planty[] = loadFromFile(args[0]);
        /* if( planty[1] instanceof Edible)
         {
            System.out.println("YUP");
            ((Edible)planty[1]).display();
         }*/

         /*for( Plant a : planty)
         {
            a.display();
         }*/
      }
      
   }
}
