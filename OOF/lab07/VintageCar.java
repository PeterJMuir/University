/*
 * Class Name:    VintageCar
 *
 * Author:        Your Name
 * Creation Date: Tuesday, April 19 2016, 13:10 
 * Last Modified: Tuesday, April 19 2016, 13:51
 * 
 * Class Description:
 *
 */

public class VintageCar
{
   private String make = "";
   private String model = "";
   private int year;
   private boolean originalBody;
   private String category = "";
   public VintageCar(String make, String model, int year, boolean originalBody)
   {
      this.make = make;
      this.model = model;
      this.year = year;
      this.originalBody = originalBody;
      setCategory();
   }

   private void setCategory()
   {
      if(year < 1919)
      {
         category = "Historic";
      }else if(year < 1931)
      {
         category = "Vintage";
      }else if(year < 1940)
      {
         category = "Postvintage";
      }else
      {
         category = "Other";
      }
   }

   public String getMake()
   {
      return make;
   }

   public String getModel()
   {
      return model;
   }

   public int getYear()
   {
      return year;
   }

   public boolean getOriginalBody()
   {
      return originalBody;
   }

   public String getCategory()
   {
      return category;
   }

   public void setOriginalBody(boolean originalBody)
   {
      this.originalBody = originalBody;
   }

   public boolean isEligibleCar()
   {
      if(category == "Historic" || category == "Vintage" || category == "Postvintage")
      {
         return true;
      }else
      {
         return false;
      }
   }

   public int compareAge(VintageCar otherCar)
   {
      return (this.year - otherCar.getYear());
   }

   public boolean sameType(VintageCar otherCar)
   {
      return ((0 == (this.make).compareToIgnoreCase(otherCar.getMake())) && (0 == (this.model).compareToIgnoreCase(otherCar.getModel())));
   }

   public String toString()
   {
      String temp = "VintageCar[make: " + getMake() + ", model: " + getModel() + ", year: " + getYear() + ", originalBody: " + getOriginalBody()
      + ", category: " + getCategory() + "]";
      return temp;
   }
}
