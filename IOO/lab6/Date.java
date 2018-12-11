import java.io.Serializable;
public class Date implements Serializable
{
   private int day;
   private int month;
   private int year;

   public Date(int day, int month, int year)
   {
      this.day = day;
      this.month = month;
      this.year = year;
   }

   public int getDay()
   {
      return day;
   }

   public int getMonth()
   {
      return month;
   }

   public int getYear()
   {
      return year;
   }

   public boolean comesEarlierInYear(Date other)
   {
      if (month < other.getMonth())
      {
         return true;
      }
      else if (month > other.getMonth())
      {
         return false;
      }
      else 
      {
         return day < other.getDay();
      }
   }

   public boolean comesBefore(Date other)
   {
      if (year < other.getYear())
      {
         return true;
      }
      else if (year > other.getYear())
      {
         return false;
      }
      else if (month < other.getMonth())
      {
         return true;
      }
      else if (month > other.getMonth())
      {
         return false;
      }
      else 
      {
         return day < other.getDay();
      }
   }

   public String toString()
   {
      return day + "/" + month + "/" + year;
   }
}
