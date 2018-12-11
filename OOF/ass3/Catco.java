/*
 * Class Name:    Catco
 *
 * Author:        Your Name
 * Creation Date: Monday, April 25 2016, 22:19 
 * Last Modified: Tuesday, May 10 2016, 14:04
 * 
 * Class Description:
 *
 * This is the main driver program for OOF Assignment C
 * Semester 1 2016
 *
 * Some parts of the program have already been implemented for
 * you.
 *
 * When you copy all 4 java files from the csilib library area,
 * you should be able to compile the whole program and when you
 * run it, you will see how the menu structure works.
 *
 * The 2 ExplorationUnit object references are already included.
 *
 * Recall that are NO Ship or Crew objects (or object references)
 * in this class.
 *
 * The method structure is given to you, your task is to implement
 * the code inside the methods.
 *
 * You may add methods if you think that is required.
 * Following the method structure given here will be enough to
 * finish this assignment.
 *
 * Re-call that this assignment is based on Lab 7
 *
 */
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Catco
{
   private Scanner kb;
   private ExplorationUnit ex1;
   private ExplorationUnit ex2;

   private final int ADD_SHIP = 1;
   private final int ADD_CREW = 2;
   private final int DISPLAY = 3;
   private final int ADD_FROM_FILE = 4;
   private final int START_MISSION = 5;
   private final int END_MISSION = 6;
   private final int CHANGE_SHIP_STATUS = 7;
   private final int EXIT = 8;

   public static void main( String [ ] args ) throws IOException
   {
      Catco c = new Catco( );
      c.run( );     
   }

   /*
    * Constructor so that we can use non-static attributes and
    * methods in this program.
    *
    * Trying to run everything out of main would require that the
    * attributes at least would all have to be static, not something
    * that we want.
    *
    */
   public Catco( )
   {
      kb = new Scanner( System.in );
   }


   /* This method is the main loop of the program */
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
   }

   public void displayMenu( )
   {
      System.out.println( "\n\tCATCO MAIN MENU" );
      System.out.println( ADD_SHIP + ". Add Ship" );
      System.out.println( ADD_CREW + ". Add Crew" );
      System.out.println( DISPLAY + ". Display" );
      System.out.println( ADD_FROM_FILE + ". Add from file" );
      System.out.println( START_MISSION + ". Start Mission" );
      System.out.println( END_MISSION + ". End Mission" );
      System.out.println( CHANGE_SHIP_STATUS + ". Change Ship Status" );
      System.out.println( EXIT + ". Exit" );
   }

   /*
    * This method is known as a dispatch method, its one job
    * is to call the appropriate method, based on the parameter that
    * is passed in
    *
    */
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

         case ADD_FROM_FILE :
            addFromFile( );
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

   /*
    * This method is called to add a Ship, with input from the 
    * keyboard.
    * 
    * The method must check that there is a "free" ExplorationUnit
    * object reference BEFORE asking for any information from the
    * user.
    *
    * If there are no "free" ExplorationUnit object references, then a 
    * message is displayed on the screen and the method returns to
    * the main menu.
    *
    * If there is at least one "free" ExplorationUnit object reference,
    * then the user is asked for the id of a Ship.
    *
    * This method needs to check that the id just entered by the
    * user is not already in use, if it is, then a message is
    * displayed to the screen and the method returns.
    *
    * If there is at least one "free" ExplorationUnit object 
    * reference and the user entered id is unique, then the
    * appropriate ExplorationUnit constructor is called and
    * "attached" to the next "free" ExplorationUnit object reference.
    *
    * Always start with ex1
    *
    */  
   public void addShip( )
   {
      if( ex1 == null )
      {
         System.out.print( "Enter Ship id >> ");
         String tempId = kb.nextLine();
         ex1 = new ExplorationUnit(tempId);
      }else if( ex2 == null )
      {
         System.out.print( "Enter Ship id >> ");
         String tempId = kb.nextLine();
         if( ex1.getShipId().equals(tempId) )
         {
            System.out.println("That id is already assigned");
         }else
         {
            ex2 = new ExplorationUnit(tempId);
         }
      }else
      {
         System.out.println("Both EU's are full cannot add ship");
      }
   }

   /*
    * This method is called to enter a Crew from the keyboard
    * Once again, if both ExplorationUnit object references are
    * "free", then there is no Ship in which to put a Crew, so
    * an appropriate message is displayed on the screen and
    * the method returns to the main menu.
    *
    * The user is not asked for any information.
    *
    * If there is at least one Ship (in the ExplorationUnit)
    * then the user is asked for the id of the Ship.
    *
    * The method must then find the Ship with that id, if the
    * id of the Ship is not found, then a message is displayed
    * to the screen and no further information is requested
    * from the user, the method returns to the main menu.
    *
    * There is one more check. If there is a Ship with the id
    * this method must check that the Ship does not already 
    * have a Crew, again if the Ship already has a Crew,
    * this method displays a message to the screen and
    * returns to the main menu.
    *
    * If we get this far, then the user is asked for the id of
    * the Crew. The final check is make sure that the user entered
    * id is not already in use. If it is, message to the screen and
    * no further information is requested, the method returns to the
    * main menu.
    *
    * If all the checks are passed, then the user is asked to
    * enter the name and the role of the Crew and this Crew is
    * added to the ExplorationUnit that has the Ship with the
    * id that the user entered at the start of the method.
    *
    */ 
   public void addCrew( )
   {
      if( ((ex1 == null) && (ex2 == null)) )
      {
         System.out.println("Cannot add crew, no Ships present");
      }else
      {
         System.out.print( "Enter Ship id >> ");
         String tempShipId = kb.nextLine();
         if( ((ex1 != null) &&  (ex1.getShipId().equals(tempShipId))) )
         {
            if( (ex1.getCurrentCrew() > 0))
            {
               System.out.println("This ship already has a crew");
            }else
            {
               System.out.print( "Enter Crew id >> ");
               String CrewId = kb.nextLine();
               if( ((ex2 != null) && (ex2.getCurrentCrew() > 0) && (ex2.getCrewId().equals(CrewId))) )
               {
                  System.out.println("That crew id is already assigned");
               }else
               {           
                  System.out.print( "Enter crew name >> ");
                  String CrewName = kb.nextLine();
                  System.out.print( "Enter crew role >> ");
                  String CrewRole = kb.nextLine();
                  ex1.addCrew(CrewId,CrewName,CrewRole);
               }
            }
         }else if ( ((ex2 != null) && (ex2.getShipId().equals(tempShipId))) )
         {
            if( (ex2.getCurrentCrew() > 0))
            {
               System.out.println("This ship already has a crew");
            }else
            {
               System.out.print( "Enter Crew id >> ");
               String CrewId = kb.nextLine();
               if( (ex1.getCurrentCrew() > 0) && (ex1.getCrewId().equals(CrewId)) )
               {
                  System.out.println("That crew id is already assigned");
               }else
               {           
                  System.out.print( "Enter crew name >> ");
                  String CrewName = kb.nextLine();
                  System.out.print( "Enter crew role >> ");
                  String CrewRole = kb.nextLine();
                  ex2.addCrew(CrewId,CrewName,CrewRole);
               }
            }
         }else
         {
            System.out.println("No ship with that id found");
         }
      }
   }

   /*
    * This method displays the contents of the ExplorationUnit(s)
    * to the screen, if they are not null.
    *
    * See pages 15 - 16 for the format of the output.
    *
    * The format is a marking requirement.
    *
    */

   public void display( )
   {
      if( ((ex1 == null) && (ex2 == null)) )
      {
         System.out.println("No Ships present");
      }else
      {
         if( ex1 != null )
         {
            System.out.println(ex1);
         }
         if( ex2 != null )
         {
            System.out.println(ex2);
         }
      }
   }

   /*
    * This method is called to start a mission.
    *
    * This is detailed on page 11 of the assignment.
    *
    * In summary, there has to be at least one ExplorationUnit
    * before the user is asked for the id of a Ship.
    *
    * If a Ship with that id is found, then this method needs
    * to check that the Ship has a Crew and the Ship has a 
    * status of available.
    *
    * To make the changes to the Ship and Crew, you will need to
    * call one of your methods from ExplorationUnit.java
    *
    * See page 8 of the assignment for an example.
    *
    */
   public void startMission( )
   {
      if( ((ex1 == null) && (ex2 == null)) )
      {
         System.out.println("Cannot start mission, no Ships are present");
      }else
      {
         System.out.print( "Enter Ship id >> " );
         String tempShipId = kb.nextLine();
         if ( ((ex1 != null) && (ex1.getShipId().equals(tempShipId))) )
         {
            ex1.startMission();
         }else if ( ((ex2 != null) && (ex2.getShipId().equals(tempShipId))) )
         {
            ex2.startMission();
         }else
         {
            System.out.println("No ship with that id found");
         }
      }
   }

   /*
    * This method is called when we try and end a mission.
    * As with most methods here, first we check if there
    * is actually at least one ExplorationUnit object, if there
    * is not, then there are no Ships, so we can't end a mission
    * if there are no Ships.
    *
    * See the example test run on the assignment.
    *
    * If there is at least one Ship, then the user is asked to
    * enter the id of that Ship. If the Ship with that id is
    * found, then we need to check that the Ship is actually
    * on a mission (status = "on station"). Provide that the
    * Ship is actually on a mission, then the user is asked
    * if the Ship requires maintenance.
    *
    * If the answer is 'y' (or "yes") then that becomes the
    * status of the Ship, otherwise the status becomes
    * available.
    *
    * Either way, the onMission atttribute in the Crew 
    * is set to false
    *
    * The usual messages are displayed to the screen if the
    * Ship id is not found, there are no Ships or the Ship is found
    * but it is not on a mission.
    *
    * At the end, this method returns to the main menu
    *
    */
   public void endMission( )
   {
      if( ((ex1 == null) && (ex2 == null)) )
      {
         System.out.println("Cannot end mission, no Ships are present");
      }else
      {
         System.out.print( "Enter Ship id >> " );
         String tempShipId = kb.nextLine();
         if ( ((ex1 != null) && (ex1.getShipId().equals(tempShipId))) )
         {
            if(ex1.getShipStatus().equals("on station"))
            {
               System.out.print( "Does the Ship require maintenance [y/n] ? >> " );
               String ans = kb.nextLine();
               if(ans.equalsIgnoreCase("y"))
               {
                  ex1.changeShipStatus("maintenance");
               }else
               {
                  ex1.changeShipStatus("available");
               }
               ex1.endMission();
            }else
            {
               System.out.println("This Ship is not on a mission");
            }
         }else if ( ((ex2 != null) && (ex2.getShipId().equals(tempShipId))) )
         {
            if(ex2.getShipStatus().equals("on station"))
            {
               System.out.print( "Does the Ship require maintenance [y/n] ? >> " );
               String ans = kb.nextLine();
               if(ans.equalsIgnoreCase("y"))
               {
                  ex2.changeShipStatus("maintenance");
               }else
               {
                  ex2.changeShipStatus("available");
               }
               ex2.endMission();
            }else
            {
               System.out.println("This Ship is not on a mission");
            }
         }else
         {
            System.out.println("No ship with that id found");
         }
      }
   }

   /*
    * This method is called to, potentaillym change the 
    * status of a Ship. The same checks and messages for
    * there being no Ships is done as in the methods above.
    *
    * If there is at least one Ship, then the user is asked
    * for the id a Ship.
    *
    * Provided the Ship with that id is found, then and only then,
    * is the user asked for the new status.
    *
    * The rules determining what is and what is not allowed are
    * detailed on page 6 of the assignment.
    *
    * As a bonus, this method could be expanded so that if the
    * user requests a new status of "on station" and the current
    * status is "available", this is still not allowed. The reason
    * being that the Crew object would now still be showing
    * false for their onMission attribute, the user could
    * be directed to the Start Mission method.
    *
    * Alternatively, the user could be asked if this change 
    * signals the Ship is now on a mission and make the
    * appropriate changes to the Crew object
    *
    */
   public void changeStatus( )
   {
      if( ((ex1 == null) && (ex2 == null)) )
      {
         System.out.println("No Ships are present");
      }else
      {
         System.out.print( "Enter Ship id >> " );
         String tempShipId = kb.nextLine();
         if ( ((ex1 != null) && (ex1.getShipId().equals(tempShipId))) )
         {
            System.out.print( "Enter new status >> " );
            String newStatus = kb.nextLine();
            if(ex1.getShipStatus().equals("on station"))
            {
               System.out.println("The ship must end its mission before you can change its status");
            }else if(newStatus.equals("on station"))
            {
               System.out.println("The ship must start a mission to change to \"on station\"");
            }else
            {
               ex1.changeShipStatus(newStatus);
            }
         }else if ( ((ex2 != null) && (ex2.getShipId().equals(tempShipId))) )
         {
            System.out.print( "Enter new status >> " );
            String newStatus = kb.nextLine();
            if(ex2.getShipStatus().equals("on station"))
            {
               System.out.println("The ship must end its mission before you can change its status");
            }else if(newStatus.equals("on station"))
            {
               System.out.println("The ship must start a mission to change to \"on station\"");
            }else
            {
               ex2.changeShipStatus(newStatus);
            }
         }else
         {
            System.out.println("No ship with that id found");
         }
      }
   }


   /*
    * This method first checks that there is at least one
    * "free" ExplorationUnit object reference.
    *
    * If there is not, then no further information is
    * requested from the user and the method returns
    * to the main menu.
    *
    * Provided that there is at least one "free" 
    * ExplorationUnit object reference, then the user is
    * asked for the name of a text file.
    *
    * The program must work with any file name in the correctr
    * format (see page 10 of the assignment)
    *
    * The record in the file may consist of 9 lines or just 
    * 4 lines.
    *
    * There will be 9 lines if the record has a Ship and Crew.
    *
    * There will be jsut 4 lines if there is just a Ship.
    *
    * It is entirely possible to have just a Ship. If that is
    * the case, then the current crew attribute will be set to 
    * 0, that is how you can tell when reading the file.
    *
    * Once all the information for that Record is read in from the
    * file, the appropriate ExplorationUnit constructor is called
    * and the ExplorationUnit object is instantiated (inside this
    * ExplorationUnit constructor, the constructors of the Ship
    * and Crew objects that make up this ExplorationUnit object are
    * called.
    *
    * The result of instantiating the ExplorationUnit object is 
    * always stored in ex1 first, if it is free, else ex2.
    *
    * Consider that case of an empty file and file with more
    * records than 2
    *
    * Once this method completes, close the file and return to
    * the main menu
    *
    */
   public void addFromFile( ) throws IOException
   {
        if( ((ex1 == null) || (ex2 == null)) )
          {
          System.out.print( "Enter file name >> " );
          File fileOpen = new File(kb.nextLine());
          Scanner fileInput = new Scanner(fileOpen);
          if(fileInput.hasNextLine() == true)
          {
             while(fileInput.hasNextLine() == true)
             {
                   String CrewId = null;
                   String CrewName = null;
                   String CrewRole = null;
                   int CrewNumberOfMissions = -1;
                   boolean CrewOnMission = false;
                String ShipId = fileInput.nextLine();
               // System.out.println("Ship Id: " + ShipId);
                int ShipCapacity = fileInput.nextInt();
               // System.out.println("Ship Capacity: " + ShipCapacity);
                fileInput.nextLine();
                String ShipStatus = fileInput.nextLine();
               // System.out.println("ShipStatus: " + ShipStatus);
                int ShipCurrentCrew = fileInput.nextInt();
                //System.out.println("CurrentCrew: " + ShipCurrentCrew);
                fileInput.nextLine();
                if(ShipCurrentCrew > 0)
                {
                   CrewId = fileInput.nextLine();
               // System.out.println("CrewId: " + CrewId);
                   CrewName = fileInput.nextLine();
               // System.out.println("CrewName: " + CrewName);
                   CrewRole = fileInput.nextLine();
               // System.out.println("Crewrole: " + CrewRole);
                   CrewNumberOfMissions = fileInput.nextInt();
               // System.out.println("CrewNoOfMiss: " + CrewNumberOfMissions);
                   fileInput.nextLine();
                   CrewOnMission = fileInput.nextBoolean();
               // System.out.println("CrewOnMission: " + CrewOnMission);
                   fileInput.nextLine();
                }else
                {
                   CrewId = null;
                }
                if(ex1 == null)
                {
                   ex1 = new ExplorationUnit(ShipId,ShipCapacity,ShipStatus,ShipCurrentCrew,CrewId,CrewName,CrewRole,CrewNumberOfMissions,CrewOnMission);
                }else if(ex2 == null)
                {
                   ex2 = new ExplorationUnit(ShipId,ShipCapacity,ShipStatus,ShipCurrentCrew,CrewId,CrewName,CrewRole,CrewNumberOfMissions,CrewOnMission);
                }
             }
          }else
          {
          System.out.println("This file is empty");
          }
          }else
          {
          System.out.println("Both EU's are full, cannot add from file");
          }
          
   }
}

