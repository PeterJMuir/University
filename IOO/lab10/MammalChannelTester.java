import java.util.*;
import java.io.*;
public class MammalChannelTester
{
   public static void main(String[] args) throws Exception
   {
      //	Question 1
      ArrayList<Episode> screenings = new ArrayList<Episode>();
      MammalChannel.read(screenings, "screenings.txt");
      System.out.println("\nQuestion 1");
      MammalChannel.display(screenings);

      //	Question 2a)
      ArrayList<String> shows = MammalChannel.getShows(screenings);
      System.out.println("\nQuestion 2a");
      MammalChannel.display(shows);

      //	Question 2b)
      Episode highestRating = MammalChannel.getMostWatched(screenings);
      System.out.println("\nQuestion 2b");
      System.out.println("Highest Rating Show: " + highestRating);
	  

      //	Question 2c)
      int numberOfEpisodes = MammalChannel.getNumberOfEpisodes(
			screenings, "Cats vs Dogs");
      System.out.println("\nQuestion 2c");
      System.out.println("Number of episodes of Cats vs Dogs: " +
                                                           numberOfEpisodes);
		/*

      //	Question 3
      MammalChannel.writeToBinFile(screenings, "episodes.bin");
      System.out.println("\nQuestion 3");
      ArrayList<Episode> screeningsFromFile =
                               MammalChannel.readFromBinFile("episodes.bin");
      MammalChannel.display(screeningsFromFile);*/
   }
}

