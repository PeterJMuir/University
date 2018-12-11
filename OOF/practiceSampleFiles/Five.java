import java.util.*;
public class Five
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      System.out.print("How many lines should the box be ");
      System.out.print("(enter an integer > 2): ");
      int size = keyboard.nextInt();
      
      for (int i = 1; i <= size; ++i)
      {
         for (int j = 1; j <= size; ++j)
         {
            System.out.print("*");
         }
         System.out.println();
      }
   } 
}
