/*
 * Class Name:    DangerousDog
 *
 * Author:        Your Name
 * Creation Date: Tuesday, March 07 2017, 14:23 
 * Last Modified: Tuesday, March 07 2017, 14:42
 * 
 * Class Description:
 *
 */

public class DangerousDog extends Dog
{
   private int reportedIncidents;

   public DangerousDog(String id, String name, String owner, String size)
   {
      super(id, name, owner, size);
      reportedIncidents = 0;
   }

   public DangerousDog(String id, String name, String owner, String size, int reportedIncidents)
   {
      super(id, name, owner, size);
      this.reportedIncidents = reportedIncidents;
   }

   public DangerousDog()   //default constructor just in case
   {
      super();
      this.reportedIncidents = 0;
   }

   public void setReportedIncidents(int reportedIncidents)
   {
      this.reportedIncidents = reportedIncidents;
   }

   public String getDetails()
   {
      return super.getDetails() + ", reportedIncidents: " + this.reportedIncidents;
   }

   public String toString()
   {
      return "DangerousDog[\n" + this.getDetails() + "\n]";
   }

   public int getReportedIncidents()
   {
      return this.reportedIncidents;
   }
}
