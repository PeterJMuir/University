// import javafx.beans.property.*;

public class Product
{
	public final int MISSING_PRICE = -1;

	private String id;
	private String name;
	private double price;
	private boolean onSale;

	//private SimpleDoubleProperty priceProperty;
	//private SimpleBooleanProperty onSaleProperty;

	public Product(String id, String name, double price, boolean onSale)
	{
		this.id = id;
		this.name = name;
		this.price = price;
		this.onSale = onSale;
		//this.priceProperty = new SimpleDoubleProperty(price);
		//this.onSaleProperty = new SimpleBooleanProperty(onSale);
	}

	public void setPrice(double price)
	{
		this.price = price;
	}

	public void setOnSale(boolean value)
	{
		this.onSale = value;
	}

	public String getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public double getPrice()
	{
		return price;
	}

	public boolean isOnSale()
	{
		return onSale;
	}

	public String toString()
	{
		return "Product[id: " + id
			+ ", name: " + name
			+ ", price: " + price
			+ ", onSale: " + onSale
			//+ ", priceProperty: " + priceProperty
			+ "]";
	}


	// To perform some quick tests
	public static void main(String [] args)
	{
		Product p = new Product("P10", "Table", 10.00, true);
		System.out.println(p);
	}
}