import java.io.*;
public class Contacts implements Serializable 
{
   private Person[] contactList;
   private int numberOfContacts;

   public Contacts() 
   {
      contactList = new Person[16];
      numberOfContacts = 0;
   }

   public void add(Person p)
   {
      if (numberOfContacts >= contactList.length)
      {
         doubleArray();
      }
      contactList[numberOfContacts] = p;
      ++numberOfContacts;
   } 

   private void doubleArray()
   {
      Person[] newArray = new Person[contactList.length * 2];
      for (int i = 0; i < contactList.length; ++i)
      {
         newArray[i] = contactList[i];
      }
      contactList = newArray;
   }

   public void birthdayList(PrintWriter outstream)
   {
      sortByBirthday();
      for (int i = 0; i < numberOfContacts; ++i)
      {
         outstream.println(contactList[i].getBirthdayListingLine());
      }
   }

   private void sortByBirthday()
   {
      for (int i = numberOfContacts - 1; i > 0; --i)
      {
         int indexOfLatest = indexOfLatestDate(0, i);
         swap(i, indexOfLatest);
      }
   }

   private int indexOfLatestDate(int start, int end)
   {
      int indexOfLatest = start;
      for (int i = start + 1; i <= end; ++i)
      {
         if (contactList[i].birthdayComesAfter(contactList[indexOfLatest]))
         {
            indexOfLatest = i;
         }
      }
      return indexOfLatest;
   }

   private void swap(int i, int j)
   {
      Person temp = contactList[i];
      contactList[i] = contactList[j];
      contactList[j] = temp;
   }

   public void contactList(PrintWriter outstream)
   {
      sortByName();
      for (int i = 0; i < numberOfContacts; ++i)
      {
         outstream.println(contactList[i].getContactListingLine());
      }
   }

   private void sortByName()
   {
      for (int i = numberOfContacts - 1; i > 0; --i)
      {
         int indexOfBiggest = indexOfBiggest(0, i);
         swap(i, indexOfBiggest);
      }
   }

   private int indexOfBiggest(int start, int end)
   {
      int indexOfBiggest = start;
      for (int i = start + 1; i <= end; ++i)
      {
         if (contactList[i].compareTo(contactList[indexOfBiggest]) > 0)
         {
            indexOfBiggest = i;
         }
      }
      return indexOfBiggest;
   }
}
