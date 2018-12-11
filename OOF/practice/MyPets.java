/*
 * Class Name:    MyPets
 *
 * Author:        Your Name
 * Creation Date: Monday, May 30 2016, 12:33 
 * Last Modified: Monday, May 30 2016, 12:51
 * 
 * Class Description:
 *
 */
import java.util.*;
public class MyPets
{
   public static void main(String[] args)
   {
      System.out.print("How many pets do you own? ");
      Scanner kb = new Scanner(System.in);
      Pet[] myPets = new Pet[kb.nextInt()];
      kb.nextLine();
      for(int i = 0; i < myPets.length; ++i)
      {
         System.out.print("Enter the name of Pet number " + (i+1) + ": ");
         String name = kb.nextLine();
         System.out.print("Enter the type of Pet number " + (i+1) + ": ");
         String type = kb.nextLine();
         System.out.print("Enter the age of Pet number " + (i+1) + ": ");
         int age = kb.nextInt();
         kb.nextLine();
         myPets[i] = new Pet(name,type,age);
      }
      System.out.println("\nThe names of all the dogs are:\n");
      for(Pet a: myPets)
      {
         if(a.getType().equalsIgnoreCase("dog"))
         {
            System.out.println(a.getName());
         }
      }
      System.out.println("\nThe names of all the pets whose names begin with \'F\' are:\n");
      for(Pet a: myPets)
      {
         if((a.getName().charAt(0) == 'F'))
         {
            System.out.println(a.getName());
         }
      }
      System.out.println("\nThe combined age of all the cats is:\n");
      int combinedAge = 0;
      for(Pet a: myPets)
      {
         if(a.getType().equalsIgnoreCase("cat"))
         {
            combinedAge += a.getAge();
         }
      }
      System.out.println(combinedAge + "\n");
   }
}
