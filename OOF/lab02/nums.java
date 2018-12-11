import java.util.*;

public class nums
{
   public static void main(String[] args)
   {
      Scanner kbd = new Scanner(System.in);
      System.out.print("Enter the first integer: ");
      int a = kbd.nextInt();
      System.out.print("Enter the second integer: ");
      int b = kbd.nextInt();
      int sum = a + b;
      double average = (double) sum/2;
      System.out.println("The sum of " + a + " and " + b + " is: " + sum);
      System.out.println("The average of " + a + " and " + b + " is: " + average);
   }
}
