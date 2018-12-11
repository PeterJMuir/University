import validate.*;

import java.util.List;

public class MusicAlbumDSCTester
{
	private static MusicAlbumDSC musicAlbumDSC = new MusicAlbumDSC();

   public static void main(String[] args)
   {
        System.out.println("Validating POJO with Annotation and Reflection!");

        // List all the records for inspection
        howManyRecords();
		  list();

        // Add a music album - with validation
        // Then list the records for inspection
        create();
        list();

        // Add other tests as needed
    }

    private static void howManyRecords()
    {
        try
        {
            System.out.println("Music Album record count is " + musicAlbumDSC.count());
        }
        catch (Exception e) { e.printStackTrace(); }
    }

    private static void list()
    {
        try
        {
            List<MusicAlbum> albumList = musicAlbumDSC.getAll();
            System.out.println("------- ALL ALBUMS -------");
            for (MusicAlbum ma : albumList)
                System.out.println(ma);
        }
        catch (Exception e) { e.printStackTrace(); }
    } // list

    // sample solution
    private static void create()
    {
        MusicAlbum ma = new MusicAlbum();
        // ma.setId("a");
        ma.setId("a23456");

        ma.setName(null);
        // ma.setName("Arctic Monkeys - AM");

        ma.setGenre("Brit Pop/Brit Rock");
        ma.setCompilation(false);

        // ma.setTrackCount(0);
        ma.setTrackCount(51);
        // ma.setTrackCount(2);


        System.out.println("\n------- ADDING NEW ALBUM -------");
        try {
			Validator.validate(ma);

			// todo: user ValidatorUtil.validateModel(...) here to validate instance of MusicAlbum ma
			// ValidatorUtil.validateModel(...) will throw exception if validation
            musicAlbumDSC.add(ma);
            System.out.println("[ADDED] " + ma);
        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    } // create
}
