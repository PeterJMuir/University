/*
 * Class Name:    RefrigeratedUnit
 *
 * Author:        Your Name
 * Creation Date: Tuesday, March 07 2017, 15:15 
 * Last Modified: Tuesday, March 07 2017, 15:19
 * 
 * Class Description:
 *
 */

public class RefrigeratedUnit extends GoodsCar
{
   private double coolantWeight;

   public RefrigeratedUnit(String id, double tareWeight, double goodsWeight, String goodsDesc, double coolantWeight)
   {
      super(id, tareWeight, goodsWeight, goodsDesc);
      this.coolantWeight = coolantWeight;
   }

   public double calculateTotalWeight()
   {
      return (super.calculateTotalWeight() + this.coolantWeight);
   }

   public String getDetails()
   {
      return super.getDetails() + ", coolantWeight: " + this.coolantWeight;
   }

   public String toString()
   {
      return "RefrigeratedUnit[\n" + this.getDetails() + "\n]";
   }
}
