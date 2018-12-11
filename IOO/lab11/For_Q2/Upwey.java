// Lab 11
import java.util.*;
public class Upwey
{
   private static Scanner keyboard = new Scanner(System.in);
   private static int THREE_SIX_LENGTH = 4500;
   private static int ONE_SEVEN_LENGTH = 2000;
   private static int NINE_LENGTH = 250;
   private ArrayList<Aircraft> threeSix;
   private ArrayList<Aircraft> oneSeven;
   private ArrayList<Aircraft> nine;

   public Upwey()
   {
      threeSix = new ArrayList<Aircraft>();
      oneSeven = new ArrayList<Aircraft>();
      nine = new ArrayList<Aircraft>();
   }

   public void menu() throws Exception
   {

      char option = '\0';		// null character
      while (option != 'E')
      {
         displayMenu();
         option = keyboard.nextLine().toUpperCase().charAt(0);
         switch(option)
         {
            case 'Q':
               QueueAircraft(keyboard);
               break;
            case 'T':
               TakeOff(keyboard);
               break;
            case 'D':
               DisplayRunwayQueues();
               break;
            case 'E':
               System.out.println("Taking off - bye!\n");
               break;
            default :
               System.out.println("Invalid Option!");
         }
      }
   }

   private void displayMenu()
   {
      System.out.println();
      System.out.println("UPWEY DEPARTURES");
      System.out.println("****************");
      System.out.println("Q) Queue aircraft for departure");
      System.out.println("T) Take off");
      System.out.println("D) Display runway queues");
      System.out.println();
      System.out.println("E) Exit");
      System.out.print("Please choose: ");
   }

   private void DisplayRunwayQueues()
   {
      System.out.println("Runway OneSeven:");
      for(int i = 0; i < oneSeven.size(); ++i)
      {
         System.out.println(oneSeven.get(i));
      }
      System.out.println("Runway ThreeSix:");
      for(int i = 0; i < threeSix.size(); ++i)
      {
         System.out.println(threeSix.get(i));
      }
      System.out.println("Runway Nine:");
      for(int i = 0; i < nine.size(); ++i)
      {
         System.out.println(nine.get(i));
      }
   }

   private void TakeOff(Scanner kb) throws Exception
   {
      System.out.print("Enter Runway name\n(oneSeven, threeSix, nine): ");
      String runwayName = kb.nextLine().trim();
      ArrayList<Aircraft> runway;
      switch(runwayName)
      {
         case "oneSeven":
         runway = oneSeven;
         break;
         case "threeSix":
         runway = threeSix;
         break;
         case "nine":
         runway = nine;
         break;
         default:
            System.out.println("No runway with that name.");
            runway = null;
      }
      if(null != runway)
      {
         if(runway.size() > 0)
         {
            runway.remove(0);
         }else
         {
            System.out.println("No plane waiting on that runway");
         }
      }
   }

   private void QueueAircraft(Scanner kb) throws Exception
   {
      String regNum;
      int runwayLength;
      System.out.print("Registration Number: ");
      regNum = kb.nextLine().trim();
      System.out.print("Required Runway Length: ");
      runwayLength = Integer.parseInt(kb.nextLine().trim());
      int threeSixSize =  threeSix.size();
      int oneSevenSize = oneSeven.size();
      int nineSize = nine.size();
      ArrayList<Aircraft> runway;

      if(runwayLength <= NINE_LENGTH && nineSize <= oneSevenSize && nineSize <= threeSixSize)
      {
         runway = nine;
      }else if(runwayLength <= ONE_SEVEN_LENGTH && oneSevenSize <= nineSize && oneSevenSize <= threeSixSize)
      {
         runway = oneSeven;
      }else if(runwayLength <= THREE_SIX_LENGTH && threeSixSize <= nineSize && threeSixSize <= oneSevenSize)
      {
         runway = threeSix;
      }else
      {
         System.out.println("No suitable runway was found");
         runway = null;
      }

      if(null != runway)
      {
         runway.add(new Aircraft(regNum,runwayLength));
      }


   }
   // insert method definitions

   public static void main(String[] args) throws Exception
   {
      Upwey fly = new Upwey();
      fly.menu();
   }
}
