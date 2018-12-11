/*
 * Class Name:    Ship
 *
 * Author:        Your Name
 * Creation Date: Monday, April 25 2016, 22:29 
 * Last Modified: Sunday, May 22 2016, 15:28
 * 
 * Class Description:
 *
 * This is the Ship class for the OOF Progress Check Test
 * assignment Semester 1 2016
 *
 * There is no ExplorationUnit class in this assignment.
 *
 * The Ship class still has many of the same things as it
 * had in assignment C, including the status
 *
 * The major difference is that now the Ship class has an
 * array of Crew objects (object references).
 *
 * In the main Catco class there will be an array of Ships.
 *
 * This requires several new accessor and mutator methods.
 *
 *
 *
 * Ship status can only be one of
 *    available
 *    on station
 *    maintenance
 *
 * If status is maintenance then the only valid update is to
 * available
 *
 * If the status is available then the only valid update is 
 * on station
 *
 * If the status is on station then the only valid updates are
 * available or maintenance.
 */

import java.io.PrintWriter;
import java.io.IOException;

public class Ship
{
   private String id;
   private int capacity;
   private int currentCrew; // index into the Crew array
   // points to the next free space
   // in the Crew array
   private String status;

   private Crew [ ] crew;

   public Ship(String id, int capacity)
   {
      this.id = id;
      this.capacity = capacity;
      this.currentCrew = 0;
      this.status = "available";
      crew = new Crew[capacity];
   }

   public Ship(String id, int capacity,String status)
   {
      this.id = id;
      this.capacity = capacity;
      this.status = status;
      currentCrew = 0;
      crew = new Crew[capacity];
   }

   public void addCrew(String crewId,String name,String role,int numberOfMissions,boolean onMission)
   {
      if(currentCrew < capacity)
      {
         crew[currentCrew++] = new Crew(crewId,name,role,numberOfMissions,onMission);
      }else
      {
         System.out.println("There is no more room on the ship for this Crew");
      }
   }

   public void addCrew(String crewId,String name,String role)
   {
      if(currentCrew < capacity)
      {
         crew[currentCrew++] = new Crew(crewId,name,role);
      }else
      {
         System.out.println("There is no more room on the ship for this Crew");
      }
   }

   public String getId()
   {
      return id;
   }
   public int getCurrentCrew()
   {
      return currentCrew;
   }
   public int getCapacity()
   {
      return capacity;
   }
   public String getStatus()
   {
      return status;
   }
   public void changeStatus(String newStatus)
   {
      if(newStatus.equalsIgnoreCase("available"))
      {
         if(status.equals("maintenance"))
         {
            status = "available";
         }else if(status.equals("on station"))
         {
            status = "available";
            for(int i = 0; i < currentCrew; i++)
            {
               crew[i].changeOnMission();
            }
         }else
         {
            System.out.println("Cannot change from " + status + " to " + newStatus);
         }
      }else if(newStatus.equalsIgnoreCase("maintenance"))
      {
         if(status.equals("on station"))
         {
            status = "maintenance";
            for(int i = 0; i < currentCrew; i++)
            {
               crew[i].changeOnMission();
            }
         }else
         {
            System.out.println("Cannot change from " + status + " to " + newStatus);
         }
      }else if(newStatus.equalsIgnoreCase("on station"))
      {
         if(status.equals("available"))
         {
            status = "on station"; 
            for(int i = 0; i < currentCrew; i++)
            {
               crew[i].changeOnMission();
               crew[i].incrementMissions();
            }
         }else
         {
            System.out.println("Cannot change from " + status + " to " + newStatus);
         }
      }else
      {
         System.out.println(newStatus + " is not a valid status.");
      }
   }


   public int searchCrewId(String crewId)
   {
      int index = -1;
      for(int i = 0; (-1 == index) && (i < currentCrew); ++i)
      {
         if(crew[i].getId().equals(crewId))
         {
            index = i;
         }
      }
      return index;
   }

   public String toString()
   {
      String temp = "\n\tId: " + getId() + " capacity: " + getCapacity() + " current crew: " + getCurrentCrew() + " status: " + getStatus() + "\n";
      return temp;
   }

   public String displayCrew(int crewNum)
   {
      return crew[crewNum].toString();
   }

   public String printCrew()
   {
      String temp = "";
      for(int i = 0; i < currentCrew; ++i)
      {
         temp = temp + crew[i].getId() + "\n" + crew[i].getName() + "\n" + crew[i].getRole() + "\n" + crew[i].getNumberOfMissions() + "\n" + crew[i].getOnMission() + "\n";
      }
      return temp;
   }

}

