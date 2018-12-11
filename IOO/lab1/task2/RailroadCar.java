/*
 * Class Name:    RailroadCar
 *
 * Author:        Your Name
 * Creation Date: Tuesday, March 07 2017, 14:54 
 * Last Modified: Tuesday, March 07 2017, 15:14
 * 
 * Class Description:
 *
 */

public class RailroadCar
{
   private String id;
   private double tareWeight;

   public RailroadCar(String id, double tareWeight)
   {
      this.id = id;
      this.tareWeight = tareWeight;
   }

   public double getTareWeight()
   {
      return tareWeight;
   }

   public double calculateTotalWeight()
   {
      return tareWeight;
   }

   public String getDetails()
   {
      return "id: " + this.id + ", tareWeight: " + this.tareWeight;
   }

   public String toString()
   {
      return "RailroadCar[\n" + this.getDetails() + "\n]";
   }
}
