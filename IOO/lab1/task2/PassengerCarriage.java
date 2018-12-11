/*
 * Class Name:    PassengerCarriage
 *
 * Author:        Your Name
 * Creation Date: Tuesday, March 07 2017, 14:59 
 * Last Modified: Tuesday, March 07 2017, 15:07
 * 
 * Class Description:
 *
 */

public class PassengerCarriage extends RailroadCar
{
   private int numberOfPassengers;

   public PassengerCarriage(String id, double tareWeight, int numberOfPassengers)
   {
      super(id, tareWeight);
      this.numberOfPassengers = numberOfPassengers;
   }

   public double calculateTotalWeight()
   {
      return (super.getTareWeight() + (0.105 * this.numberOfPassengers));
   }

   public String getDetails()
   {
      return super.getDetails() + ", numberOfPassengers: " + this.numberOfPassengers;
   }

   public String toString()
   {
      return "PassengerCarriage[\n" + this.getDetails() + "\n]";
   }
}
