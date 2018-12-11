// Laboratory 11
import java.util.*;
import java.io.Serializable;
public class Episode implements Serializable
{
   private String showName;
   private String episodeName;
   private int seasonNumber;
   private int episodeNumber;
   private int rating;

   public Episode(String show, String episode, 
                  int sNumber, int eNumber, int rating)
   {
      showName = show;
      episodeName = episode;
      seasonNumber = sNumber;
      episodeNumber = eNumber;
      this.rating = rating;
   }

   public String getShowName()
   {
      return showName;
   }

   public String getEpisodeName()
   {
      return episodeName;
   }

   public int getSeasonNumber()
   {
      return seasonNumber;
   }

   public int getEpisodeNumber()
   {
      return episodeNumber;
   }

   public int getRating()
   {
      return rating;
   }

   public String toString()
   {
      return showName + " " + seasonNumber + "-" + episodeNumber + ": " + 
             episodeName + " (" + rating + " viewers)";
   }

   public void setShowName(String name)
   {
      showName = name;
   }

   public void setEpisodeName(String episode)
   {
      episodeName = episode;
   }

   public void setSeasonNumber(int season)
   {
      seasonNumber = season;
   }

   public void setEpisodeNumber(int episode)
   {
      episodeNumber = episode;
   }

   public void setRating(int rating)
   {
      this.rating = rating;
   }
}
