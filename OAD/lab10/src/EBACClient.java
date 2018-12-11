import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.net.Socket;

import java.util.Scanner;

class EBACClient
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
            System.out.print( "Enter the number of standard drinks: " );
            int stdDrinks = Integer.parseInt( keyboard.nextLine());
            outStream.println( stdDrinks + "");
            System.out.print( "Enter your weight (in kg): " );
            double weight = Double.parseDouble( keyboard.nextLine());
            outStream.println( weight + "");
            System.out.print( "Enter your gender(male/female): " );
            boolean gender =  keyboard.nextLine().equalsIgnoreCase("male");
            outStream.println( gender?"true":"false");
            System.out.print( "Enter the number of hours since you started drinking: " );
            double hours = Double.parseDouble( keyboard.nextLine());
            outStream.println( hours + "");

            // receive the result and print it
            double EBAC = Double.parseDouble( inStream.readLine());
            String message = inStream.readLine();
            System.out.println( "EBAC: " + EBAC );
            System.out.println("Message: " + message);
        }
    }
}
