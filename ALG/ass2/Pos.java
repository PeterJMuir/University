/*
 * Class Name:    Pos
 *
 * Author:        Peter Muir
 * Creation Date: Friday, February 03 2017, 18:56 
 * Last Modified: Monday, February 06 2017, 23:52
 * 
 * Class Description:
 *Short for 'Position Reports', this class is initialised through the myShipFinder program.
 *
 */

public class Pos implements Comparable<Pos>
{
   private String idmessage;
   private String idsession;
   private String time_stamp_system;
   private String NMEA_string;
   private String processed;
   private String MMSI;
   private String navigation_status;
   private String ROT;
   private String SOG;
   private String position_accuracy;
   private double longitude;
   private double latitude;
   private String COG;
   private String trueheading;
   private String maneuver_indicator;
   private String RAIM_flag;
   private String diagnostic_information;
   private String time_stamp_seconds_only;

   private static char compFlag = 'a'; //static flag to determine which attribute is being used for compareTo()

   public Pos (String idmessage, String idsession, String time_stamp_system, String NMEA_string, String processed,
         String MMSI, String navigation_status, String ROT, String SOG, String position_accuracy, String longitude,
         String latitude, String COG, String trueheading, String maneuver_indicator, String RAIM_flag,
         String diagnostic_information, String time_stamp_seconds_only)
   {
      this.idmessage = idmessage;
      this.idsession = idsession;
      this.time_stamp_system = time_stamp_system;
      this.NMEA_string = NMEA_string;
      this.processed = processed;
      this.MMSI = MMSI;
      this.navigation_status = navigation_status;
      this.ROT = ROT;
      this.SOG = SOG;
      this.position_accuracy = position_accuracy;
      this.longitude = Double.parseDouble(longitude);
      this.latitude = Double.parseDouble(latitude);
      this.COG = COG;
      this.trueheading = trueheading;
      this.maneuver_indicator = maneuver_indicator;
      this.RAIM_flag = RAIM_flag;
      this.diagnostic_information = diagnostic_information;
      this.time_stamp_seconds_only = time_stamp_seconds_only;
   }

   public int compareTo(Pos p)
   {
      switch(Pos.compFlag)
      {
         case 'a':      //sorting by latitude
            if(this.latitude > p.latitude) return 1;
            if(this.latitude < p.latitude) return -1;
            return 0;
         case 'o':      //sorting by longitude
            if(this.longitude > p.longitude) return 1;
            if(this.longitude < p.longitude) return -1;
            return 0;
         case 't':      //sorting by time
            return this.time_stamp_system.compareTo(p.time_stamp_system);
         case 'm':       //Sort by MMSI
            return this.MMSI.compareTo(p.MMSI);
         default:       //sort by COG for debugging purposes
            return this.COG.compareTo(p.COG);
      }
   }

   public static void changeComp (char flag)
   {
      Pos.compFlag = flag;
   }

   public double getLatitude()
   {
      return this.latitude;
   }

   public double getLongitude()
   {
      return this.longitude;
   }

   public String getTime()
   {
      return this.time_stamp_system;
   }

   public String getMMSI()
   {
      return this.MMSI;
   }

   public String toString()
   {
      return "\nidmessage: " + idmessage + "\nidsession: " + idsession + "\ntime stamp system: " + time_stamp_system + "\nNMEA string: " + NMEA_string + "\nprocessed: " + processed + "\nMMSI: " + MMSI
         + "\nnavigation status: " + navigation_status + "\nROT: " + ROT + "\nSOG: " + SOG + "\nposition accuracy: " + position_accuracy + "\nlongitude: " + longitude + "\nlatitude: " + latitude + "\nCOG: " + COG
         + "\ntrueheading: " + trueheading + "\nmaneuver indicator: " + maneuver_indicator + "\nRAIM flag: " + RAIM_flag + "\ndiagnostic information: " + diagnostic_information + "\ntime stamp seconds only: " + time_stamp_seconds_only + "\n";
   }
}

