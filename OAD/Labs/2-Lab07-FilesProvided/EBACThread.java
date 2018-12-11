import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author Micheal
 * @version $Date: 9/09/2014
 */
public class EBACThread extends Thread {

	Socket socket;
	int id;
	BufferedReader inStream;
	PrintWriter outStream;

	public EBACThread(Socket socket, int socketCount) throws IOException {
	}

	public double calculateEBAC(int standard_drinks, double weight, double body_water_constant, double metabolism_constant, double drinking_period) {
		return 0.9672*standard_drinks/(body_water_constant*weight) - metabolism_constant*drinking_period;
	}

	@Override
	public void run() {
		// TODO
	}
}
