import java.io.*;
import java.net.*;

public class SocketThread extends Thread
{
	// attributes
	Socket socket;
	int id;
	BufferedReader inStream;
	PrintWriter outStream;

	// constructor
	SocketThread( Socket aSocket, int anId ) throws IOException
	{
		socket = aSocket;
		id = anId;
		inStream = new BufferedReader(new InputStreamReader( socket.getInputStream()));
		outStream = new PrintWriter( socket.getOutputStream(), true );
	}

	// run method
	public void run( )
	{
		while (true )
		{
			try
			{	// get a number from the client
				int n = Integer.parseInt( inStream.readLine());

				// send back twice the number
				int twice = n * 2;
				outStream.println( twice + "" );
			}
			catch(IOException | NumberFormatException e)
			{
				System.out.println( e );
				socket = null;
				break;
			}
		}

	} //run

}