public class Person implements Comparable<Person>
{
	private String name;
	private int age;

	public Person(String name, int age)
	{
		this.name = name;
		this.age = age;
	}

	public int compareTo(Person other)
	{
		return name.compareTo(other.name);
	}

	public String toString()
	{
		return getClass().getName()
			+ "[name: " + name
			+ ", age: " + age + "]";
	}
}


