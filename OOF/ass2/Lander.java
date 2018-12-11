/*
 * Class Name:    Lander
 *
 * Author:        Peter Muir
 * Creation Date: Monday, April 25 2016, 19:06 
 * Last Modified: Monday, April 25 2016, 20:51
 * 
 * Class Description: Creates a random set of co-ordinates for a Lander and a
 * Base. The user must attempt to  match the Lander's co-ordinates to the Base's
 * by using the commands given to them in the menu before they run out of
 * attempts.
 *
 */
import java.util.*;
public class Lander
{
   public static void main(String[] args)
   {
      Random r = new Random();               //Random number generator
      int landerX = r.nextInt(19)-9;         //between -9 and 9
      int landerY = r.nextInt(6)+5;          //between 5 and 10
      int baseX = r.nextInt(19)-9;           //between -9 and 9
      int baseY = 0;                         //baseY will always be 0
      int attempts = 8;                      //can alter attempts to change difficulty
      boolean hyper = false;
      Scanner kbd = new Scanner(System.in);
      System.out.println("Initial positions");
      System.out.println("Base: x = " + baseX + " y = " + baseY);
      System.out.println("Lander: x = " + landerX + " y = " + landerY);
      do
      {
         boolean valid = true;               //flag for valid user entry
         System.out.println("\n    Lander Command Menu");   //The menu that is shown every loop.
         System.out.println("North\nSouth\nWest\nEast\nNorth East\nNorth West\nSouth East\nSouth West\nHyper");
         System.out.print("    Enter command >> ");
         String command = kbd.nextLine().toLowerCase();

         if(command.equals("north"))
         {
            landerY += 2;
         }else if(command.equals("south"))
         {
            landerY -= 2;
            if(landerY < 0)
            {
               landerY = 5;
            }
         }else if(command.equals("west"))
         {
            landerX -= 2;
            if(landerX < -9)
            {
               landerX = 9;
            }
         }else if(command.equals("east"))
         {
            landerX += 2;
            if(landerX > 9)
            {
               landerX = -9;
            }
         }else if(command.equals("north east"))
         {
            landerY += 1;
            landerX += 1;
            if(landerX > 9)
            {
               landerX = -9;
            }
         }else if(command.equals("north west"))
         {
            landerY += 1;
            landerX -= 1;
            if(landerX < -9)
            {
               landerX = 9;
            }
         }else if(command.equals("south east"))
         {
            landerY -= 1;
            if(landerY < 0)
            {
               landerY = 5;
            }
            landerX += 1;
            if(landerX > 9)
            {
               landerX = -9;
            }
         }else if(command.equals("south west"))
         {
            landerY -= 1;
            if(landerY < 0)
            {
               landerY = 5;
            }
            landerX -= 1;
            if(landerX < -9)
            {
               landerX = 9;
            }
         }else if(command.equals("hyper"))
         {
            hyper = true;                 //flag allows us to break out of loop without using break;
         }else
         {
            valid = false;                //user has not input a valid command
         }

         if(valid)                        //if valid, update
         {
            attempts -= 1;
            System.out.println("Base: x = " + baseX + " y = " + baseY);
            System.out.println("Lander: x = " + landerX + " y = " + landerY);
            System.out.println("Number of attempts left = " + attempts);
         }else
         {
            System.out.println("That is not a valid command.");
         }

      }while(((landerX != baseX) || (landerY != baseY)) && (attempts != 0) && (hyper != true));

      if(hyper == true)          //checks for hyper, then if the lander was successful and finally if it has crashed.
      {
         System.out.println("Return to hyperspace, better luck next time!");
      }else if(((landerX == baseX) && (landerY == baseY)))
      {
         System.out.println("Congratulations!!! You have successfully landed at the base.");
      }else
      {
         System.out.println("You crashed the Lander, pay more attention next time!!!");
      }
   }
}

