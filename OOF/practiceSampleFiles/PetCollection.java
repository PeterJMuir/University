public class PetCollection
{
   private Pet[] pets;
   private int petCount;
   
   public PetCollection(int size)
   {
      pets = new Pet[size];
      petCount = 0;
   }
   
   public boolean add(Pet aPet)
   {
      if (petCount == pets.length)
      {
         return false;
      }
      else
      {
         pets[petCount] = aPet;
         petCount++;
         return true;
      }
   }
   
   public void displayDogNames()
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

   public void displayFNames()
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

   public void displayCatsTotalAges()
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
