//	A client of the Catalog web services

import com.google.gson.Gson;		// Need gson2.2.4.jar
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class CatalogWSClient
{
	// The base URL for accessing the web services
	// This is in fact the URL of the servlet, which provides the web services
	private static final String BASE_URL =
		"http://localhost:8080/catalogws/api/product";


   // Constant for valid content types for these web services
	public static final String JSON_CONTENT_TYPE = "application/json";
	public static final String JSON_UTF_8_CONTENT_TYPE
								= JSON_CONTENT_TYPE + "; charset=utf-8";



	// REQUEST to add a product
 	public void add(String id, String name, double price, boolean onSale)
 	throws Exception
	{
    	//	Construct the Product object and convert it to a JSON string
	  	Product product = new Product(id, name, price, onSale);
  		String sentData = Helper.getJSON(product);

    	//	make the REST request
    	HttpURLConnection connection = makeRESTRequest(BASE_URL, "POST", sentData);

 		// process response code
 		processResponseCode(connection);

 		// IF reach this pint, request is successful

 		// extract received data in JSON
 		String receivedData = getReceivedData(connection);

		// display as JSON string an as Product object
		System.out.println("received data as JSON string: " + receivedData);
		Product receivedProduct = Helper.getObject(receivedData, Product.class);
		System.out.println("received product: " + receivedProduct);
	}


	// Helper method to make a REST request
	private HttpURLConnection makeRESTRequest(String resourceUrl, String method,
		String data) throws Exception
  	{
		URL url = new URL(resourceUrl);
 		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

    	connection.setDoOutput(true);
     	connection.setDoInput(true);
   	connection.setRequestProperty("Content-Type", JSON_UTF_8_CONTENT_TYPE);
    	connection.setRequestProperty("Accept", JSON_CONTENT_TYPE);
    	connection.setRequestMethod(method.toUpperCase());


    	// Sent data with the request if request method is POST or PUT
    	if(method.toUpperCase().equals("POST")
    		|| method.toUpperCase().equals("PUT"))
    	{
    		PrintWriter out = new PrintWriter(connection.getOutputStream());
    		out.print(data);
    		out.flush();
		}

      return connection;
	}

  	// Helper method to act on the repsonse code
	private void processResponseCode(HttpURLConnection connection) throws Exception
	{
	  	int responseCode = connection.getResponseCode();
		if (responseCode != HttpURLConnection.HTTP_OK)	// error code returned
		{
			String errMsg = connection.getResponseCode() + ": "
				+ connection.getResponseMessage();

			System.out.println(">>> error code and message: " + errMsg);
			throw new Exception(errMsg);
		}
	}

	//	Helper method to  get received data
	private String getReceivedData(HttpURLConnection connection) throws Exception
	{
		BufferedReader br = new BufferedReader(
				new InputStreamReader(connection.getInputStream(), "utf-8"));

		StringBuilder sb = new StringBuilder();
		String line = null;
		while ((line = br.readLine()) != null)
		{
			 sb.append(line + "\n");
		}
		br.close();

		return sb.toString();
	}

	// REQUEST to edit a product
	//
	public void edit(String id, String name, double price, boolean onSale)
	throws Exception
	{
		//	Construct the Product object and convert it to a JSON string
		Product product = new Product(id, name, price, onSale);
		String data = Helper.getJSON(product);

		//	Make the request (to update price and sale status)
		HttpURLConnection connection = makeRESTRequest(
			BASE_URL + "?id=" + id, "PUT", data);

		//	Throw exception if receive error code
		processResponseCode(connection);

		// Get received data and display it as JSON string and Product object
		String receivedData = getReceivedData(connection);

		Product receivedProduct = Helper.getObject(receivedData, Product.class);
		System.out.println("received JSon string: " + receivedData);
		System.out.println("received product: " + receivedProduct);

	} // edit a product

	// REQUEST: Delete a product
	//
 	public void delete(String id) throws Exception
	{
		HttpURLConnection connection =
		 	makeRESTRequest(BASE_URL + "?id=" + id, "DELETE", null);

		processResponseCode(connection);
    }

	// REQUEST to get all the products
	//
	public String getAll() throws Exception
  	{
    	HttpURLConnection connection = makeRESTRequest(BASE_URL, "GET", null);

		processResponseCode(connection);

		//	get received JSON string
		String receivedData = getReceivedData(connection);

     	// Convert JSON string into a list of Products, and display them
    	List<Product> products = Helper.getObjectList(receivedData, Product.class);

		System.out.println("Received product list as JSON:\n" + receivedData);
		System.out.println("Received product list:\n" + products);

		return receivedData;
    }


	//	REQUEST to get a product
	//
	public String get(String id) throws Exception
	{
		HttpURLConnection connection = makeRESTRequest(BASE_URL + "?id=" + id,
				"GET", null);

		processResponseCode(connection);

		String receivedData = getReceivedData(connection);
		Product receivedProduct = Helper.getObject(receivedData, Product.class);

		System.out.println("Received product as JSON:\n" + receivedData);
		System.out.println("Received product:\n" + receivedProduct);

		return receivedData;
   }


	// Some quick tests
	//
	public static void main(String[] args) throws Exception
  	{
		CatalogWSClient catalogWSClient = new CatalogWSClient();

		// Test 1
		//catalogWSClient.add("j30", "Table Decors", 100, false);

		// Test 2
		// catalogWSClient.edit("j30", "Table Decors", 50, true);
		// catalogWSClient.edit("j100", "Table Decors", 50, true);

		// Test 3
		// catalogWSClient.delete("j30");

		//	Test 4
		// String s = catalogWSClient.get("j20");
		// System.out.println("\n>>> product received in JSON:\n" + s);

		//	Test 5
		// String s = catalogWSClient.getAll();
		// System.out.println("\nProduct list as JSON:\n" + s);
    }
}

/*	NOTE ON ERROR MESSAGES:
Error message when add product with duplicated id is not informative:

	Exception in thread "main" java.lang.Exception: 500: Internal Server Error
		  at CatalogWSClient.add(CatalogWSClient.java:77)
	at CatalogWSClient.main(CatalogWSClient.java:218)
*/
