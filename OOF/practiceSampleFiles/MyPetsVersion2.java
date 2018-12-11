// This driver program creates and manipulates a PetCollection object
import java.util.*;
public class MyPetsVersion2
{
   public static Scanner keyboard = new Scanner(System.in);

   public static void main(String[] args)
   {
      System.out.println("How many pets do you own? ");
      int count = keyboard.nextInt();
      keyboard.nextLine(); // consume \n

      PetCollection thePets = new PetCollection(count);

      // fill the pet collection
      for (int i = 0; i < count; ++i)
      {
         System.out.print("Pet " + (i + 1) + ": name ");
         String name = keyboard.nextLine();
         System.out.print("Pet " + (i + 1) + ": type ");
         String type = keyboard.nextLine();
         System.out.print("Pet " + (i + 1) + ": age in years ");
         int age = keyboard.nextInt();
         keyboard.nextLine(); // consume \n
         
         Pet pet = new Pet(name, type, age);
         thePets.add(pet);
      }

      thePets.displayDogNames();
      thePets.displayFNames();
      thePets.displayCatsTotalAges();
   }
}
