import java.util.*;
public class Sorter
{
	//	Method to gnome sort a completely filled array of Strings
	//
	public static void stringGnomeSort(String[] a)
	{
		int current = 1;		// current location
									// assume the array has at least 2 elements
		while(true)
		{
			if (current == a.length)
			{
				break;
			}
			else if(current == 0)
			{
				current++;
			}
			else if(a[current - 1].compareTo(a[current]) > 0)
			{
				//swap a[current-1] and a[current]
				String temp = a[current - 1];
				a[current - 1] = a[current];
				a[current] = temp;

				current--;
			}
			else
			{
				current++;
			}
		}
	}

	//	Method to sort an ArrayList of Strings
	//
	public static void stringGnomeSort(ArrayList<String> list)
	{
		gnomeSort(list);
	}

	// generic method to sort an ArrayList
	//
	public static <E extends Comparable<E>> void gnomeSort(ArrayList<E> list)
	{
		int current = 1;		// current location
									// assume the array has at least 2 elements
		while(true)
		{
			if (current == list.size())
			{
				break;
			}
			else if(current == 0)
			{
				current++;
			}
			else if(list.get(current - 1).compareTo(list.get(current)) > 0)
			{
				//swap a[current-1] and a[current]
				E temp = list.get(current - 1);
				list.set(current - 1,list.get(current));
				list.set(current,temp);

				current--;
			}
			else
			{
				current++;
			}
		}
	}
}