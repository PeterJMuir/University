/*
 * Class Name:    Pet
 *
 * Author:        Your Name
 * Creation Date: Monday, May 30 2016, 12:24 
 * Last Modified: Monday, May 30 2016, 12:28
 * 
 * Class Description:
 *
 */

public class Pet
{
   private String name;
   private String type;
   private int age;

   public Pet(String name, String type, int age)
   {
      this.name = name;
      this.type = type;
      this.age = age;
   }

   public void increaseAge()
   {
      ++age;
   }

   public String getName()
   {
      return name;
   }

   public String getType()
   {
      return type;
   }

   public int getAge()
   {
      return age;
   }
}
