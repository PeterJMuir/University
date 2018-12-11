import validate.*;

import java.util.List;

public class MusicAlbumDSCTester
{
	private static MusicAlbumDSC dsc  = new MusicAlbumDSC();

	public static void main(String[] args) throws Exception
   {
		try{test1(); System.out.println("successful");}
		catch(Exception e){System.out.println(e);}

		try{test2(); System.out.println("successful");}
		catch(Exception e){System.out.println(e);}

		try{test3(); System.out.println("successful");}
		catch(Exception e){System.out.println(e);}

		try{test4(); System.out.println("successful");}
		catch(Exception e){System.out.println(e);}

		try{test5(); System.out.println("successful");}
		catch(Exception e){System.out.println(e);}

		try{test6();System.out.println("successful");}
		catch(Exception e){System.out.println(e);}

		try{test7();System.out.println("successful");}
		catch(Exception e){System.out.println(e);}
	}

	// Intended usage:
	// Run this test1 after initializing the database
	// => It should be successful
	private static void test1() throws Exception
	{
		dsc.add(new MusicAlbum("a100", "new name", " new genre", true, 10));
     	System.out.println(dsc.getAll());
	}

	// Run this test2 after running test1
	// => It should throw an exception due to duplicate id
 	private static void test2() throws Exception
  	{
		dsc.add(new MusicAlbum("a100", "new name", "new genre", true, 10));
    	System.out.println(dsc.getAll());
	}

	// Run this test3 after running test1
	// => It should be successful
	// Note that every field except id has been changed
 	private static void test3() throws Exception
  	{
		dsc.update(new MusicAlbum("a100", "whatever", "whatever", false, 20));
    	System.out.println(dsc.get("a100"));
	}

 	// Run this test4 after running test1 or test4
 	// => It should throw an exception due to number of tracks are too high
  	private static void test4() throws Exception
   {
 		dsc.update(new MusicAlbum("a100", "whatever", "whatever", false, 100));
     	System.out.println(dsc.get("a100"));
	}

 	// Run this test5 after running test1 or test4
 	// => It should throw an exception due to id does not exist
  	private static void test5() throws Exception
   {
 		dsc.update(new MusicAlbum("z100", "whatever", "whatever", false, 20));
     	System.out.println(dsc.get("a100"));
	}

 	private static void test6() throws Exception
   {
  		dsc.update(new MusicAlbum("z100", "whatever", "whatever", false, 20));
  		System.out.println(dsc.get("z100"));
	}

 	private static void test7() throws Exception
   {
  		MusicAlbum album = dsc.delete("a100");
  		System.out.println(album);
  		System.out.println(dsc.get("a100"));	// should be null
	}
}
