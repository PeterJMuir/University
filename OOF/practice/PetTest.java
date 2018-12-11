/*
 * Class Name:    PetTest
 *
 * Author:        Your Name
 * Creation Date: Monday, May 30 2016, 12:28 
 * Last Modified: Monday, May 30 2016, 12:32
 * 
 * Class Description:
 *
 */

public class PetTest
{
   public static void main(String[] args)
   {
      Pet Fido = new Pet("Fido","dog",3);
      System.out.println("Name: " + Fido.getName() + " Type: " + Fido.getType() + " Age: " + Fido.getAge());
      Fido.increaseAge();
      System.out.println("Name: " + Fido.getName() + " Type: " + Fido.getType() + " Age: " + Fido.getAge());
   }
}
