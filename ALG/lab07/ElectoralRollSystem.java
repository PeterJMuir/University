import java.io.*;
import java.util.*;

/**
 The ElectoralRollSystem class provides an interface between the system 
 and a user.
  
 @author  La Trobe University
 @version 1.3
 */

 /* Revised on Apr 27 2008
  * All of the BufferedReader calls were replaced by Scanner calls
  *
  * The keyboard call was moved to the top of the class so that
  * it would an object attribute, as opposed to a local variable
  * in the methods. Both ways work, there is just less overhead
  * with the Scanner being an object attribute.
  *
  * The one downside is that now we have to be careful to
  * clean up stray newlines left in one method before leaving
  * that method and going to another method.
  *
  * StringTokenizer was replaced with the split method from the 
  * String class
  *
  * -- Richard Tresider
  */


public class ElectoralRollSystem  
{
   private Scanner keyboard = new Scanner( System.in );

   public static void main(String[] args) throws Exception
   {
      ElectoralRollSystem ers = new ElectoralRollSystem( );
      ers.run( );
   }
    
   public void run( ) throws IOException
   {   
      ElectoralRoll electoralRoll = new ElectoralRoll();
      
      System.out.println("Enter Data File:");
      String fileName = keyboard.nextLine();
      
      loadData(fileName, electoralRoll);
      
      boolean exitProgram = false;
      
      do
      {
         System.out.println();
         displayMenu();
         
         System.out.println("Please Enter a Choice");
         
         String choice = keyboard.nextLine();
         
         if (choice.equals("1"))
         {
            System.out.println("\n------------ELECTORAL ROLL------------\n");
            electoralRoll.displayElements();
            System.out.println("-------------END OF ROLL--------------\n");
         }
         else if(choice.equals("2"))
         {
            searchData(electoralRoll);
         }
         else if(choice.equals("3"))
         {
            insertData(electoralRoll);
         }
         else if (choice.equals("4"))
         {
            deleteData(electoralRoll);
         }
         else if(choice.equals("5"))
         {
            exitProgram = true;
         }
         else
         {
            System.out.println("Invalid Choice");
         }
      }while(!exitProgram);
   }
   /**
    This method will read in details about voters from a file and store the 
    details in the electoralRoll.
    
    @param  fileName       the name of the file
    @param  electoralRoll  the name of the ElectoralRoll object in
                           which to store the details
    */
   
   public void loadData(String fileName, ElectoralRoll electoralRoll) 
                      throws IOException
   {
      File inStream = new File(fileName);
      Scanner reader = new Scanner(inStream);
      
      String name = "";
      String address = "";
      String suburb = "";
      String state = "";
      String temp = "";
      String firstName = "";
      int postCode = 0;
      boolean more = false;

      if( reader.hasNext( ) ) // the file is not empty
      {
         more = true;
      }
      
      
      while( more )
      {
         name = reader.nextLine();
         String [ ] nameST = name.split(", ");
         
         name = nameST[ 0 ];
         firstName = nameST[ 1 ];
         
         address = reader.nextLine();
         temp = reader.nextLine();
         
         String [ ] st = temp.split("\t");
         
         suburb = st[ 0 ];
         
         state = st[ 1 ];
         
         postCode = Integer.parseInt(st[ 2 ]);
         
         electoralRoll.insert(firstName, name, address, suburb, 
                              state, postCode);
      
         // There is no blnak line after the last record in the file.   
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
   
   /**
    This method will read in details about a voter and store the details 
    in an array.
    
    @param  details  an array where the voters details will be stored.
    */
   
   public void getDetails(String[] details, boolean fullDetails) 
                      throws IOException
   {
      
      System.out.println("\nPlease Enter First Name");
      details[0] = keyboard.nextLine();
      
      System.out.println("Please Enter Last Name");
      details[1] = keyboard.nextLine();
      
      //Since the Voter compareTo(Voter) method does not check
      //address/suburb/state anyway, it is redundant to ask the user
      //for this information
      
      if (fullDetails)
      {
         System.out.println("Please Enter Address");
         details[2] = keyboard.nextLine();
         
         System.out.println("Please Enter Suburb");
         details[3] = keyboard.nextLine();
         
         System.out.println("Please Enter State");
         details[4] = keyboard.nextLine();
      }
      
      System.out.println("Please Enter PostCode");
      details[5] = keyboard.nextLine();
   }
   
   /**
    This method processes a request by the user to delete a voter from 
    the system.
    
    @param  electoralRoll   a ElectoralRoll object.
    */
   
   public void deleteData(ElectoralRoll electoralRoll) 
                      throws IOException
   {
      String[] details = new String[6];
      
      getDetails(details, false);
      
      boolean deleted = electoralRoll.removeElement(details[0], details[1], 
                           details[2], details[3], details[4], 
                           Integer.parseInt(details[5]));
      
      System.out.println("\n-----DELETION OF DATA - " + 
                            (deleted ? "SUCCEEDED-----" :
                                        "FAILED--------"));
   }
   
   /**
    This method processes a request by the user to insert a voter into 
    the system.
    
    @param  electoralRoll   a ElectoralRoll object.
    */
   
   public void insertData(ElectoralRoll electoralRoll) 
                      throws IOException
   {
      String[] details = new String[6];
      
      getDetails(details, true);
      
      if(electoralRoll.contains(details[0], details[1], 
         Integer.parseInt(details[5])) != null)
      {
         System.out.println("Element Already Exists");
      }
      else
      {
         boolean inserted = electoralRoll.insert(details[0], details[1], 
                                details[2], details[3], details[4], 
                                Integer.parseInt(details[5]));
         
         System.out.println("\n----INSERTION OF DATA - " + 
                            (inserted ? "SUCCEEDED-----" :
                                        "FAILED--------"));
      }
   }
   
   /**
    This method processes a request by the user to search for a voter in 
    the system.
   
    @param  electoralRoll   an ElectoralRoll object.
    */
   
   public void searchData(ElectoralRoll electoralRoll) 
                      throws IOException
   {
      System.out.println("\nPlease Enter First Name");
      String firstName = keyboard.nextLine();
      
      System.out.println("Please Enter Last Name");
      String lastName = keyboard.nextLine();
      
      System.out.println("Please Enter PostCode");
      String pCode = keyboard.nextLine();
      
      Person temp = electoralRoll.contains(firstName, lastName, 
                                          Integer.parseInt(pCode));
      
      if(temp == null)
      {
         System.out.println("\n-----------VOTER NOT FOUND------------\n");
      }
      else
      {
         System.out.println("\n-------------VOTER FOUND--------------\n");
         System.out.println(temp);
         System.out.println("--------------------------------------\n");
      }
   }
   
   /**
    This method displays the menu options available to the user.
    */
   
   public void displayMenu()
   {
      System.out.println("Electoral Roll System");
      System.out.println("---------------------");
      System.out.println("1: Display Data.");
      System.out.println("2: Search Data.");
      System.out.println("3: Insert Data.");
      System.out.println("4: Delete data.");
      System.out.println("5: Exit.");
   }
}
