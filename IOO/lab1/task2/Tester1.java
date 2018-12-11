/*
 * Class Name:    Tester1
 *
 * Author:        Your Name
 * Creation Date: Tuesday, March 07 2017, 15:20 
 * Last Modified: Tuesday, March 07 2017, 15:30
 * 
 * Class Description:
 *
 */

import java.util.*;

public class Tester1
{
   public static void main(String[] args)
   {
      RailroadCar[] train = new RailroadCar[4];

      train[0] = new RailroadCar("01", 2);
      System.out.println(train[0]);
      train[1] = new PassengerCarriage("02", 2, 200);
      System.out.println(train[1]);
      train[2] = new GoodsCar("03",4,3,"APPLES");
      System.out.println(train[2]);
      train[3] = new RefrigeratedUnit("04",5,3,"HEARTS",0.500);
      System.out.println(train[3]);

      for(RailroadCar p : train)
      {
         System.out.println(p);
      }

      //Total weight
      double totalWeight = 0;
      for(RailroadCar p : train)
      {
         totalWeight += p.calculateTotalWeight();
      }
      System.out.println(totalWeight + " tonnes");
   }
}
