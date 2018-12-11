/*
 * Class Name:    myShipFinder
 *
 * Author:        Peter Muir
 * Creation Date: Tuesday, January 24 2017, 10:02 
 * Last Modified: Tuesday, February 07 2017, 00:21
 * 
 * Class Description:
 * Loads JSON strings into Ship and Pos classes.
 * User is able to search for and view or save Ship details or Position reports
 * using the menu.
 *
 */
import java.io.*;
import java.util.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class myShipFinder
{
   private static double minLat, minLong;
   private static double maxLat, maxLong;
   private static String minTime, maxTime;
   public static void main(String args[]) throws Exception
   {
      if(args.length != 2)
      {
         System.out.println("Invalid use of myShipFinder. myShipFinder must be called: myshipFinder <shipDetails> <shipPositions>");
      }
      else
      {
         Vector<Ship> ships = new Vector<Ship>();
         Vector<Pos> positions = new Vector<Pos>();
         loadShips(args[0], ships);
         loadPos(args[1], positions);
         Scanner kb = new Scanner(System.in);
         findBoundaries(positions);
         boolean exitFlag = false;
         do{
            System.out.println("\t---MENU---\n");
            System.out.println("Min Latitude: " + minLat + "\tMin Longitude: " + minLong + "\tMin Time Stamp: " + minTime
                  + "\nMax Latitude: " + maxLat + "\tMax Longitude: " + maxLong + "\tMax Time Stamp: " + maxTime);
            System.out.println("1 -> Search for a Ship (Name)\n"
                  + "2 -> Output details to a file (MMSI)\n"
                  + "3 -> Output details to a file (MMSI + Time Range)\n"
                  + "4 -> Output details to a file (Range of Latitude, Longitude and Time of Transmission)\n"
                  + "5 -> Exit");
            int choice = kb.nextInt();
            kb.nextLine();
            switch (choice)
            {
               case 1:
                  searchName(ships);
                  break;
               case 2:
                  reportMMSI(ships, positions);
                  break;
               case 3:
                  reportTimeMMSI(ships, positions);
                  break;
               case 4:
                  reportPosBoundaries(ships, positions);
                  break;
               case 5:
                  exitFlag = true;
                  break;
               default:
                  System.out.println("Invalid option. Please enter an integer from 1 to 5.");
            }

         }while(!exitFlag);
         /* System.out.println(positions);
            System.out.println("Min Latitude: " + minLat + "\tMin Longitude: " + minLong + "\tMin Time Stamp: " + minTime
            + "\nMax Latitude: " + maxLat + "\tMax Longitude: " + maxLong + "\tMax Time Stamp: " + maxTime);
            */
      }
   }

   public static void searchName(Vector<Ship> ships)
   {
      System.out.print("Enter the name of the ship: ");
      Scanner kb = new Scanner(System.in);
      String name = kb.nextLine();
      Ship.changeComp(true);
      Collections.sort(ships);
      int lo = 0;    //Binary Search...
      int hi = ships.size() - 1;
      int index = -1;
      while(lo <= hi)
      {
         int mid = lo + (hi-lo)/2;
         if (ships.get(mid).getName().compareTo(name) > 0) hi = mid - 1;
         else if (ships.get(mid).getName().compareTo(name) < 0) lo = mid + 1;
         else
         {
            index = mid;
            break;
         }
      }
      if(index == -1)
      {
         System.out.println("Could not find ship with name: " + name);
      }else
      {
         System.out.println(ships.get(index));
      }

   }

   public static int searchShipMMSI(Vector<Ship> ships, String MMSI)
   {
      Ship.changeComp(false);
      Collections.sort(ships);
      int lo = 0;    //Binary Search...
      int hi = ships.size() - 1;
      while(lo <= hi)
      {
         int mid = lo + (hi-lo)/2;
         if (ships.get(mid).getMMSI().compareTo(MMSI) > 0) hi = mid - 1;
         else if (ships.get(mid).getMMSI().compareTo(MMSI) < 0) lo = mid + 1;
         else return mid;
      }
      return -1;
   }


   public static void reportMMSI(Vector<Ship> ships, Vector<Pos> positions) throws IOException
   {
      System.out.print("Enter the MMSI of the ship: ");
      Scanner kb = new Scanner(System.in);
      String MMSI = kb.nextLine();
      int shipIndex = searchShipMMSI(ships, MMSI);
      if(shipIndex == -1)
      {
         System.out.println("Could not find ship with MMSI: " + MMSI);
      }

      Pos.changeComp('t');    //sort by time to get in chronological order
      Collections.sort(positions);
      Pos.changeComp('m');    //sort by MMSI (stably) so that all reports of the same ship will be in chronological order
      Collections.sort(positions);
      int index = -1;
      int lo = 0;    //Binary Search...
      int hi = positions.size() - 1;
      while(lo <= hi)
      {
         int mid = lo + (hi-lo)/2;
         if (positions.get(mid).getMMSI().compareTo(MMSI) > 0) hi = mid - 1;
         else if (positions.get(mid).getMMSI().compareTo(MMSI) < 0) lo = mid + 1;
         else
         {
            index = mid;
            break;
         }
      }
      if(index == -1)
      {
         System.out.println("Could not find any position reports for MMSI: " + MMSI);
      }else
      {
         Vector<Pos> tempPos = new Vector<Pos>();
         while((index != 0) && (positions.get(index - 1).getMMSI().compareTo(MMSI) == 0)) index--;   //getting to the start of the list of pos reports with same MMSIs
         while(positions.get(index).getMMSI().compareTo(MMSI) == 0)  //adds all reports to a temp list for writing
         {
            tempPos.add(positions.get(index));
            index++;
         }
         System.out.print("Enter the output file name: ");
         String outFile = kb.nextLine();
         if(shipIndex == -1)
         {
            writeData(outFile,null,tempPos);
         }else writeData(outFile,ships.get(shipIndex),tempPos);
      }

   }

   public static void reportTimeMMSI(Vector<Ship> ships, Vector<Pos> positions) throws IOException
   {
      System.out.print("Enter the MMSI of the ship: ");
      Scanner kb = new Scanner(System.in);
      String MMSI = kb.nextLine();
      int shipIndex = searchShipMMSI(ships, MMSI);
      if(shipIndex == -1)
      {
         System.out.println("Could not find ship with MMSI: " + MMSI);
      }

      Pos.changeComp('t');    //sort by time to get in chronological order
      Collections.sort(positions);
      Pos.changeComp('m');    //sort by MMSI (stably) so that all reports of the same ship will be in chronological order
      Collections.sort(positions);
      int index = -1;
      int lo = 0;    //Binary Search...
      int hi = positions.size() - 1;
      while(lo <= hi)
      {
         int mid = lo + (hi-lo)/2;
         if (positions.get(mid).getMMSI().compareTo(MMSI) > 0) hi = mid - 1;
         else if (positions.get(mid).getMMSI().compareTo(MMSI) < 0) lo = mid + 1;
         else
         {
            index = mid;
            break;
         }
      }
      if(index == -1)
      {
         System.out.println("Could not find any position reports for MMSI: " + MMSI);
      }else
      {
         Vector<Pos> tempPos = new Vector<Pos>();
         while((index != 0) && (positions.get(index - 1).getMMSI().compareTo(MMSI) == 0)) index--;   //getting to the start of the list of pos reports with same MMSIs
         System.out.println("Time format: \"year-month-date hour:min:sec\". Example: 2017-01-20 15:06:49");
         System.out.print("Enter the lower bound for the time range: ");
         String lowTime = kb.nextLine();
         System.out.print("Enter the upper bound for the time range: ");
         String highTime = kb.nextLine();
         while((positions.get(index).getMMSI().compareTo(MMSI) == 0))  //adds all reports to a temp list for writing
         {
            if((positions.get(index).getTime().compareTo(lowTime) > 0) &&(positions.get(index).getTime().compareTo(highTime) < 0))
            {
               tempPos.add(positions.get(index));
            }
            index++;
         }
         System.out.print("Enter the output file name: ");
         String outFile = kb.nextLine();
         if(shipIndex == -1)
         {
            writeData(outFile,null,tempPos);
         }else writeData(outFile,ships.get(shipIndex),tempPos);
      }
   }

   public static void reportPosBoundaries(Vector<Ship> ships, Vector<Pos> positions) throws IOException
   {
      System.out.print("Enter the lower bound for latitude: ");
      Scanner kb = new Scanner(System.in);
      double lowLat = kb.nextDouble();
      System.out.print("Enter the upper bound for latitude: ");
      double highLat = kb.nextDouble();
      System.out.print("Enter the lower bound for longitude: ");
      double lowLong = kb.nextDouble();
      System.out.print("Enter the upper bound for longitude: ");
      double highLong = kb.nextDouble();
      kb.nextLine();
      System.out.println("Time format: \"year-month-date hour:min:sec\". Example: 2017-01-20 15:06:49");
      System.out.print("Enter the lower bound for the time range: ");
      String lowTime = kb.nextLine();
      System.out.print("Enter the upper bound for the time range: ");
      String highTime = kb.nextLine();

      Pos.changeComp('t');
      Collections.sort(positions);

      Vector<Pos> tempPos = new Vector<Pos>();
      for(int index = 0;(index < positions.size() && (positions.get(index).getTime().compareTo(highTime) < 0)); ++index)
      {
         Pos p = positions.get(index);
         if(p.getTime().compareTo(lowTime) > 0)
         {
            if((p.getLatitude() > lowLat) && (p.getLatitude() < highLat))
            {
               if((p.getLongitude() > lowLong) && (p.getLongitude() < highLong))
               {
                  tempPos.add(p);   //final tempPos Vector is a Vector containing the reports that fit the constraints
               }
            }
         }
      }

      Pos.changeComp('m');    //sort by MMSI (stably) so that all reports of the same ship will be in chronological order
      Collections.sort(tempPos);
      LinkedList<Vector<Pos>> posList = new LinkedList<Vector<Pos>>();  //A list of Vectors of Position Reports
      for(int i = 0, j = 0; i < tempPos.size(); ++j)
      {
         posList.add(new Vector<Pos>());
         posList.get(j).add(tempPos.get(i));
         ++i;
         while((i < tempPos.size()) && (tempPos.get(i).getMMSI().compareTo(tempPos.get(i-1).getMMSI()) == 0))
         {
            posList.get(j).add(tempPos.get(i));
            ++i;
         }
      } 
      System.out.print("Enter the output file name: ");
      String fileName = kb.nextLine();
      PrintWriter outFile = new PrintWriter(new File(fileName));
      for(int i = 0; i < posList.size(); ++i)
      {
         int shipIndex = searchShipMMSI(ships, posList.get(i).get(0).getMMSI());

         if(shipIndex == -1)
         {
         Gson gsonObject = new GsonBuilder().setPrettyPrinting().create();
         String jsonString = gsonObject.toJson(null);   //ShipDetails
         String jsonStringPos = gsonObject.toJson(posList.get(i)); //Ship Position reports
         outFile.println(jsonString);  //first print details
         outFile.println(jsonStringPos);  //then print the position reports
         }else
         {
         Gson gsonObject = new GsonBuilder().setPrettyPrinting().create();
         String jsonString = gsonObject.toJson(ships.get(shipIndex));   //ShipDetails
         String jsonStringPos = gsonObject.toJson(posList.get(i)); //Ship Position reports
         outFile.println(jsonString);  //first print details
         outFile.println(jsonStringPos);  //then print the position reports
         }
      }
      outFile.close();  //re-wrote writeData to manipulate when the reader would close
   }


   public static void loadShips(String d, Vector<Ship> ships) throws IOException
   {
      File inStream = new File( d );
      if(inStream.exists())
      {
         Scanner reader = new Scanner(inStream);
         String JsonString = "";
         while (reader.hasNext())
         {
            JsonString += reader.nextLine();
         }
         Gson gson = new Gson();
         Ship[] tempShips = gson.fromJson(JsonString, Ship[].class);
         if (tempShips == null) System.out.println("tempShips is null");
         else ships.addAll(Arrays.asList(tempShips));
         reader.close();
      }else System.out.println(d + " does not exist");
   }

   public static void loadPos(String p, Vector<Pos> positions) throws IOException
   {
      File inStream = new File( p );
      if(inStream.exists())
      {
         Scanner reader = new Scanner(inStream);
         String JsonString = "";
         while (reader.hasNext())
         {
            JsonString += reader.nextLine();
         }
         Gson gson = new Gson();
         Pos[] tempPos = gson.fromJson(JsonString, Pos[].class);
         if (tempPos == null) System.out.println("tempPos is null");
         else positions.addAll(Arrays.asList(tempPos));
         reader.close();
      }else System.out.println(p + " does not exist");
   }

   public static void writeData(String fileName, Ship ship, Vector<Pos> positions)
      throws IOException
      {
         PrintWriter outFile = new PrintWriter(new File(fileName));

         Gson gsonObject = new GsonBuilder().setPrettyPrinting().create();
         String jsonString = gsonObject.toJson(ship);   //ShipDetails
         String jsonStringPos = gsonObject.toJson(positions); //Ship Position reports
         outFile.println(jsonString);  //first print details
         outFile.println(jsonStringPos);  //then print the position reports

         outFile.close();
      }


   public static void findBoundaries(Vector<Pos> positions) throws IOException
   {
      if(positions.size() > 0)
      {
         Pos.changeComp('a');
         Collections.sort(positions);
         minLat = positions.get(0).getLatitude();
         maxLat = positions.get(positions.size()-1).getLatitude();
         Pos.changeComp('o');
         Collections.sort(positions);
         minLong = positions.get(0).getLongitude();
         maxLong = positions.get(positions.size()-1).getLongitude();
         Pos.changeComp('t');
         Collections.sort(positions);
         minTime = positions.get(0).getTime();
         maxTime = positions.get(positions.size()-1).getTime();
      }
   }
}

