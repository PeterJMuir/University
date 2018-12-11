/*
 * Class Name:    Codes
 *
 * Author:        Peter Muir
 * Creation Date: Wednesday, March 16 2016, 12:26 
 * Last Modified: Sunday, April 10 2016, 18:16
 * 
 * Class Description: Outputs the data on the matching Station Name.
 *
 */
import java.util.*;
import java.io.*;
public class Codes
{
   public static void main(String[] args) throws IOException
   {
      System.out.print("Please enter a file name: ");
      Scanner kbd = new Scanner(System.in);
      File fileOpen = new File(kbd.nextLine());
      Scanner fileInput = new Scanner(fileOpen);
      if(fileInput.hasNextLine() == true)                //if the file is not empty, run the program
      {
      System.out.print("Please enter a station name: ");
      String stName = kbd.nextLine();
      String info = "";
      String name = "";

while((stName.equalsIgnoreCase(name)) == false && (fileInput.hasNextLine() == true))          //if the names are equal, we have found the match. Else, keep searching until EOF.
{
         info = fileInput.nextLine();           //take next line
         int i = info.indexOf(':');             //find first colon
         name = info.substring(0,i);     //take the station name of the line
}
      if(stName.equalsIgnoreCase(name) == true)       //if the program found the match
      {
         int i = 0, j = 0;
         j = info.indexOf(":",0);
         i = info.indexOf(":",j+1);
         String code = info.substring(j+1,i);
         j = info.indexOf(":",i+1);
         String line = info.substring(i+1,j);
         String distance = info.substring(j+1);
         System.out.println("Station Name: \"" + name + "\"");
         System.out.println("Unique Code: \"" + code + "\"");
         System.out.println("Line Name: \"" + line + "\"");
         System.out.println("Station Distance: " + distance + " km");
      }
      else                                         //if the program did not find anything
      {
         System.out.println("There was no match.");
      }
      }else                                        //if the file is empty
      {
         System.out.println("The file is empty");
      }

      fileInput.close();
   }
}

