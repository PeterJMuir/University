/*
 * Class Name:    Stations
 *
 * Author:        Peter Muir
 * Creation Date: Sunday, April 10 2016, 13:24 
 * Last Modified: Sunday, April 10 2016, 18:10
 * 
 * Class Description: Outputs station data for all stations under the user
 * inputted distance.
 *
 */
import java.util.*;
import java.io.*;
public class Stations
{
   public static void main(String[] args) throws IOException
   {
      System.out.print("Please enter a file name: ");
      Scanner kbd = new Scanner(System.in);
      File fileOpen = new File(kbd.nextLine());
      Scanner fileInput = new Scanner(fileOpen);

      if(fileInput.hasNextLine() == true)   //if the file is not empty
      {
         System.out.print("Please enter a distance: ");
         double userDistance = kbd.nextDouble();
         String info = "";
         boolean flag = false;
         System.out.print("\nThe stations within " + userDistance + " km are ");


         while(fileInput.hasNextLine() == true)             //run until EOF
         {
            info = fileInput.nextLine();
            int i = info.lastIndexOf(':');                  //find the last colon to find the distance
            double distance = 0;
            for(double j = 10;j > 0.001; j /= 10, ++i)      //loop converts the distance string into a double
            {
               char ch = info.charAt(i+1);
               while('9' < ch || ch < '0')                  //when ch is not a digit, this loop will run
               {                                            //this omits the decimal point from being converted
                  ++i;
                  ch = info.charAt(i+1);
               }
                  double convert = (ch - '0')*j;
               distance += convert;
            }

            if(userDistance >= distance)                    //for all lines, check that the inputted distance is
            {                                               //greater than the distance found on that line
               int x = 0, y = 0;
               x = info.indexOf(':');
               String name = info.substring(0,x);
               y = info.indexOf(':',x+1);
               String code = info.substring(x+1,y);
               x = info.indexOf(':',y+1);
               String line = info.substring(y+1,x);
               System.out.println("\nStation Name: \"" + name + "\"");
               System.out.println("Unique Code: \"" + code + "\"");
               System.out.println("Line Name: \"" + line + "\"");
               System.out.printf("Station Distance: %05.2f km\n",distance);       //for proper formatting, used printf
               flag = true;
            }
         }
         if(!flag)                                          //if the program has not found anything...
         {
            System.out.println("non-existent.");
         }



      }
      else
      {
         System.out.println("The file is empty");           //if the file is empty
      }

      fileInput.close();
   }
}
