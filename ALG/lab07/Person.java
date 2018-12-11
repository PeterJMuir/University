/*
 * Class Name:    Person
 *
 * Author:        Julie Main
 * Creation Date: Friday, March 11 2005, 15:07 
 * Last Modified: Monday, April 03 2006, 13:42
 * 
 * Revision: Richard Tresider
 *           Apr 27 2008
 *
 * This class now implements Comparable<T> from java 1.6
 * 
 */

import java.util.*;

public class Person implements Comparable<Person>
{
   private String firstName;
   private String lastName;
   private String address;
   private String suburb;
   private String state;
   private int postCode;
   private static int noOfComparisons = 0;  

   // Lab 01, Question 1 - b - i

   public Person(String firstName, String lastName, String address,
                String suburb, String state, int postCode)
   {
      this.firstName = firstName;
      this.lastName = lastName;
      this.address = address;
      this.suburb = suburb;
      this.state = state;
      this.postCode = postCode;
   }

   // Lab 01, Question 1 - b - ii
   
   public String toString()
   {
      return lastName + ", " + firstName + "\n" +
             address + "\n" +
             suburb + "\t" + state + "\t" + postCode + "\n";
   }

   // Lab 01, Question 1 - b - iii
   
   public boolean equals(String first, String last, int post)
   {
      return this.firstName.equalsIgnoreCase(first) 
             && this.lastName.equalsIgnoreCase(last)
             && this.postCode == post;
   }

   /*
    * This method now takes a Person object as a parameter,
    * since the only thing that we can compare inside a Person
    * class are Person objects. As a result it is not necessary to 
    * to test if the parameter is of class Person as it was in the
    * older version of this method when the class implemented
    * Comparable from Java 1.4
    */
   public boolean equals(Person otherPerson)
   {
         return this.firstName.equalsIgnoreCase(otherPerson.firstName) 
             && this.lastName.equalsIgnoreCase(otherPerson.lastName)
             && this.postCode == otherPerson.postCode;
   }

   /* Likewise this method now takes a Person object as a parameter
    * so a cast is not longer required
    */

   public int compareTo(Person other)
   {
      ++noOfComparisons;             

      int lastNameDifference = 
          this.lastName.compareToIgnoreCase(other.lastName);
      
      if (lastNameDifference != 0)
      {
         return lastNameDifference;
      }
      else 
      {
         int firstNameDifference = 
             this.firstName.compareToIgnoreCase(other.firstName);
         if (firstNameDifference != 0)
         {
            return firstNameDifference;
         }
         else
         {
            return this.postCode - other.postCode;
         }
      }
   }


   public String getLastName()
   {
      return this.lastName;
   }
   
   public String getFirstName()
   {
      return this.firstName;
   }

   public String getAddress()
   {
      return this.address;
   }
  
   public String getSuburb()
   {
      return this.suburb;
   }

   public String getState()
   {
      return this.state;
   }

   public int getPostCode()
   {
      return this.postCode;
   }

   // Lab 02, Question 1 - c

   public static int getCounter()
   {
      return noOfComparisons;
   }

   // Lab 02, Question 1 - d

   public static void resetCounter()
   {
      noOfComparisons = 0;
   }
}

