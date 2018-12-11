import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Catalog
{
	public final String DATA_FILE_NAME = "CatalogData.txt";

	private ArrayList<Product>  products;

	public Catalog()
	{
		products = new ArrayList<Product>();
	}

	public void addProduct(String id, String name, double price, boolean onSale) throws Exception
	{
		Product p = searchProduct(id);
		boolean pre = (p == null);
		if( !pre)
		{
			String msg = "Product ID is not new!";
			System.out.println(">>> ERROR: " + msg);
			throw new Exception(msg);
		}

		p = new Product(id, name, price, onSale);
		products.add(p);
	}

	public Product searchProduct(String id)
	{
		for(Product p: products)
		{
			if(p.getId().equalsIgnoreCase(id))
			{
				return p;
			}
		}
		return null;
	}

	public ArrayList<Product> getProductsInPriceRange(double lower, double upper)
	{
		ArrayList<Product> list = new ArrayList<Product>();

		for(Product p: products)
		{
			if(lower <= p.getPrice() && p.getPrice() <= upper)
			{
				list.add(p);
			}
		}
		return list;
	}

	public void updateProductPrice(String id, double price) throws Exception
	{
		Product p = searchProduct(id);
		boolean pre = (p != null);
		if(!pre)
		{
			String msg= ">>>ERROR: Product does not exist!";
			System.out.println(msg);
			throw new Exception(msg);
		}

		p.setPrice(price);
	}

	public void updateProductOnSale(String id, boolean onSaleStatus) throws Exception
	{
		Product p = searchProduct(id);
		boolean pre = (p != null);
		if(!pre)
		{
			String msg= ">>>ERROR: Product does not exist!";
			System.out.println(msg);
			throw new Exception(msg);
		}

		p.setOnSale(onSaleStatus);
	}

	public void removeProduct(String id) throws Exception
	{
		Product p = searchProduct(id);
		boolean pre = (p != null);
		if(! pre)
		{
			String msg= ">>>ERROR: Product does not exist!";
			System.out.println(msg);
			throw new Exception(msg);
		}
		products.remove(p);
	}

	public String toString()
	{
		String result = new String();
		for(Product p: products)
		{
			result = result + "\n" + p.toString();
		}
		return result;
	}

	public void loadData() throws Exception
	{
		products = new ArrayList<Product>();
		Scanner in = new Scanner(new File(DATA_FILE_NAME));

		while(in.hasNext()) // can cope with trailing blank lines
		{
			String line = in.nextLine();
			String[] tokens = line.split(";");
			String id = tokens[0];
			String name = tokens[1];
			double price = Double.parseDouble(tokens[2]);
			boolean onSale = Boolean.parseBoolean(tokens[3]);

			Product p = new Product(id, name, price, onSale);
			products.add(p);
		}

		in.close();
	}


	public void saveData() throws Exception
	{
		PrintWriter out = new PrintWriter(new File(DATA_FILE_NAME));
		for(Product p: products)
		{
			out.println(p.getId() + ";" + p.getName() + ";"
				+ p.getPrice() + ";" +  p.isOnSale());
		}
		out.close();
	}


	/*
	public ArrayList<Product> getAllProducts()
	{
		ArrayList<Product> list = new ArrayList<Product>();
		for(Product p: products)
		{
			list.add(p);
		}

		return list;
	}
	*/


	// To perform some quick tests
	public static void main(String [] args) throws Exception
	{
		Catalog catalog = new Catalog();

		// add products
		catalog.addProduct("P10", "Chair", 10.50, true);
		catalog.addProduct("P20", "Table", 20.50, false);
		catalog.addProduct("P30", "Desk",  30.50, false);
		System.out.println(catalog + "\n");

		// Search
		Product p = catalog.searchProduct("P10");
		System.out.println(p + "\n");

		// Display products in a price range
		ArrayList<Product>  list = catalog.getProductsInPriceRange(0, 35);
		System.out.println(list+ "\n");

		// Change product price
		catalog.updateProductPrice("P30", 35.99);
		System.out.println(catalog + "\n");

		// Change product on sale status
		catalog.updateProductOnSale("P30", true);
		System.out.println(catalog + "\n");

		// Load data
		catalog.loadData();
		System.out.println(catalog + "\n");
		catalog.addProduct("P70", "Computer",  70.00, true);
		System.out.println(catalog + "\n");
		catalog.saveData();

		// Restore data file to original state (for repeated testing)
		catalog.removeProduct("P70");
		System.out.println(catalog + "\n");
		catalog.saveData();
	}
}

/*
A text-based menu may have options to

1.	Load catalog data
2.	Add product
3.	Update a product's price
4.	Search for a product
5.	Search by price range
6.	Remove a product
7.	Save data
*/