/*
 * Class Name:    Film
 *
 * Author:        Your Name
 * Creation Date: Tuesday, May 30 2017, 14:46 
 * Last Modified: Tuesday, May 30 2017, 14:54
 * 
 * Class Description:
 *
 */

public class Film
{
   private final String title;
   private final String genre;
   private int screenings;
   private int attendance;

   public Film(String title, String genre, int screenings, int attendance)
   {
      this.title = title;
      this.genre = genre;
      this.screenings = screenings;
      this.attendance = attendance;
   }
   public String getTitle()
   {
      return title;
   }
   public String getGenre()
   {
      return genre;
   }
   public int getScreenings()
   {
      return screenings;
   }
   public int getAttendance()
   {
      return attendance;
   }
   public void setScreenings(int nScreen)
   {
      screenings = nScreen;
   }
   public void setAttendance(int nAttend)
   {
      attendance = nAttend;
   }
   public double calcAverage()
   {
      return ((-1 == screenings) || (-1 == attendance))?-1:(attendance/screenings);
   }
   public String toString()
   {
      return "title:" + title + "\\genre:" + genre + "\\screenings:" + screenings + "\\attendance:" + attendance;
   }
}

