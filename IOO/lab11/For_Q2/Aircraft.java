// Lab 11
public class Aircraft
{
   private String registration;
   private int minimumRunway;

   public Aircraft(String registration, int minimumRunway)
   {
      this.registration = registration;
      this.minimumRunway = minimumRunway;
   }

   public String getRegistration()
   {
      return registration;
   }

   public int  getMinimumRunway()
   {
      return minimumRunway;
   }

   public String toString()
   {
      String description = getClass().getName() + "["
         + " registration: " + registration
         + ", minimumRunway: " + minimumRunway
         + " ]";
      return description;
   }
}
