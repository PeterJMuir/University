/*
 * Class Name:    Ship
 *
 * Author:        Peter Muir
 * Creation Date: Friday, February 03 2017, 17:29 
 * Last Modified: Monday, February 06 2017, 23:54
 * 
 * Class Description:
 * Ship class holds the Ship details. This class is used with the myShipFinder
 * program.
 *
 */

public class Ship implements Comparable<Ship>
{
   private String idmessage;
   private String idsession;
   private String time_stamp_system;
   private String NMEA_string;
   private String processed;
   private String MMSI;
   private String AIS_version;
   private String IMO_number;
   private String callSign;
   private String name;
   private String type_of_ship_and_cargo;
   private String bow_to_possition_unit;
   private String stern_to_possition_unit;
   private String port_to_possition_unit;
   private String starboard_to_possitio_unit;
   private String type_of_position_fixing_divice;
   private String ETA;
   private String destination;
   private String last_static_draught;
   private String DTE;

   private static boolean compFlag = false;  //A static flag to determine which attribute is used in the compareTo() method

   public Ship ( String idmessage, String idsession, String time_stamp_system, String NMEA_string, String processed, String MMSI, String AIS_version, String IMO_number, String callSign, String name, String type_of_ship_and_cargo, String bow_to_possition_unit, String stern_to_possition_unit, String port_to_possition_unit, String starboard_to_possitio_unit, String type_of_position_fixing_divice, String ETA, String destination, String last_static_draught, String DTE)
   {
   this.idmessage = idmessage;
   this.idsession = idsession;
   this.time_stamp_system = time_stamp_system;
   this.NMEA_string = NMEA_string;
   this.processed = processed;
   this.MMSI = MMSI;
   this.AIS_version = AIS_version;
   this.IMO_number = IMO_number;
   this.callSign = callSign;
   this.name = name;
   this.type_of_ship_and_cargo = type_of_ship_and_cargo;
   this.bow_to_possition_unit = bow_to_possition_unit;
   this.stern_to_possition_unit = stern_to_possition_unit;
   this.port_to_possition_unit = port_to_possition_unit;
   this.starboard_to_possitio_unit = starboard_to_possitio_unit;
   this.type_of_position_fixing_divice = type_of_position_fixing_divice;
   this.ETA = ETA;
   this.destination = destination;
   this.last_static_draught = last_static_draught;
   this.DTE = DTE;

   }

   public int compareTo(Ship s)
   {
      if(Ship.compFlag)
      {
         return this.name.compareTo(s.name);
      }else
      {
         return this.MMSI.compareTo(s.MMSI);
      }
   }

   public static void changeComp(boolean flag)
   {
      Ship.compFlag = flag;
   }

   public String getName()
   {
      return this.name;
   }

   public String getMMSI()
   {
      return this.MMSI;
   }

   public String toString()
   {
      return "\nidmessage: " + idmessage + "\nidsession: " + idsession + "\ntime stamp system: " + time_stamp_system + "\nNMEA string: " + NMEA_string + "\nprocessed: " + processed + "\nMMSI: " + MMSI + "\nAIS version: " + AIS_version + "\nIMO number: " + IMO_number + "\ncall sign: " + callSign + "\nname: " + name + "\ntype of ship and cargo: " + type_of_ship_and_cargo + "\nbow to possition unit: " + bow_to_possition_unit + "\nstern to possition unit: " + stern_to_possition_unit + "\nport to possition unit: " + port_to_possition_unit + "\nstarboard to possitio unit: " + starboard_to_possitio_unit + "\ntype of position fixing divice: " + type_of_position_fixing_divice + "\nETA: " + ETA + "\ndestination: " + destination + "\nlast static draught: " + last_static_draught + "\nDTE: " + DTE + "\n";
   }

}

