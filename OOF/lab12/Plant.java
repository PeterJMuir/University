/*
 * Class Name:    Plants
 *
 * Author:        Your Name
 * Creation Date: Tuesday, May 24 2016, 13:28 
 * Last Modified: Tuesday, May 24 2016, 14:45
 * 
 * Class Description:
 *
 */

public class Plant
{
   private String name;
   private String comments;
   public Plant(String name, String comments)
   {
      this.name = name;
      this.comments = comments;
   }
   public String getName()
   {
      return name;
   }
   public String getComments()
   {
      return comments;
   }

   public void setComments(String comments)
   {
      this.comments = comments;
   }

   public void display()
   {
      System.out.println("Name: " + name);
      System.out.println("Comments: " + comments);
   }
}
