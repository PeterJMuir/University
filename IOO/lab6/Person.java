import java.io.*;
public class Person implements Serializable
{
   private String familyName;
   private String givenName;
   private Date birthDate;
   private String emailAddress;
   private String phoneNumber;

   public Person(String familyName, String givenName, 
          int birthDay, int birthMonth, int birthYear, 
          String email, String phone)
   {
      this.familyName = familyName;
      this.givenName = givenName;   
      this.birthDate = new Date(birthDay, birthMonth, birthYear);
      this.emailAddress = email;
      this.phoneNumber = phone;
   }

   public String getFamilyName()
   {
      return familyName;
   }

   public String getGivenName()
   {
      return givenName;
   }
   
   public Date getBirthDate()
   {
      return birthDate;
   }

   public String getEmailAddress()
   {
      return emailAddress;
   }
   public String getPhoneNumber()
   {
      return phoneNumber;
   }

   public void setEmailAddress(String newEmail)
   {
      emailAddress = newEmail;
   }
   
   public void setPhonenNumber(String newPhoneNumber)
   {
      phoneNumber = newPhoneNumber;
   }

   public void setFamilyName(String newFamilyName)
   {
      familyName = newFamilyName;
   }

   public void setGivenName(String newGivenName)
   {
      givenName = newGivenName;
   }

   public boolean isOlderThan(Person otherPerson)
   {
      return birthDate.comesBefore(otherPerson.getBirthDate());
   }

   public boolean birthdayComesBefore(Person otherPerson)
   {
      return birthDate.comesEarlierInYear(otherPerson.getBirthDate());
   }

   public boolean birthdayComesAfter(Person otherPerson)
   {
      return !birthdayComesBefore(otherPerson);
   }

   public int compareTo(Person otherPerson)
   {
      if (familyName.compareTo(otherPerson.getFamilyName()) != 0)
      {
         return familyName.compareTo(otherPerson.familyName);
      }
      else
      {
         return givenName.compareTo(otherPerson.givenName);
      }
   }

   public void outputContact(PrintWriter output)
   {
      output.println("Name: " + familyName + ", " + givenName);
      output.println("Birthday: " + birthDate);
      output.println("Email: " +  emailAddress);
      output.println("Phone: " + phoneNumber);
   }

   public String getBirthdayListingLine()
   {
      return birthDate.getDay() + "/" + birthDate.getMonth() + "\t" +
             givenName + " " + familyName;
   }

   public String getContactListingLine()
   {
      return givenName + " " + familyName + " Email: " + emailAddress + 
             " " + "Phone: " + phoneNumber;
   }
}
