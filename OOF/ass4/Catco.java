/*
 * Class Name:    Catco
 *
 * Author:        Your Name
 * Creation Date: Monday, April 25 2016, 22:19 
 * Last Modified: Sunday, May 22 2016, 15:32
 * 
 * Class Description:
 *
 */
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Catco
{
   private Scanner kb;
   private Ship [ ] ships;

   private final int ADD_SHIP = 1;
   private final int ADD_CREW = 2;
   private final int DISPLAY = 3;
   private final int WRITE_TO_FILE = 4;
   private final int START_MISSION = 5;
   private final int END_MISSION = 6;
   private final int CHANGE_SHIP_STATUS = 7;
   private final int EXIT = 8;

   private final int MAX_SHIPS = 100;

   private final int DISPLAY_ALL = 1;
   private final int DISPLAY_SHIPS = 2;
   private final int DISPLAY_CREW = 3;
   private final int DISPLAY_SINGLE_SHIP = 4;
   private final int DISPLAY_SINGLE_CREW = 5;
   private final int DISPLAY_EXIT = 6;

   private int shipCounter;

   public static void main( String [ ] args ) throws IOException
   {
      Catco c = new Catco( );
      c.load( );
      c.run( );
      
   }

   public Catco( )
   {
      kb = new Scanner( System.in );
      ships = new Ship[ MAX_SHIPS ];
      shipCounter = 0;
   }

   public void run( ) throws IOException
   {
      int choice = -1;
      while( choice != EXIT )
      {
         displayMenu( );
         System.out.print( "Enter choice >> ");
         choice = kb.nextInt( );
         kb.nextLine( );
         process( choice );
      }
      System.out.print("Would you like to save [y/n]? ");
      if(kb.nextLine().equalsIgnoreCase("y"))
       {
          writeToFile();
       }
   }

   public void displayMenu( )
   {
      System.out.println( "\n\tCATCO MAIN MENU" );
      System.out.println( ADD_SHIP + ". Add Ship" );
      System.out.println( ADD_CREW + ". Add Crew" );
      System.out.println( DISPLAY + ". Display" );
      System.out.println( WRITE_TO_FILE + ". Write to file" );
      System.out.println( START_MISSION + ". Start Mission" );
      System.out.println( END_MISSION + ". End Mission" );
      System.out.println( CHANGE_SHIP_STATUS + ". Change Ship Status" );
      System.out.println( EXIT + ". Exit" );
   }

   public void process( int choice ) throws IOException
   {
      switch( choice )
      {
         case ADD_SHIP :
            addShip( );
            break;

         case ADD_CREW :
            addCrew( );
            break;

         case DISPLAY :
            display( );
            break;

         case WRITE_TO_FILE :
            writeToFile( );
            break;

         case START_MISSION :
            startMission( );
            break;

         case END_MISSION :
            endMission( );
            break;

         case CHANGE_SHIP_STATUS:
            changeStatus( );
            break;

         case EXIT :
            // just trap this choice
            break;

         default:
            System.out.println("That is not a valid choice");
            break;
      }
   }

   public void addShip( )
   {
      if( shipCounter < MAX_SHIPS )
      {
         System.out.print( "Enter Ship id >> " );
         String id = kb.nextLine();
         int index = searchShipId(id);
         if(-1 == index)
         {
            System.out.print("Enter Ship Capacity >> ");
            int capacity = kb.nextInt();
            ships[shipCounter++] = new Ship(id,capacity);  //makes a new Ship and increments shipCounter
         }else
         {
            System.out.println("There is already a ship with that id.");
         }
      }else
      {
         System.out.println("There is not enough space to store another ship");
      }
   }

   public int searchShipId(String id)
   {
      int index = -1;
      for(int i = 0; (i < shipCounter) && (-1 == index); ++i)
      {
         if(ships[i].getId().equals(id))
         {
            index = i;
         }
      }
      return index;

   }

   public int[] searchCrewId(String crewId)
   {
      int index[] = {-1,-1};
      for(int i = 0;(-1 == index[0]) && (i < shipCounter); ++i)
      {
         index[1] = ships[i].searchCrewId(crewId);
         if(index[1] != -1)
         {
            index[0] = i;
         }
      }
      return index;
   }

   public void addCrew( )
   {
      if(0 != shipCounter)
      {
         System.out.print("Enter Ship id >> ");
         String shipId = kb.nextLine();
         int shipIndex = searchShipId(shipId);
         if(-1 == shipIndex)
         {
            System.out.println("There is no Ship with that id");
         }else if(ships[shipIndex].getCapacity() == ships[shipIndex].getCurrentCrew())
         {
            System.out.println("This Ship is at full capacity! Cannot add any more Crew");
         }else
         {
            System.out.print("Enter new Crew id >> ");
            String nCrewId = kb.nextLine();
            int crewIndex[] = searchCrewId(nCrewId);
            if(-1 != crewIndex[0])
            {
               System.out.println("That Crew id has already been assigned");
            }else
            {
               System.out.print("Enter name >> ");
               String nCrewName = kb.nextLine();
               System.out.print("Enter role >> ");
               String nCrewRole = kb.nextLine();
               ships[shipIndex].addCrew(nCrewId,nCrewName,nCrewRole);
            }
         }
      }else
      {
         System.out.println("There are no Ships");
      }
   }

   /*
    * This now becomes the top of the display sub menu
    *
    */
   public void display( )
   {
      int choice = -1;
      while( choice != DISPLAY_EXIT )
      {
         displayDisplayMenu( );
         System.out.print( "Enter display choice >> ");
         choice = kb.nextInt( );
         kb.nextLine( );
         processDisplay( choice );
      }
   }

   public void displayDisplayMenu( )
   {
      System.out.println("\n\tDisplay Menu" );
      System.out.println( DISPLAY_ALL + ". Display all Ships " ) ;
      System.out.println( DISPLAY_SHIPS + ". Display Ships only" ) ;
      System.out.println( DISPLAY_CREW + ". Display Crew only" ) ;
      System.out.println( DISPLAY_SINGLE_SHIP + ". Display single Ship" ) ;
      System.out.println( DISPLAY_SINGLE_CREW + ". Display single crew" );
      System.out.println( DISPLAY_EXIT + ". Return to main menu" );
   }

   public void processDisplay( int choice )
   {
      switch( choice )
      {
         case DISPLAY_ALL :
            displayAll( );
            break;

         case DISPLAY_SHIPS :
            displayShips( );
            break;

         case DISPLAY_CREW :
            displayCrews( );
            break;

         case DISPLAY_SINGLE_SHIP :
            displaySingleShip( );
            break;

         case DISPLAY_SINGLE_CREW :
            displaySingleCrew( );
            break;

         case DISPLAY_EXIT:
            // just trap this choice so that it doesn't
            // show up as an invalid choice
            break;

         default :
            System.out.println( choice + " is not a valid" +
                  " choice" );
            break;
      }
   }

   public void displayAll( )
   {
      if(0 != shipCounter)
      {
         for(int i = 0; i < shipCounter; i++)
         {
            System.out.println("Ship\n[" + ships[i] + "]\nhas");
            if(0 != ships[i].getCurrentCrew())
            {
               for(int j = 0; j < ships[i].getCurrentCrew(); ++j)
               {
                  System.out.println("Crew\n[" + ships[i].displayCrew(j) + "]");
               }
            }else
            {
               System.out.println("No Crew");
            }
         }
      }else
      {
         System.out.println("There are no Ships");
      }
   }

   public void displayShips( )
   {
      if(0 != shipCounter)
      {
         System.out.println("\nHere is the Ship only information\n");
         for(int i = 0; i < shipCounter; i++)
         {
            System.out.println("Ship\n[" + ships[i] + "]");
         }
      }else
      {
         System.out.println("There are no Ships");
      }
   }

   public void displayCrews( )
   {
      if(0 != shipCounter)
      {
         boolean empty = true;
         System.out.println("\nHere is the Crew only information\n");
         for(int i = 0; i < shipCounter ; i++)
         {
            if(0 != ships[i].getCurrentCrew())
            {
               for(int j = 0; j < ships[i].getCurrentCrew(); ++j)
               {
                  System.out.println("Crew\n[" + ships[i].displayCrew(j) + "]");
               }
               empty = false;
            }
         }
         if(empty)
         {
            System.out.println("There are no Crew in any of the ships");
         }
      }else
      {
         System.out.println("There are no Ships");
      }
   }

   public void displaySingleShip( )
   {
      if(0 != shipCounter)
      {
         System.out.print("Enter id of Ship to display >> ");
         String shipId = kb.nextLine();
         int index = searchShipId(shipId);
         if(-1 == index)
         {
            System.out.println("There is no ship with that id");
         }else
         {
            System.out.println("\nHere is the information for the requested Ship\n");
            System.out.println("Ship\n[" + ships[index] + "]\nhas");
            if(0 != ships[index].getCurrentCrew())
            {
               for(int j = 0; j < ships[index].getCurrentCrew(); ++j)
               {
                  System.out.println("Crew\n[" + ships[index].displayCrew(j) + "]");
               }
            }else
            {
               System.out.println("No Crew");
            }

         }
      }else
      {
         System.out.println("There are no Ships");
      }
   }

   /*
    * This one is harder in that we have to go through, potentially, the
    * entire Ship array to find the requested Crew.
    *
    * Once again, it is very similar to checking that the id of a 
    * new Crew is unique. So most if not all of the code should have 
    * already been written.
    *
    */
   public void displaySingleCrew( )
   {
      if(0 != shipCounter)
      {
         System.out.print("Enter the id of the Crew to display >> ");
         String crewId = kb.nextLine();
         int index[] = searchCrewId(crewId);
         if(-1 == index[0])
         {
            System.out.println("There is no Crew with that id");
         }else
         {
            System.out.println("\nHere is the information for the requested Crew\n");
            System.out.println("Crew\n[" + ships[index[0]].displayCrew(index[1]) + "]");
         }
      }else
      {
         System.out.println("There are no Ships");
      }
   }

   public void startMission( )
   {
      if(0 != shipCounter)
      {
         System.out.print("Enter Ship id >> ");
         String shipId = kb.nextLine();
         int index = searchShipId(shipId);
         if(-1 == index)
         {
            System.out.println("There is no Ship with that id");
         }else
         {
            if((ships[index].getStatus().equals("available")) && (ships[index].getCurrentCrew() > 0))
            {
               ships[index].changeStatus("on station");
            }else
            {
               System.out.println("This Ship is not able to start a mission");
            }
         }
      }else
      {
         System.out.println("There are no Ships");
      }
   }

   public void endMission( )
   {
      if(0 != shipCounter)
      {
         System.out.print("Enter Ship id >> ");
         String shipId = kb.nextLine();
         int index = searchShipId(shipId);
         if(-1 == index)
         {
            System.out.println("There is no Ship with that id");
         }else
         {
            if((ships[index].getStatus().equals("on station")))
            {
               System.out.print("Does the ship require maintenance [y/n] ? ");
               if(kb.nextLine().equalsIgnoreCase("y"))
               {
                  ships[index].changeStatus("maintenance");
               }else
               {
                  ships[index].changeStatus("available");
               }
            }else
            {
               System.out.println("This Ship is not on a mission, so cannot end a mission");
            }
         }
      }else
      {
         System.out.println("There are no Ships");
      }
   }

   public void changeStatus( )
   {
      if(0 != shipCounter)
      {
         System.out.print("Enter Ship id >> ");
         String shipId = kb.nextLine();
         int index = searchShipId(shipId);
         if(-1 == index)
         {
            System.out.println("There is no Ship with that id");
         }else
         {
            System.out.print("Enter new status >> ");
            String nShipStatus = kb.nextLine();
            if(ships[index].getStatus().equals("on station"))
            {
               System.out.println("The Ship's status cannot be changed manually while on station. To change the Ship's status, end its mission first.");
            }else if(nShipStatus.equals("on station"))
            {
               System.out.println("Cannot manually change status to \"on station\". To change to \"on station\", the Ship must start a mission.");
            }else if(nShipStatus.equals("maintenance"))
            {
               System.out.println("The ship can only go into maintenance at the end of a mission.");
            }else
            {
               ships[index].changeStatus(nShipStatus);
            }
         }
      }else
      {
         System.out.println("There are no Ships");
      }
   }

   public void load ( ) throws IOException
   {
      System.out.print( "Enter file name >> " );
      File fileOpen = new File(kb.nextLine());
      Scanner fileInput = new Scanner(fileOpen);
      while((fileInput.hasNextLine() == true) && (shipCounter < MAX_SHIPS))
      {
         String ShipId = fileInput.nextLine();
         int ShipCapacity = fileInput.nextInt();
         fileInput.nextLine();
         String ShipStatus = fileInput.nextLine();
         int ShipCurrentCrew = fileInput.nextInt();
         fileInput.nextLine();
         ships[shipCounter] = new Ship(ShipId, ShipCapacity, ShipStatus);
         for(int i = 0;i < ShipCurrentCrew; i++)
         {
            String CrewId = fileInput.nextLine();
            String CrewName = fileInput.nextLine();
            String CrewRole = fileInput.nextLine();
            int CrewNumberOfMissions = fileInput.nextInt();
            fileInput.nextLine();
            boolean CrewOnMission = fileInput.nextBoolean();
            fileInput.nextLine();
            ships[shipCounter].addCrew(CrewId,CrewName,CrewRole,CrewNumberOfMissions,CrewOnMission);
         }
         ++shipCounter;
      }
      fileInput.close();
   }

   public void writeToFile( ) throws IOException
   {
      System.out.print("Enter File name to write to >> ");
      File fileOpen = new File(kb.nextLine());
      PrintWriter fileOutput = new PrintWriter(fileOpen);
      for(int i = 0; i < shipCounter; i++)
      {
         fileOutput.println(ships[i].getId());
         fileOutput.println(ships[i].getCapacity());
         fileOutput.println(ships[i].getStatus());
         fileOutput.println(ships[i].getCurrentCrew());
         fileOutput.print(ships[i].printCrew());
      }

      fileOutput.close();
   }


}

