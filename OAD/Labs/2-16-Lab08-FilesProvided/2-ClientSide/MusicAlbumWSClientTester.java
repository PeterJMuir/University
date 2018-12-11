// Some quick tests
//
public class MusicAlbumWSClientTester
{
	public static void main(String[] args) throws Exception
  	{
		MusicAlbumWSClient client = new MusicAlbumWSClient();

		// Test 1
		// client.add("m10", "Album 1", "classic", false, 10);


		// Test 2
		// client.edit("m10", "Album 1", "classic revised", false, 15);
		// client.edit("m100", "Album 1", "classic revised", false, 15);



		// Test 3
		// client.delete("m10");


		//	Test 4
		// String s = client.getAll();
		// System.out.println("\n>>> album list received in JSON (displayed by tester):\n"
		//	+ s);


		//	Test 5
		String s = client.get("a10");
		System.out.println("\n>>> album received in JSON (displayed by tester):\n" + s);
    }
}
