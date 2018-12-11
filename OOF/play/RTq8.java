/*
 * Class Name:    RTq8
 *
 * Author:        Your Name
 * Creation Date: Saturday, June 04 2016, 17:08 
 * Last Modified: Saturday, June 04 2016, 18:12
 * 
 * Class Description:
 *
 */
import java.util.*;
public class RTq8
{
   public static void main(String[] args)
   {
      System.out.print("Enter a lower case letter: ");
      Scanner kb = new Scanner(System.in);
      char letter = kb.nextLine().charAt(0);
      System.out.print("Enter an integer: ");
      int size = kb.nextInt();
      for(int i = 1; i <= size; ++i)
      {
         for(int j = 0; j < (size-i); ++j)
         {
            System.out.print(" ");
         }
         for(int k = i-1;k > 0;--k)
         {
            char altered = (char)(letter - k);
            while((altered < 'a') || (altered > 'z'))
            {
               if(altered < 'a')
               {
                  altered += 26;
               }else if(altered > 'z')
               {
                  altered -= 26;
               }
            }
            System.out.print(altered);
         }
         for(int l = 0; l < i; ++l)
         {
            char altered = (char)(letter - l);
            while((altered < 'a') || (altered > 'z'))
            {
               if(altered < 'a')
               {
                  altered += 26;
               }else if(altered > 'z')
               {
                  altered -= 26;
               }
            }
            System.out.print(altered);
         }
         for(int j = 0; j < (size-i); ++j)
         {
            System.out.print(" ");
         }
         System.out.println();
      }
   }
}
