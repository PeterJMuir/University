// Some quick tests
//
public class CatalogWSClientTester
{
	public static void main(String[] args) throws Exception
  	{
		CatalogWSClient catalogWSClient = new CatalogWSClient();

		// Test 1
		catalogWSClient.add("p100", "Lights", 100, false);


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
