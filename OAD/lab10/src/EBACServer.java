import java.io.*;
import java.net.*;

class EBACServer
{
    // TODO: change this to have a value greater than 1024 on LatCS
    static final int PORT = 7777;
    public static void main( String [] args ) throws IOException
    {
        System.out.printf("Network Address: %s%nListening on Port: %d%n",
                InetAddress.getLocalHost().getHostAddress(), PORT);

        // create a server socket
        ServerSocket serverSocket = new ServerSocket( PORT );
        int socketCount = 0;

        while (true )
        {
            // accept a connection
            Socket socket = serverSocket.accept();

            // create a thread to manage the socket
            EBACThread ebacThread = new EBACThread( socket, socketCount );
            ebacThread.start();
        }
    }
}