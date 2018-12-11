/*
 * Class Name:    CarClubMember
 *
 * Author:        Your Name
 * Creation Date: Tuesday, April 19 2016, 13:55 
 * Last Modified: Tuesday, April 19 2016, 14:35
 * 
 * Class Description:
 *
 */

public class CarClubMember
{
   private String name = "";
   private String phone = "";
   private VintageCar car1;
   private VintageCar car2;

   public CarClubMember(String name, String phone)
   {
      this.name = name;
      this.phone = phone;
   }

   public String getName()
   {
      return this.name;
   }
   public String getPhone()
   {
      return this.phone;
   }

   public String getCar1Details()
   {
      if(this.car1 == null)
      {
         return "none";
      }
      return this.car1.toString();
   }

   public String getCar2Details()
   {
      if(this.car2 == null)
      {
         return "none";
      }
      return this.car2.toString();
   }

   public void setPhoneNumber(String phone)
   {
      this.phone = phone;
   }

   public boolean addCar(VintageCar newCar)
   {
      if(this.car1 == null)
      {
         this.car1 = newCar;
         return true;
      }else if(this.car2 == null)
      {
         this.car2 = newCar;
         return true;
      }
      return false;
   }

   public boolean changeOriginalBody(int car, boolean originalBody)
   {
      if((car == 1) && (this.car1 != null))
      {
         this.car1.setOriginalBody(originalBody);
         return true;
      }else if((car == 2) && (this.car2 != null))
      {
         this.car2.setOriginalBody(originalBody);
         return true;
      }
      return false;
   }

   public boolean canVote()
   {
      if((this.car1.isEligibleCar()) || (this.car2.isEligibleCar()))
      {
         return true;
      }
      return false;
   }

   public String toString()
   {
      String temp = "CarClubMember[name: " + getName() + ", phone: " + getPhone() + ", car1: " + car1.toString() + ", car2: " + car2.toString() + "]";
      return temp; 
   }
}
