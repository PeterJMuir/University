import java.io.PrintWriter;

public class ElectoralRoll 
{
	LinearHashing dataStructure;
	
	public ElectoralRoll()
	{
      dataStructure = new LinearHashing();
	}
	
	public boolean insert(String firstName, String lastName, String address, 
                         String suburb, String state, int postCode)
	{
		Person temp = new Person(firstName, lastName, address, 
                               suburb, state, postCode);
		return dataStructure.insertElement(temp);
	}
	
	public boolean removeElement(String firstName, String lastName, 
                                String address, String suburb, 
                                String state, int postCode)
	{
		return dataStructure.removeElement(new Person(firstName, lastName, 
                                         address, suburb, state, postCode));
	}
	
	public Person contains(String firstName, String lastName, int postCode)
	{
		return dataStructure.contains(new Person(firstName, lastName,
                                    "", "", "", postCode));
	}
	
	public void displayElements() throws Exception
	{
		PrintWriter z = new PrintWriter(System.out, true);
		dataStructure.displayElements(z);
	}
}
