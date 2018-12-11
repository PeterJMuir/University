import java.util.*;

public class SorterTester
{
	public static void main(String [] args)
	{
		 //test1();
		 //test2();
		test3();
	}

	public static void test1()
	{
		String [] list = {"dog", "cat", "tiger", "bird"};
		for(String s: list)
		{
			System.out.println(s);
		}
		System.out.println();

		Sorter.stringGnomeSort(list);
		for(String s: list)
		{
			System.out.println(s);
		}
	}

	public static void test2()
	{
		ArrayList<String> list = new ArrayList<String>();
		list.add("dog");
		list.add("cat");
		list.add("tiger");
		list.add("bird");
		System.out.println(list);

		Sorter.stringGnomeSort(list);
		System.out.println(list);
	}

	public static void test3()
	{
		ArrayList<String> list = new ArrayList<String>();
		list.add("dog");
		list.add("cat");
		list.add("tiger");
		list.add("bird");
		System.out.println(list);

		Sorter.gnomeSort(list);
		System.out.println(list);
	}
}