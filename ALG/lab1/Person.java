/*
 * Class Name:    Person
 *
 * Author:        Julie Main
 * Creation Date: Friday, March 11 2005, 15:07
 * Last Modified: Monday, March 10 2008, 13:45
 *
 * Revision History
 *
 * Author:        Richard Tresider
 * Date:          March 09 2008
 * Description:   This class now implements the interface
 *                Comparable<T> from Java 1.5, replacing the
 *                interface Comparable which is Java 1.4, which was
 *                the standard when this class was originally written.
 *
 *                The compareTo method changes to take a Person object
 *                as the input parameter, rather than an Object object
 *                which was the requirement in Java 1.4 There is no need
 *                now, to cast from Object to Person.
 *
 *                There should no longer be unchecked warnings when
 *                this class is used with the rest of the lab.
 */

import java.util.*;

public  class Person implements Comparable<Person>
{
   private String firstName;
   private String lastName;
   private String address;
   private String suburb;
   private String state;
   private int postCode;
   private static int noOfComparisons = 0;

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


   public String toString()
   {
      return lastName + ", " + firstName + "\n" +
             address + "\n" +
             suburb + "\t" + state + "\t" + postCode + "\n";
   }


   public boolean equals(String first, String last, int post)
   {
      return this.firstName.equalsIgnoreCase(first)
             && this.lastName.equalsIgnoreCase(last)
             && this.postCode == post;
   }


   /*
    * Changed Mar 09 2008 to take a Person object, rather than an
    * Object object as we are now implementing Comparable<T>, rather
    * than Comparable
    */

   public  int compareTo(Person p)
   {
      ++noOfComparisons;

      int lastNameDifference =
          this.lastName.compareToIgnoreCase(p.lastName);

      if (lastNameDifference != 0)
      {
         return lastNameDifference;
      }
      else
      {
         int firstNameDifference =
             this.firstName.compareToIgnoreCase(p.firstName);
         if (firstNameDifference != 0)
         {
            return firstNameDifference;
         }
         else
         {
            return this.postCode - p.postCode;
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

