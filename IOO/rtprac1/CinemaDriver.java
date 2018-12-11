/*
 * Class Name:    CinemaDriver
 *
 * Author:        Your Name
 * Creation Date: Tuesday, May 30 2017, 14:55 
 * Last Modified: Tuesday, May 30 2017, 15:35
 * 
 * Class Description:
 *
 */
import java.util.*;
import java.io.File;
public class CinemaDriver
{
   private static ArrayList<Film> showing = new ArrayList<Film>();
   public static void main(String[] args)
   {
      readInFile();
      displayFilms();
      int ETindex =-1;
      for(int i = 0; i < showing.size(); ++i)
      {
         if("ET".equals(showing.get(i).getTitle()))
         {
            ETindex = i;
         }
      }
      if(-1 == ETindex)
      {
         System.out.println("There is no ET Movie");
      }else
      {
         showing.get(ETindex).setScreenings(246000);
      }
      displayFilms();
      showing.add(0,new Film("Rear Window","Mystery",100,12000));//index 0 is front of array
      showing.remove(3);//removes fourth film
      displayFilms();
      double maxAvg = -1;
      int maxIndex = -1;
      for(int i = 0; i < showing.size(); ++i)
      {
         double tempAvg = showing.get(i).calcAverage();
         System.out.print(showing.get(i).getTitle() + "'s Average attndance per screening ");
         if(-1 == tempAvg)
         {
            System.out.println("cannot be determined");
         }else
         {
            if(tempAvg > maxAvg)
            {
               maxAvg = tempAvg;
               maxIndex = i;
            }
            System.out.println("is: " + tempAvg);
         }
      }
      System.out.println("\nThe film with the highest average is:");
      System.out.println(showing.get(maxIndex).getTitle() + " with an average of " + maxAvg);
   }

   private static void displayFilms()
   {
      for(int i = 0; i < showing.size(); ++i)
      {
         System.out.println(showing.get(i));
      }
      System.out.println();
   }

   private static void readInFile()
   {
      try{
      Scanner r = new Scanner(new File("Movies.dat"));
      int numRecords = r.nextInt();
      r.nextLine();//discard new line
      int tempAttend;
      int tempScreenings;
      String tempGenre;
      String tempTitle;
      for(int i = 0; i < numRecords; ++i)
      {
         tempTitle = r.nextLine();
         tempGenre = r.nextLine();
         tempScreenings = r.nextInt();
         r.nextLine();//discard new line
         tempAttend = r.nextInt();
         r.nextLine();//discard new line
         r.nextLine();//discard '.'
         showing.add(new Film(tempTitle,tempGenre,tempScreenings,tempAttend));
      }
      r.close();
      }catch(Exception e)
      {
         System.out.println("Something went wrong with the file");
      }
   }
}
