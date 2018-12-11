import java.util.ArrayList;
public class MMSelectionSortV3
{
   public static void stringMMSelectionSort(ArrayList<String> a)
   {
      mmSelectionSort(a);
   }


	public static <T extends Comparable<T>> void mmSelectionSort(ArrayList<T> a)
	// Require: 	a.length >= 1
	{
		// let FIRST and LAST denote the firt and last valid indexes
		final int FIRST = 0;
		final int END = a.size() -1;

		for(int left = 0; left <= END/2; left++)
		{
			final int right = END-left;

			int minIndex = left;
			int maxIndex = left;

			for(int i = left + 1; i <= right; i++)
			{
				if(a.get(i).compareTo(a.get(minIndex)) < 0)
				{
					minIndex = i;
				}
				if(a.get(i).compareTo(a.get(maxIndex)) > 0)
				{
					maxIndex = i;
				}
			}

			System.out.println("\nleft: " + left + ", right: " + right +
				", minIndex: " + minIndex + ", maxIndex: " + maxIndex);

			if(left == maxIndex && right == minIndex)
			{
				swap(a, left, right);		// one swap only
			}
			else if(left == maxIndex)
			{
				swap(a, right, maxIndex); 	// must take care of max first
													// a[max] goes to right
													// previous a[right] goes to left
				swap(a, left, minIndex);	// now swap min and left
													// so a[min] goes to left
			}
			else if(right == minIndex)
			{
				swap(a, left, minIndex);	// Take care of min first
				swap(a, right, maxIndex);
			}
			else
			{
				swap(a, left, minIndex);	// Order does not matter
				swap(a, right, maxIndex);
			}
		}
	}

	public static <T> void swap(ArrayList<T> a , int i, int j)
	{
		System.out.println("swap i: " + i +", j: " + j +
			", a[i]: " + a.get(i) + ", a[j]: " + a.get(j));

		T temp = a.get(i);
		a.set(i,a.get(j));
		a.set(j,temp);
	}

	public static void main(String [] args)
	{
		// We put each test in a block so that we can declare ad initialize
		// the array a
      ArrayList<String> a = new ArrayList<String>();
      a.add("Hell");
      a.add("O");
      a.add("Worl");
      a.add("D");
      test(a);

      ArrayList<Person> p = new ArrayList<Person>();	
      p.add(new Person("Paul",32));
      p.add(new Person("Alex",12));
      p.add(new Person("Brian",54));
      test(p);
	}

	public static <T extends Comparable<T>> void test(ArrayList<T> a)
	{
		System.out.println("==============================");
		print(a);
		mmSelectionSort(a);
		print(a);
	}

	public static <T> void print(ArrayList<T> a)
	{
		System.out.println();
		for(int i = 0; i < a.size(); i++)
		{
			System.out.println(i + ": " + a.get(i));
		}
	}

	public static void print(String s)
	{
		System.out.println(s);
	}
}
