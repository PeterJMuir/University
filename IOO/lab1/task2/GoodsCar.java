/*
 * Class Name:    GoodsCar
 *
 * Author:        Your Name
 * Creation Date: Tuesday, March 07 2017, 15:08 
 * Last Modified: Tuesday, March 07 2017, 15:14
 * 
 * Class Description:
 *
 */

public class GoodsCar extends RailroadCar
{
   private double goodsWeight;
   private String goodsDesc;

   public GoodsCar(String id, double tareWeight, double goodsWeight, String goodsDesc)
   {
      super(id, tareWeight);
      this.goodsWeight = goodsWeight;
      this.goodsDesc = goodsDesc;
   }

   public double calculateTotalWeight()
   {
      return (super.getTareWeight() + this.goodsWeight);
   }

   public String getDetails()
   {
      return super.getDetails() + ", goodsWeight: " + this.goodsWeight + ", goodsDescription: " + this.goodsDesc;
   }

   public String toString()
   {
      return "GoodsCar[\n" + this.getDetails() + "\n]";
   }
}
