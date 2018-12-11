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

	// To get all albums or one album given its id
	//
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		// TODO
	}

	//	To add
	//
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		// TODO
	}

	//	To upadate
	//
	public void doPut(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		// TODO

	}// doPut

	// To delete
	public void doDelete(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		// TODO
	}

}
