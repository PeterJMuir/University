/*
 * Class Name:    Dog
 *
 * Author:        Your Name
 * Creation Date: Tuesday, March 07 2017, 14:23 
 * Last Modified: Tuesday, March 07 2017, 14:31
 * 
 * Class Description:
 *
 */

public class Dog extends Pet
{
   private String size;

   public Dog(String id, String name, String owner, String size)
   {
      super(id, name, owner);
      if(size.equals("small") || size.equals("medium") || size.equals("large"))
      {
         this.size = size;
      }else
      {
         this.size = "unknown";
      }
   }

   public Dog()   //default constructor just in case
   {
      super();
      this.size = "unknown";
   }

   public String getDetails()
   {
      return super.getDetails() + ", size: " + this.size;
   }

   public String toString()
   {
      return "Dog[\n" + this.getDetails() + "\n]";
   }

   public String getSize()
   {
      return this.size;
   }
}
