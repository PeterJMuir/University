/*
 * Class Name:    Crew
 *
 * Author:        Your Name
 * Creation Date: Monday, April 25 2016, 22:29 
 * Last Modified: Sunday, May 22 2016, 14:16
 * 
 * Class Description:
 *
 * This is the Crew class for use in OOF Assignment C
 * Semester 1 2016
 *
 */
import java.io.PrintWriter;
import java.io.IOException;

public class Crew
{
   private String name;
   private String role;
   private boolean onMission;
   private String id;
   private int numberOfMissions;

   public Crew(String id,String name,String role)
   {
      this.name = name;
      this.id = id;
      this.role = role;
      onMission = false;
      numberOfMissions = 0;
   }

   public Crew(String id,String name,String role,int numberOfMissions,boolean onMission)
   {
      this.id = id;
      this.name = name;
      this.role = role;
      this.numberOfMissions = numberOfMissions;
      this.onMission = onMission;
   }

   public void changeOnMission()
   {
      onMission = !onMission;
   }

   public void incrementMissions()
   {
      ++numberOfMissions;
   }

   public boolean getOnMission()
   {
      return onMission;
   }

   public String getName()
   {
      return name;
   }

   public String getRole()
   {
      return role;
   }

   public String getId()
   {
      return id;
   }

   public int getNumberOfMissions()
   {
      return numberOfMissions;
   }

   public String toString()
   {
      String temp = "\n\tName: " + getName() + " role: " + getRole() + " id: " + getId() + "\n\tNumber of missions: " + getNumberOfMissions() + "\n";
      if(getOnMission())
      {
         temp = temp + "\tis on a mission\n";
      }else
      {
         temp = temp + "\tis not on a mission\n";
      }
      return temp;
   }
}
