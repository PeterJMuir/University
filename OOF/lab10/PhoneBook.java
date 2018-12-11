/*
 * Class Name:    PhoneBook
 *
 * Author:        Your Name
 * Creation Date: Tuesday, May 10 2016, 13:02 
 * Last Modified: Tuesday, May 10 2016, 14:56
 * 
 * Class Description:
 *
 */

public class PhoneBook
{
   private static final int MAX_SIZE = 10;
   private Person[] entries;
   private int count;

   public PhoneBook()
   {
      entries = new Person[MAX_SIZE];
      count = 0;
   }

   void insert(String name, String phoneNumber)
   {
      if(count < MAX_SIZE) //if the array is not full
      {
         entries[count++] = new Person(name, phoneNumber);  //puts a new person into entries[count] then increments count
      }else
      {
         System.out.println("Cannot add Person, PhoneBook is full.");
      }
   }

   String searchByName(String targetName)
   {
      if(count > 0)
      {
         int index = -1;
         for(int i = 0; i < count; ++i)
         {
            if( entries[i].getName().equals(targetName))
            {
               index = i;
               i = count;
            }
         }
         if(index == -1)
         {
            return entries[i].getPhone();
         }else
         {
            return "Not found";
         }
      }else
      {
         return "Nothing in the PhoneBook";
      }
   }

   String searchByPhone(String targetPhone)
   {
   }
}
