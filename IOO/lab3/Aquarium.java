import java.util.*;
public class Aquarium
{
   private static Scanner keyboard = new Scanner(System.in);
   private static final int MAX_TANKS = 3;
   private Tank[] aquarium;

   public Aquarium()
   {
      aquarium = new Tank[MAX_TANKS];  // array of Tank references

      // 1. fill the Tank array elements with the pet shop's 3 derived tanks

      // 2. Put some fish in each tank
   }
 
   public void displayTanks()
   {
      // complete code to display fish in all tanks
      // compile and run your program now - before coding transferFish()
   }

   public void transferFish()
   {
      System.out.println("Transferring Fish...");
      // Prompt for the identity number of the "from tank" to remove from and
      // the "to tank" to add to and check they both exist.  
      // If they exist, prompt for the species to transfer and check if it
      // can be taken from the "from tank".
      // If ok, then check the species can be added to the "to tank"
      // If all checks are ok, transfer the fish, otherwise write a message 
      // to screen indicating the problem.
   }

   public static void main(String[] args)
   {
      Aquarium petShop = new Aquarium();
      
      petShop.displayTanks();

      petShop.transferFish();

      petShop.displayTanks();
   }
}
