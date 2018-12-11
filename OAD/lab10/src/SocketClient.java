import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.net.Socket;

import java.util.Scanner;

class SocketClient
{
	// TODO: change this to have a value greater than 1024 on LatCS
	static final int PORT = 7777;
	// TODO: This can be changed to be the IP of your machine or the address of LatCS
	static final String target = "localhost";
	public static void main( String [] args ) throws IOException
	{
		// define an object to represent the keyboard
		Scanner keyboard =
			new Scanner(System.in);

		// create a socket and input/output streams
		//
		Socket socket = new Socket( target, PORT );
		BufferedReader inStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter outStream = new PrintWriter( socket.getOutputStream(), true );

		// send number to get the double. Terminate with CTRL-C
		//
		while (true )
		{	// get a number and send it
			System.out.print( "Enter a number: " );
			int n = Integer.parseInt( keyboard.nextLine());
			outStream.println( n + "");

			// receive the result and print it
			int twice = Integer.parseInt( inStream.readLine());
			System.out.println( "Receives: " + twice );
		}
	}
}
