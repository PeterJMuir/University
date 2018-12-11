import java.util.*;
import java.io.*;
public class ContactMenu
{
   private Contacts contacts = new Contacts();
   private Scanner keyboard = new Scanner(System.in);

   public void menu()
   {
      char input;
      do
      {
         System.out.println("Please select an option");
         System.out.println("A - Add a person");
         System.out.println("M - Make contact cards");
         System.out.println("B - Birthday list");
         System.out.println("C - Contact detail summary");
         System.out.println("Q - Quit");

         input = keyboard.next().trim().toUpperCase().charAt(0);
         keyboard.nextLine();

         switch(input)
         {
            case 'A':
               addPerson();
               break;
            case 'M':
               makeContactCards();
               break;
            case 'B':
               generateBirthdayList();
               break;
            case 'C':
               outputContactList();
               break;
            case 'Q':
               System.out.println("Exiting system...");
               break;
            default:
               System.out.println("That was not a valid choice!");
         }
      } while (input != 'Q');
   }

   public void addPerson()
   {
      System.out.println("Enter family name: ");
      String familyName = keyboard.nextLine();

      System.out.println("Enter given name: ");
      String givenName = keyboard.nextLine();

      System.out.println("Enter birthday [DD/MM/YYYY]: ");
      String birthday = keyboard.nextLine();
      String[] birthdates = birthday.split("/");

      System.out.println("Enter email address: ");
      String email = keyboard.nextLine();

      System.out.println("Enter phone number: ");
      String phoneNumber = keyboard.nextLine();

      Person newPerson = new Person(familyName, givenName,
            Integer.parseInt(birthdates[0]), 
            Integer.parseInt(birthdates[1]), 
            Integer.parseInt(birthdates[2]), 
            email, phoneNumber); 
      contacts.add(newPerson);
   }

   public void makeContactCards()
   {
      System.out.println("This menu option has not been implemented yet");
   }

   public void generateBirthdayList()
   {
      contacts.birthdayList(new PrintWriter(System.out, true));
   }

   public void outputContactList()
   {
      contacts.contactList(new PrintWriter(System.out, true));
   }

   public void loadDatabase()
   {
      File saveFile = new File("contactdb.bin");
      try{
         ObjectInputStream inFile = new ObjectInputStream( new FileInputStream(saveFile));
         contacts = (Contacts)inFile.readObject();
      }catch(ClassNotFoundException e)
      {
         System.out.println("WRONG CLASS BOY!");
      }
      catch(FileNotFoundException e)
      {
         System.out.println("Could not load - File does not exist. Try saving first.");
      }
      catch(IOException e)
      {
         System.out.println("That's not the right input!");
      }
   }

   public void saveDatabase()
   {
      File saveFile = new File("contactdb.bin");
      try{
         ObjectOutputStream outFile = new ObjectOutputStream( new FileOutputStream(saveFile));
         outFile.writeObject(contacts);
      }catch(IOException e)
      {
         System.out.println("That's not the right input!");
      }
   }

   public static void main(String[] args)
   {
      ContactMenu addressBook = new ContactMenu();
      addressBook.loadDatabase();
      addressBook.menu();
      addressBook.saveDatabase();
   }
}
