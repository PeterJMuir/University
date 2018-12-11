import java.util.*;

public class computer
{
   public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
      System.out.print("numberOfComputers ? ");
      int numberOfComputers = kb.nextInt();
      System.out.print("cableLength ? ");
      double cableLength = kb.nextDouble();
      System.out.print("rollLength ? ");
      double rollLength = kb.nextDouble();
      double computersPerRoll = rollLength/cableLength;
      int numberOfRolls = (int)Math.ceil(numberOfComputers/computersPerRoll);
      System.out.println("Computers per roll = " + computersPerRoll);
      System.out.println("Number of rolls = " + numberOfRolls);
   }
}
