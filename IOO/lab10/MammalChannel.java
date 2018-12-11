import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
public class MammalChannel
{
	
	public static void read(ArrayList<Episode> screenings, String fileName) throws Exception
	{
		File inFile = new File(fileName);
		Scanner r = new Scanner(inFile);
		while(r.hasNext())
		{
			String[] a = r.nextLine().split(": ");
			screenings.add(new Episode(a[0],a[1],Integer.parseInt(a[2].trim()),Integer.parseInt(a[3].trim()),Integer.parseInt(a[4].trim())));
		}
		r.close();
	}
	
	public static <T> void display(ArrayList<T> list)
	{
		for(int i = 0; i < list.size(); ++i)
		{
			System.out.println(list.get(i).toString());
		}
	}
	
	public static ArrayList<String> getShows(ArrayList<Episode> screenings)
	{
		ArrayList<String> shows = new ArrayList<String>();
		for(int i = 0; i < screenings.size(); ++i)
		{
			boolean ok_flag = true;
			for(int j = 0; j < shows.size();  ++j)
			{
				if(shows.get(j).equals(screenings.get(i).getShowName()))
				{
					ok_flag = false;
					break;
				}
			}
			if(ok_flag)
			{
				shows.add(screenings.get(i).getShowName());
			}
		}
		return shows;
	}
	
	public static Episode getMostWatched(ArrayList<Episode> screenings)
	{
		int index = 0;
		for(int i = 0; i < screenings.size(); ++i)
		{
			if(screenings.get(i).getRating() > screenings.get(index).getRating())
			{
				index = i;
			}
		}
		return screenings.get(index);
	}
	
	public static int getNumberOfEpisodes(ArrayList<Episode> screenings, String show)
	{
		int count = 0;
		for(int i = 0; i < screenings.size(); ++i)
		{
			if(screenings.get(i).getShowName().equals(show))
			{
				++count;
			}
		}
		return count;
	}
}