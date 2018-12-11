import java.io.*;
import java.util.*;

/*
 * Modified Mar 06 2008
 * BufferedReader replaced with Scanner
 * FileReader replaced with File
 * StringTokenizer replaced with split method from String class
 * try ... catch block added to avoid program having a problem 
 * attempting to read a non-existent blank line at the end
 * of the input data files
*/

public class QuickSortPeople
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
         System.out.println("Usage: QuickSortPeople <input file> <output file>");
         System.exit(1);
      }
      String inputFileName = args[0];
      String outputFileName = args[1]; 

      loadData(inputFileName, people);

      Person.resetCounter(); 
      Sorter.quickSort(people, 0, people.size()-1);
      System.out.println("There were " + Person.getCounter() +
                         " comparisons to sort " + people.size() + 
                         " people with Quick Sort");

      writeData(outputFileName, people);
   } 
   
   public static void loadData(String fileName, Vector<Person> people) 
                      throws IOException
   {
      File inStream = new File( fileName );
      Scanner reader = new Scanner( inStream );
      
      String name = "";
      String address = "";
      String suburb = "";
      String state = "";
      String temp = "";
      String firstName = "";
      int postCode = 0;
      
      boolean more = false;
      if( reader.hasNext() )
      {
         more = true;
      }
      
      while( more )
      {
         name = reader.nextLine();
         String [ ] tokens = name.split(",");
         
         name = tokens[0];
         firstName = tokens[1];
         
         address = reader.nextLine();

         temp = reader.nextLine();
         
         String [ ] st = temp.split("\\t");
         
         suburb = st[0];
         
         state = st[1];
         
         postCode = Integer.parseInt(st[2]);
         
         people.addElement(new Person(firstName, name, address, suburb, 
                              state, postCode));
         
         /*
          * We have to read out and discard the blank line that separates 
          * every record, except the last record.
          * If we don't do something then this line will cause an exception
          * at the end of reading the input file and crash the program.
          *
          * A try/catch block is used as it is one of the least expensive
          * (in terms of program execution time) ways of dealing with 
          * this problem. The normal flow of the program is interrupted
          * just once, at the very end.
          *
          * We could put in an if statement, such as
          * if( reader.hasNext())
          * {
          *     reader.nextLine();
          * {
          * else
          * {
          *   more = false;
          * }
          *
          * but then we have to call the hasNext() method every time through
          * the loop, which is much more expensive (slower) in terms of
          * program execution.
          */ 
         
         try
         {
              reader.nextLine();
         }
         catch( NoSuchElementException nsee )
         {
              more = false;
         }
      }
      
      reader.close();
   }
   
   public static void writeData(String fileName, Vector<Person> people) 
                      throws IOException
   {
      PrintWriter outFile = new PrintWriter(new File(fileName));
      
      for (Person p: people)
      {
         outFile.println(p);
      }
      
      outFile.close();
   }
}
