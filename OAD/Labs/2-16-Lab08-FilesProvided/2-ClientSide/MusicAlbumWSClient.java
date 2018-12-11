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

public class MusicAlbumWSClient
{
	// The base URL for accessing the web services
	// This is in fact the URL of the servlet, which provides the web services
	private static final String BASE_URL =
		"http://localhost:8080/musicalbumWS/api/album";

   // Constant for valid content types for these web services
	public static final String JSON_CONTENT_TYPE = "application/json";
	public static final String JSON_UTF_8_CONTENT_TYPE
								= JSON_CONTENT_TYPE + "; charset=utf-8";


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

	// REQUEST to add
	public void add(String id, String name, String genre, boolean isCompilation, int trackCount)	throws Exception
	{
		// TO DO
	}

	// REQUEST to edit
	//
	public void edit(String id, String name, String genre, boolean isCompilation, int trackCount)	throws Exception
	{
		// TO DO

	} // edit

	// REQUEST: Delete
	//
 	public void delete(String id) throws Exception
	{
		// TO DO
    }

	// REQUEST to get all
	//
	public String getAll() throws Exception
  	{
    	// TO DO
    	return null;
    }

	//	REQUEST to get one album
	//
	public String get(String id) throws Exception
	{
		// TO DO
		return null;
	}
}
