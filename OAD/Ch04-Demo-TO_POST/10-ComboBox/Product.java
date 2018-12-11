public class Product
{
	private String id;
	private String name;
	private double price;

	public Product(String id, String name, double price)
	{
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public String toString()
	{
		return getClass().getName()
			+ "[id: " + id
			+ ", name: " + name
			+ ", price: " + price + "]";
	}
}

