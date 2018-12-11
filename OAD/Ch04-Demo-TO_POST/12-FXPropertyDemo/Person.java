//	Simple demonstration of a class with a JavaFX Property

import javafx.beans.property.*;

public class Person
{
	private StringProperty name;

	public Person(String nameValue)
	{
		name = new SimpleStringProperty(nameValue);
	}

	// returns the property value
	public String getName()
	{
		return name.get();
	}

	// set the property with a property value
	public void setName(String nameValue)
	{
		name.set(nameValue);
	}

	// return the property itself
	public StringProperty nameProperty()
	{
		return name;
	}

	public static void main(String [] args)
	{
		Person person = new Person("Alice");
		System.out.println("\n" + person.getName());
		System.out.println("\n" + person.nameProperty());

		// Add a change listener
		person.nameProperty().addListener((obs, oldValue, newValue) ->
			{
				System.out.println("\nold: " + oldValue + ", new: " + newValue);
			});

		person.setName("Bob"); 	// listener will repsond to this change

		person.setName("Eve");	// change event occurs again

		person.setName("Eve");	// change event does not occur this time
	}
}