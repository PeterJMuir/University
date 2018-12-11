import validate.*;

import java.sql.*;
import java.util.*;

public class MusicAlbumDSC
{
    static final String COLUMN_ID = "id";
    static final String COLUMN_NAME = "name";
    static final String COLUMN_GENRE = "genre";
    static final String COLUMN_COMPILATION = "compilation";
    static final String COLUMN_TRACKC = "track_count";

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public void connect() throws SQLException
    {
        // replace database-name by your latcs7 database name
        String url = "jdbc:mysql://latcs7.cs.latrobe.edu.au:3306/database-name";
        url = "jdbc:mysql://localhost:3306/musicDB";

        // replace username by your latcs7 username
        String username = "username";
        username = "";

        // replace password by your latcs7 password
        String password = "password";
        password = "";

        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();
    }

    public void disconnect() throws SQLException
    {
        if (preparedStatement != null) preparedStatement.close();
        if (statement != null) statement.close();
        if (connection != null) connection.close();
    }

    /**
     * Retrieve a MusicAlbum by id
     * @param id
     * @return the MusicAlbum stored in the database, or null if the MusicAlbum
     * does not exist
     * @throws SQLException
     */
    public MusicAlbum get(String id) throws SQLException
    {
        connect();

        String queryString = "select * from music_album where id = ?";
        preparedStatement = connection.prepareStatement(queryString);
        preparedStatement.setString(1, id);
        ResultSet rs = preparedStatement.executeQuery();

        MusicAlbum musicAlbum = null;

        if (rs.next())
        {	// MusicAlbum exists in database
            musicAlbum = new MusicAlbum(
                rs.getString(COLUMN_ID),
                rs.getString(COLUMN_NAME),
                rs.getString(COLUMN_GENRE),
                rs.getBoolean(COLUMN_COMPILATION),
                rs.getInt(COLUMN_TRACKC));
        }

        disconnect();

        return musicAlbum;
    }

    /**
     * @return a list of all MusicAlbum records in database
     * @throws SQLException
     */
    public List<MusicAlbum> getAll() throws SQLException {
        connect();

        String queryString = "select * from music_album";
        preparedStatement = connection.prepareStatement(queryString);
        ResultSet rs = preparedStatement.executeQuery();

        List<MusicAlbum> musicAlbumList = new ArrayList<MusicAlbum>();
        MusicAlbum tmp;

        while (rs.next()) {
            tmp = new MusicAlbum(
                    rs.getString(COLUMN_ID),
                    rs.getString(COLUMN_NAME),
                    rs.getString(COLUMN_GENRE),
                    rs.getBoolean(COLUMN_COMPILATION),
                    rs.getInt(COLUMN_TRACKC));

            musicAlbumList.add(tmp);
        }

        disconnect();

        return musicAlbumList;
    }

    // todo in lab

    /**
     * @return a record count of all existing MusicAlbum records in database
     * @throws SQLException
     */
    public int count() throws SQLException
    {
        connect();

        String queryString = "select count(*) from music_album";
        ResultSet rs = statement.executeQuery(queryString);
        rs.next();
        int count = rs.getInt(1);

		  disconnect();
        return count;
    }

	 /**
	 	* To DO: Add an album record to the database
	 	* param 	musicAlbum - A MusicAlbum object that contains details for the record
	 	* 			to be added to the database
	 	* Throws Exception
	 	*/
    public void add(MusicAlbum musicAlbum) throws Exception
    {
		  Validator.validate(musicAlbum);

        // pre-condition:
        // id should NOT EXIST in database in order to add musicAlbum to database
        MusicAlbum tmp = get(musicAlbum.getId());

        boolean pre = (tmp == null);

        // if musicAlbum exists in database, throw exception
        if (!pre)
        {
            String msg = "MusicAlbum id " + musicAlbum.getId() + " is not new!";
            System.out.println("\nERROR: " + msg);
            throw new Exception(msg);
            // note: throwing exception terminates this method here, and
            // returning to the calling method.
        }

        // post-condition; given all pre-conditions are satisfied
        connect();

        String insertString = "insert into music_album values(?, ?, ?, ?, ?)";
        preparedStatement = connection.prepareStatement(insertString);
        preparedStatement.setString(1, musicAlbum.getId());
        preparedStatement.setString(2, musicAlbum.getName());
        preparedStatement.setString(3, musicAlbum.getGenre());
        preparedStatement.setBoolean(4, musicAlbum.isCompilation());
        preparedStatement.setInt(5, musicAlbum.getTrackCount());
        preparedStatement.executeUpdate();

        disconnect();
    }

 	 /**
 	 	* To DO: Update an album record in the database
 	 	* param 	musicAlbum - A MusicAlbum object that contains details for the record
 	 	* 			to be updated
 	 	* Throws Exception
	 	*/
    public void update(MusicAlbum musicAlbum) throws Exception
    {
        	Validator.validate(musicAlbum);

        	// pre-condition: id should EXIST in database
		 	MusicAlbum tmp = get(musicAlbum.getId());

		 	boolean pre = (tmp != null);
		 	if (!pre)
		 	{
				 String msg = "MusicAlbum id " + musicAlbum.getId() + " does not exist!";
				 System.out.println("\nERROR: " + msg);
				 throw new Exception(msg);
			}

		 	// post-condition; given all pre-conditions are satisfied
		 	connect();

		 	String updateString = "update music_album set "
		 			+ 	" name = ?"
		 			+	", genre = ?"
		 			+	", compilation = ?"
		 			+ 	", track_count = ?"
		 			+ 	" where id = ?";

		 preparedStatement = connection.prepareStatement(updateString);

		 preparedStatement.setString(1, musicAlbum.getName());
		 preparedStatement.setString(2, musicAlbum.getGenre());
		 preparedStatement.setBoolean(3, musicAlbum.isCompilation());
		 preparedStatement.setInt(4, musicAlbum.getTrackCount());
		 preparedStatement.setString(5, musicAlbum.getId());

		 preparedStatement.executeUpdate();

		 disconnect();
    }

 	 /**
 	 	* TO DO: Delete an album record from the database
 	 	* param 	id - The id of the record to be deleted
 	 	* Return	The MusicAlbum object representing the deleted record
 	 	* Throws Exception
	 	*/
    public MusicAlbum delete(String id) throws Exception
    {
        // pre-condition: id should EXIST in database
        MusicAlbum album = get(id);
        boolean pre = (album != null);
        if (!pre)
        {
            String msg = "MusicAlbum id " + id + " does not exist!";
            System.out.println("\nERROR: " + msg);
            throw new Exception(msg);
        }

        // post-condition; given all pre-conditions are satisfied
        connect();

        String deleteString = "delete from music_album where id = ? ";

        preparedStatement = connection.prepareStatement(deleteString);
        preparedStatement.setString(1, id);
        preparedStatement.executeUpdate();

        disconnect();

        return album;
        // client of DSC may want to know the deleted object
    }


    // todo in lab
    public List<MusicAlbum> getByGenre(String genre) throws SQLException
    {
		 // [1] connect to database
		 // [2] define queryString
		 // [3] initialise preparedStatement
		 // [4] give preparedStatement the genre value
		 // [5] initialise resultSet with the preparedStatement executeQuery

		 List<MusicAlbum> genreList = new ArrayList<MusicAlbum>();

		 // [6] loop through resultSet, for each iteration
		 // [7] create a MusicAlbum instance from the iterated resultSet
		 // [8] add new MusicAlbum to MusicAlbums arrayList
		 // [9] disconnect from database


       // consider using the SQL LIKE clause, and MySQL string operators
       // such as lower() or upper()

       return genreList;
    }
}
