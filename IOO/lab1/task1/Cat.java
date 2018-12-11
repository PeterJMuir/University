/*
 * Class Name:    Cat
 *
 * Author:        Your Name
 * Creation Date: Tuesday, March 07 2017, 14:23 
 * Last Modified: Tuesday, March 07 2017, 14:35
 * 
 * Class Description:
 *
 */

public class Cat extends Pet
{
   private String hairType;

   public Cat(String id, String name, String owner, String hairType)
   {
      super(id, name, owner);
      if(hairType.equals("SH") || hairType.equals("LH"))
      {
         this.hairType = hairType;
      }else
      {
         this.hairType = "unknown";
      }
   }

   public Cat()   //default constructor just in case
   {
      super();
      this.hairType = "unknown";
   }

   public String getDetails()
   {
      return super.getDetails() + ", hairType: " + this.hairType;
   }

   public String toString()
   {
      return "Cat[\n" + this.getDetails() + "\n]";
   }

   public String getHairType()
   {
      return this.hairType;
   }
}
