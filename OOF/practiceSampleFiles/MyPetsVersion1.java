// A procedural solution follows for 8c).  
// See files PetCollection.java and MyPetsVersion2.java for an OO approach
// You should be able to do the object-oriented but any approach that performs 
// the required functionality will be acceptable in the Programming Test
import java.util.*;
public class MyPetsVersion1
{
   public static Scanner keyboard = new Scanner(System.in);

   public static void main(String[] args)
   {
      System.out.println("How many pets do you own? ");
      int count = keyboard.nextInt();
      keyboard.nextLine(); // consume \n

      Pet[] thePets = new Pet[count];
      enterPetDetails(thePets);
      System.out.println();

      displayDogs(thePets);
      System.out.println();

      displayFNames(thePets);
      System.out.println();

      displayCatsTotalAges(thePets);
   }

   public static void enterPetDetails(Pet[] pets)
   {
      for (int i = 0; i < pets.length; ++i)
      {
         System.out.print("Pet " + (i + 1) + ": name ");
         String name = keyboard.nextLine();
         System.out.print("Pet " + (i + 1) + ": type ");
         String type = keyboard.nextLine();
         System.out.print("Pet " + (i + 1) + ": age in years ");
         int age = keyboard.nextInt();
         keyboard.nextLine(); // consume \n

         pets[i] = new Pet(name, type, age);
      }
   }

   public static void displayDogs(Pet[] pets)
   {
      System.out.println("The names of any dogs follow.");
      for (int i = 0; i < pets.length; ++i)
      {
         if (pets[i].getType().equalsIgnoreCase("dog"))
         {
            System.out.println(pets[i].getName());
         }
      }
   }

   public static void displayFNames(Pet[] pets)
   {
      System.out.println("The pet names that start with 'F' follow.");
      for (int i = 0; i < pets.length; ++i)
      {
         if (pets[i].getName().charAt(0) == 'F')
         {
            System.out.println(pets[i].getName());
         }
      }
   }

   public static void displayCatsTotalAges(Pet[] pets)
   {
      System.out.print("The combined ages of all the cats is ");
      int agesOfCats = 0;
      for (int i = 0; i < pets.length; ++i)
      {
         if (pets[i].getType().equalsIgnoreCase("cat"))
         {
            agesOfCats += pets[i].getAge();
         }
      }
      System.out.println(agesOfCats);
   }
}
