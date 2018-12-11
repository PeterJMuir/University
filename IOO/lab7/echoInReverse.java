/*
 * Class Name:    echoInReverse
 *
 * Author:        Your Name
 * Creation Date: Tuesday, May 02 2017, 09:13 
 * Last Modified: Tuesday, May 02 2017, 09:28
 * 
 * Class Description:
 *
 */
import java.util.Scanner;
public class echoInReverse
{
   public static void main(String[] args)
   {
      EIR();
      System.out.println();
   }

   public static void EIR ()
   {
      System.out.println("Enter a positive integer or -1 to print previous integers in reverse:");
      Scanner kb = new Scanner(System.in);
      int n = kb.nextInt();
      if(-1 == n)
      {
         return;
      }else
      {
         EIR();
         System.out.print(n + " ");
      }
   }
}
