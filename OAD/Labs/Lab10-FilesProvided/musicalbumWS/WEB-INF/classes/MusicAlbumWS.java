import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class MusicAlbumWS extends HttpServlet
{
	MusicAlbumDSC dsc = new MusicAlbumDSC();

	// To get
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		try
		{
			// Get id
			String id = request.getParameter("id");
			System.out.println(">>> id: " + id);

			if (id != null)
			// Get one
			{
				MusicAlbum album = dsc.get(id);

				response.setContentType("application/json");
				PrintWriter out = response.getWriter();
				out.print( (new Gson()). toJson(album));
			}
			else
			//	Get all
			{
				List<MusicAlbum> list = dsc.getAll();

				response.setContentType("application/json");
				PrintWriter out = response.getWriter();
				out.print( (new Gson()). toJson(list));
			}

		}
		catch(Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
	}

	//	To add
	//
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		try
		{
			//	Get request content type (optional)
			String requestContentType = request.getContentType();
			System.out.println(">>> request content type: " + requestContentType);

			// Get data
			BufferedReader in = request.getReader();
			StringBuffer dataSB = new StringBuffer();
			String line = in.readLine();
			while(line != null)
			{
				dataSB.append(line).append("\n");
				line = in.readLine();
			}
			String data = dataSB.toString();
			System.out.println(">>> data:\n*" + data +"*");

			// Convert
			MusicAlbum album = (new Gson()). fromJson(data, MusicAlbum.class);

			dsc.add(album);

			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.print(data);
		}
		catch(Exception e)
		{
			// throw new RuntimeException(e.getMessage());
			response.sendError(800, e.getMessage());
		}
	}

	//	To upadate
	//
	public void doPut(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		try
		{
			//	Get request content type (optional)
			String requestContentType = request.getContentType();
			System.out.println(">>> request content type: " + requestContentType);

			// Get id
			String id = request.getParameter("id");
			System.out.println(">>> id: " + id);

			// Get data
			BufferedReader in = request.getReader();
			StringBuffer dataSB = new StringBuffer();
			String line = in.readLine();
			while(line != null)
			{
				dataSB.append(line).append("\n");
				line = in.readLine();
			}
			String data = dataSB.toString();
			System.out.println(">>> data:\n*" + data +"*");

			// Convert Json to album
			MusicAlbum album = (new Gson()). fromJson(data, MusicAlbum.class);

			dsc.update(album);

			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.print(data);
		}
		catch(Exception e)
		{
			// throw new RuntimeException(e.getMessage());
			response.sendError(800, e.getMessage());
		}
	}// doPut

	// To delete
	public void doDelete(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		try
		{
			//	Get request content type (optional)
			String requestContentType = request.getContentType();
			System.out.println(">>> request content type: " + requestContentType);

			// Get id
			String id = request.getParameter("id");
			System.out.println(">>> id: " + id);

			// delete from database
			dsc.delete(id);


			// The next statement is optional because we don't expect the client
			// to get the data. However, there is no harm in having it
			response.setContentType("application/json");
			(response.getWriter()).println("{}");	// should not need this

		}
		catch(Exception e)
		{
			// throw new RuntimeException(e.getMessage());
			response.sendError(800, e.getMessage());
		}

		// For testing, try to delete an existing and a non-existing product
	}

}
