public class Person implements StringKeyed
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

   public boolean equals( Person p )
   {
      return this.firstName.equalsIgnoreCase(p.firstName) 
             && this.lastName.equalsIgnoreCase(p.lastName)
             && this.postCode == p.postCode;
   }

   public int compareTo(Object p)
   {
      Person other = (Person) p;
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

   public static int getCounter()
   {
      return noOfComparisons;
   }

   public static void resetCounter()
   {
      noOfComparisons = 0;
   }

   public String getStringKey()
   {
      return lastName + firstName + postCode;
   }
}

