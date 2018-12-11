/*
 * Class Name:    ReadRulesV1
 *
 * Author:        Your Name
 * Creation Date: Tuesday, April 11 2017, 09:23 
 * Last Modified: Tuesday, April 11 2017, 14:16
 * 
 * Class Description:
 *
 */
import java.io.*;
public class ReadRulesV1
{
   public static void main( String[] args) throws Exception
   {
      ObjectInputStream numInFile = new ObjectInputStream(
         new FileInputStream("numbers3.bin"));

      int[] nums = new int[5];
      for(int i = 0; i < 5; ++i)
      {
         nums[i] = numInFile.readInt();
      }

      ObjectInputStream rulesInFile = new ObjectInputStream(
         new FileInputStream("rules3.bin"));

      String[] rules = new String[5];
      for(int i = 0; i < 5; ++i)
      {
         rules[i] = rulesInFile.readUTF();
      }

      for(int i = 0; i < 5; ++i)
      {
         System.out.printf("%4d: %s\n",nums[i],rules[i]);
      }
      
      numInFile.close();
      rulesInFile.close();
   }
}
