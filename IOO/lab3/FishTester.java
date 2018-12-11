// Lab 3
// Question 1: Used to test method waterSuitable
public class FishTester
{
   public static void main(String[] args)
   {
      Fish nemo = new Fish("clownfish", 'T', 'S');

      // output nemo's details
      System.out.println(" nemo's details: toString()");
      System.out.println(nemo);

      // display the species nemo belong to
      System.out.println(" getSpecies():");
      System.out.println(nemo.getSpecies());

      // test if various water environments are suitable for nemo
      System.out.println(" waterSuitable('T', 'S'):");
      System.out.println(nemo.waterSuitable('T','S'));
      System.out.println(" waterSuitable('C', 'S'):");
      System.out.println(nemo.waterSuitable('C','S'));
      System.out.println(" waterSuitable('T', 'F'):");
      System.out.println(nemo.waterSuitable('T','F'));
      System.out.println(" waterSuitable('C', 'F'):");
      System.out.println(nemo.waterSuitable('C','F'));
   }
}
