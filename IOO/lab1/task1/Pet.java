/*
 * Class Name:    Pet
 *
 * Author:        Your Name
 * Creation Date: Tuesday, March 07 2017, 14:14 
 * Last Modified: Tuesday, March 07 2017, 14:21
 * 
 * Class Description:
 *
 */

public class Pet
{
   private String id, name, owner;
   public Pet(String id, String name, String owner)
   {
      this.id = id;
      this.name = name;
      this.owner = owner;
   }

   public Pet()
   {
      this.id = "unknown";
      this.name = "unknown";
      this.owner = "unknown";
   }

   public String getDetails()
   {
      return "id: " + this.id + ", name: " + this.name + ", owner: " + this.owner;
   }

   public String toString()
   {
      return "Pet[\n" + getDetails() + "\n]";
   }

   public String getId()
   {
      return this.id;
   }

   public String getName()
   {
      return this.name;
   }

   public String getOwner()
   {
      return this.owner;
   }
}
