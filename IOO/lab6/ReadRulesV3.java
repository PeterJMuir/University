/*
 * Class Name:    ReadRulesV3
 *
 * Author:        Your Name
 * Creation Date: Tuesday, April 11 2017, 09:23 
 * Last Modified: Tuesday, April 11 2017, 14:45
 * 
 * Class Description:
 *
 */
import java.io.*;
public class ReadRulesV3
{
   public static void main( String[] args) throws Exception
   {
      try{
         ObjectInputStream numInFile = new ObjectInputStream(
               new FileInputStream("numbers3.bin"));
         int count = 5;
         int[] nums = new int[5];
         for(int i = 0; i < 5; ++i)
         {
            try{
               if(numInFile != null)
               {
                  nums[i] = numInFile.readInt();
               }

               /*if(-1 == nums[i])
                 {
                 count = i;
                 break;
                 }*/ //was for using an invalid numbers/rules pair

            }catch(EOFException e)
            {
               count = i;
               break;
            }
         }
         ObjectInputStream rulesInFile = new ObjectInputStream(
               new FileInputStream("rules3.bin"));

         String[] rules = new String[5];
         for(int i = 0; i < 5; ++i)
         {
            try{
               rules[i] = rulesInFile.readUTF();
            }catch(EOFException e)
            {
               if(i < count)
               {
                  count = i;
               }
               break;
            }
         }

         for(int i = 0; i < count; ++i)
         {
            System.out.printf("%4d: %s\n",nums[i],rules[i]);
         }

         numInFile.close();
         rulesInFile.close();
      }catch(FileNotFoundException e)
      {
         System.out.println(e);
      }
   }
}
