public class MMSelectionSortV1
{
	public static void mmSelectionSort(int [] a)
	// Require: 	a.length >= 1
	{
		// let FIRST and LAST denote the firt and last valid indexes
		final int FIRST = 0;
		final int END = a.length -1;

		for(int left = 0; left <= END/2; left++)
		{
			final int right = END-left;

			int minIndex = left;
			int maxIndex = left;

			for(int i = left + 1; i <= right; i++)
			{
				if(a[i] < a[minIndex])
				{
					minIndex = i;
				}
				if(a[i] > a[maxIndex])
				{
					maxIndex = i;
				}
			}

			System.out.println("\nleft: " + left + ", right: " + right +
				", minIndex: " + minIndex + ", maxIndex: " + maxIndex);

			swap(a, left, minIndex);
			swap(a, right, maxIndex);
		}
	}

	public static void swap(int a [], int i, int j)
	{
		System.out.println("swap i: " + i +", j: " + j +
			", a[i]: " + a[i] + ", a[j]: " + a[j]);

		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String [] args)
	{
		// We put each test in a block so that we can declare ad initialize
		// the array a

		{
			// test 1 - random with 6 numbers
			int [] a = {4, 2, 5, 1, 6, 3};
			test(a);
		}

		{
			// test 2 - random with 7 numbers
			int [] a = {4, 2, 5, 1, 2, 6, 4, 3};
			test(a);
		}

		{
			// test 3 - numbers are sorted
			int [] a = {1, 2, 3, 4, 5, 6};
			test(a);
		}

		{
			// test 4 - number are sorted in descending order
			int [] a = {6, 5, 4, 3, 2, 1};
			test(a);
		}

		{
			// test 5 - from http://stackoverflow.com/questions/10190132/selection-sort-growing-ordered-ranges-from-both-ends

			// int [] a = {9, 37, 12, 1, 13, 31, 5, 37, 36, 29, 19, 22, 20, 15, -1, 23};
			// test(a);
		}

		{
			// test 6 - from the same web address
			// int [] a = {25, 38, 19, 38, 36, 3, -2, 27, 7, 29, 41, 3, -2, 14, -2, 23};
			// test(a);
		}

		{
			// test 7 - from the same web address
			// int [] a = {41, 34, 29, 0, 27, 21, 35, 29, 9, 30, 37, 38, 34, 4, 38};
			// test(a);
		}
	}

	public static void test(int[] a)
	{
		System.out.println("==============================");
		print(a);
		mmSelectionSort(a);
		print(a);
	}

	public static void print(int[] a)
	{
		System.out.println();
		for(int i = 0; i < a.length; i++)
		{
			System.out.println(i + ": " + a[i]);
		}
	}

	public static void print(String s)
	{
		System.out.println(s);
	}
}