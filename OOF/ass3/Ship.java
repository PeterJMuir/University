/*
 * Class Name:    Ship
 *
 * Author:        Your Name
 * Creation Date: Monday, April 25 2016, 22:29 
 * Last Modified: Monday, May 09 2016, 00:55
 * 
 * Class Description:
 *
 * This is the Ship class for use in OOF Assignment C
 * Semester 1 2016
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
 *
 * Note that in the basic requirements, it would be possible to
 * change the status of a Ship from available to on station,
 * even though the Ship is not on a mission, which is really
 * the only valid time that this change should be made.
 *
 * Assume that the user does not make this change.
 *
 * If you have time, implement code in ExplorationUnit.java
 * and/or Catco.java to ensure that the program prevents the
 * user from being able to change the status from available to
 * on station if the Ship is not on a mission.
 *
 * Things like trying to change the status from maintenance to
 * on station MUST be prevented by the program, this is a 
 * requirement.
 */

public class Ship
{
   private String id;
   private String status;
   private int capacity;
   private int currentCrew;

   public Ship(String id)
   {
      this.id = id;
      this.status = "available";
      this.capacity = 1;
      this.currentCrew = 0;
   }

   public Ship(String id,int capacity,String status,int currentCrew)
   {
      this.id = id;
      this.capacity = capacity;
      this.status = status;
      this.currentCrew = currentCrew;
   }

   public String getId()
   {
      return id;
   }

   public String getStatus()
   {
      return status;
   }

   public int getCapacity()
   {
      return capacity;
   }

   public int getCurrentCrew()
   {
      return currentCrew;
   }

   public void addCurrentCrew()
   {
      ++currentCrew;
   }

   public void changeStatus(String newStatus)
   {
      if(newStatus.equalsIgnoreCase("available"))
      {
         if((status.equals("maintenance") || status.equals("on station")))
         {
            status = "available";
         }else
         {
            System.out.println("Cannot change from " + status + " to " + newStatus);
         }
      }else if(newStatus.equalsIgnoreCase("maintenance"))
      {
         if(status.equals("on station"))
         {
            status = "maintenance";
         }else
         {
            System.out.println("Cannot change from " + status + " to " + newStatus);
         }
      }else if(newStatus.equalsIgnoreCase("on station"))
      {
         if(status.equals("available"))
         {
            status = "on station";
         }else
         {
            System.out.println("Cannot change from " + status + " to " + newStatus);
         }
      }else
      {
         System.out.println(newStatus + " is not a valid status.");
      }
   }
   public String toString()
   {
      String temp = "\n\tId: " + getId() + " capacity: " + getCapacity() + " current crew: " + getCurrentCrew() + " status: " + getStatus() + "\n";
      return temp;
   }
}
