import java.util.List;

public class Main
{

    public static void main(String[] args) throws Exception
    {
        System.out.println("Interact with Database Lab!");

		System.out.println("Test 1 ------------------------");
         test1();	// test get() 		- which retrieves an album

		System.out.println("Test 2 ------------------------");
         test2();	// test getAll() 	- which retrives albums

		System.out.println("Test 3 ------------------------");
         test3();	// test count()	- which counts number of albums

		System.out.println("Test 4 ------------------------");
         test4();	// test add() 		- which adds an album to database

		System.out.println("Test 5 ------------------------");
         test5();	// test update()	- which updates a record

		System.out.println("Test 6 ------------------------");
        test6();	// test remove()

		//... continue with your own test cases 
    }

    // test get()
	 public static void test1() throws Exception
	 {
		 MusicAlbumDSC dsc = new MusicAlbumDSC();

		 try
		 {
			 System.out.println(dsc.get("A20"));
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	 }


    // test getAll()
	 public static void test2() throws Exception
	 {
		 MusicAlbumDSC dsc = new MusicAlbumDSC();

		 try
		 {
			 System.out.println(dsc.getAll());
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	 }

   // test count()
	 public static void test3() throws Exception
	 {
		 MusicAlbumDSC dsc = new MusicAlbumDSC();

		 try
		 {
			 System.out.println(dsc.count());
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	 }

    // test add()
    public static void test4() throws Exception
    {
		 MusicAlbumDSC dsc = new MusicAlbumDSC();

		 String id = "A100";
		 String name = "Beyond Blue";
		 String genre = "Mixed";
		 boolean isCompilation = true;
		 int trackCount = 15;
		 MusicAlbum album = new MusicAlbum(id, name, genre, isCompilation, trackCount);

		 try
		 {
			 dsc.add(album);
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 System.out.println(dsc.getAll());	// this method can throw SQLException
		 }
	 }

   // test upadte()
    public static void test5() throws Exception
    {
		 MusicAlbumDSC dsc = new MusicAlbumDSC();
		 dsc.add(new MusicAlbum("A200", "name", "genre", false, 10));
		 System.out.println(dsc.get("A200"));

		 // A MusicAlbum that contains changed details
		 //
		 MusicAlbum album = new MusicAlbum("A200", "New Album", "Classic", true, 100);

		 try
		 {
			 dsc.update(album);
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 System.out.println(dsc.get("A200"));
		 }
	 }

   // test remove()
    public static void test6() throws Exception
    {
		 MusicAlbumDSC dsc = new MusicAlbumDSC();
		 dsc.add(new MusicAlbum("A300", "name", "genre", false, 10));
		 System.out.println(dsc.get("A300"));

		 try
		 {
			 dsc.remove("A300");
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 System.out.println(dsc.getAll());
		 }
	 }
}
