import java.io.*;
import java.util.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/*
 * Modified Mar 06 2008
 * BufferedReader replaced with Scanner
 * FileReader replaced with File
 * StringTokenizer replaced with split method from String class
 * try ... catch block added to avoid program having a problem 
 * attempting to read a non-existent blank line at the end
 * of the input data files
 */

public class GnomeSortPeopleJSON  
{
   /* Driver program
    * - Loads people from the first file name specified
    * - Stores them in a vector
    * - Writes the sorted people to the second file specified
    * - Displays to screen the number of comparisons in the sort
    */

   public static void main(String[] args) throws Exception
   {
      Vector<Person> people = new Vector<Person>();

      if (args.length != 2)
      {
         System.out.println("Usage: GnomeSortPeople <input file> <output file>");
         System.exit(1);
      }
      String inputFileName = args[0];
      String outputFileName = args[1]; 

      loadData(inputFileName, people);

      Person.resetCounter(); 
      Sorter.gnomeSort(people);
      System.out.println("There were " + Person.getCounter() +
            " comparisons to sort " + people.size() + 
            " people with Gnome Sort");

      writeData(outputFileName, people);
   } 

   public static void loadData(String fileName, Vector<Person> people) 
      throws IOException
      {
         File inStream = new File( fileName );
         Scanner reader = new Scanner(inStream);
         String JsonString = "";
         while (reader.hasNext())
         {
            JsonString += reader.nextLine();
         }
         Gson gson = new Gson();
         Person[] tempPeople = gson.fromJson(JsonString, Person[].class);
         if (tempPeople == null) System.out.println("tempPeople is null");
         people.addAll(Arrays.asList(tempPeople));
         reader.close();
      }
   public static void writeData(String fileName, Vector<Person> people) 
      throws IOException
      {
         PrintWriter outFile = new PrintWriter(new File(fileName));

         Gson gsonObject = new GsonBuilder().setPrettyPrinting().create();
         String jsonString = gsonObject.toJson(people);
         outFile.println(jsonString);

         outFile.close();
      }
}
