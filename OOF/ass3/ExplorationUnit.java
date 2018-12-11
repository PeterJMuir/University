/*
 * Class Name:    ExplorationUnit
 *
 * Author:        Your Name
 * Creation Date: Monday, April 25 2016, 22:25 
 * Last Modified: Monday, May 09 2016, 00:56
 * 
 * Class Description:
 *
 * This is the proxy, "container" class that combines a Ship
 * and a Crew together.
 *
 * For use in OOF Assignment C Semester 1 2016.
 *
 * All interactions with Ship and Crew methods are through the
 * Ship and Crew object references.
 *
 * See page 8 of the assignment for an example
 */

public class ExplorationUnit
{
    private Ship ship;
    private Crew crew;
    
    public ExplorationUnit(String ShipId)
    {
       ship = new Ship(ShipId);
       crew = null;
    }

    public ExplorationUnit(String ShipId,int ShipCapacity,String ShipStatus,int ShipCurrentCrew,String CrewId,String CrewName,String CrewRole,int CrewNumberOfMissions,boolean CrewOnMission)
    {
       ship = new Ship(ShipId,ShipCapacity,ShipStatus,ShipCurrentCrew);
       if(CrewId == null)
       {
          crew = null;
       }else
       {
       crew = new Crew(CrewId,CrewName,CrewRole,CrewNumberOfMissions,CrewOnMission);
       }
    }

    public void addCrew(String CrewId, String CrewName, String CrewRole)
    {
       crew = new Crew(CrewId, CrewName, CrewRole);
       ship.addCurrentCrew();
    }

    public String toString()
    {
       if(ship == null)
       {
          return "No Ship present\n";
       }else
       {
          String temp = "Ship\n[" + ship + "]\nhas\n";
          if(crew == null)
          {
             return (temp + "No crew\n");
          }else
          {
             return (temp + "Crew\n[" + crew + "]\n");
          }
       }
    }

    public void startMission()
    {
       if((ship.getStatus().equals("available") && (crew != null) && (crew.getOnMission() == false)))
       {
          ship.changeStatus("on station");
          crew.changeOnMission();
          crew.incrementMissions();
       }else
       {
          System.out.println("This Ship is not available for a mission.");
       }
       
    }

    public void endMission()
    {
          crew.changeOnMission();   
    }

    public void changeShipStatus(String newStatus)
    {
       ship.changeStatus(newStatus);
    }

    public String getShipId()
    {
       return ship.getId();
    }

    public int getCurrentCrew()
    {
       return ship.getCurrentCrew();
    }

    public String getShipStatus()
    {
       return ship.getStatus();
    }
    public String getCrewId()
    {
       return crew.getId();
    }
}

