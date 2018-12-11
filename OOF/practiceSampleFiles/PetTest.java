public class PetTest
{
   public static void main(String[] args)
   {
      Pet myPet = new Pet("Fido", "dog", 3);
      System.out.println("Pet object created");
      //System.out.println(myPet); uses toString
      System.out.println("The pet's name: " + myPet.getName());
      System.out.println("The pet's type: " + myPet.getType());
      System.out.println("The pet's age: " + myPet.getAge());
      System.out.println();

      System.out.println("Increasing age by invoking increaseAge()");
      myPet.increaseAge();
      System.out.println("After 1 year:");
      //System.out.println(myPet); uses toString
      System.out.println("The pet's name: " + myPet.getName());
      System.out.println("The pet's type: " + myPet.getType());
      System.out.println("The pet's age: " + myPet.getAge());
   } 
}
