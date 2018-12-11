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
		this.socket = socket;
		id = socketCount;
		inStream = new BufferedReader(new InputStreamReader( socket.getInputStream()));
		outStream = new PrintWriter( socket.getOutputStream(), true );
	}

	public double calculateEBAC(int standard_drinks, double weight, double body_water_constant, double metabolism_constant, double drinking_period) {
		return 0.9672*standard_drinks/(body_water_constant*weight) - metabolism_constant*drinking_period;
	}

	@Override
	public void run() {
		while(true) {
			try {
				int stdDrinks = Integer.parseInt(inStream.readLine());
				double weight = Double.parseDouble(inStream.readLine());
				boolean gender = (inStream.readLine().equalsIgnoreCase("true"));
				double hours = Double.parseDouble(inStream.readLine());
				double EBAC = calculateEBAC(stdDrinks, weight, gender ? 0.58 : 0.49, gender ? 0.015 : 0.017, hours);
				String message;
				if (0.05 < EBAC) {
					message = "If you drink and drive, you are a criminal";
				} else if (0.001 < EBAC) {
					message = "Be careful if you need to drive!";
				} else {
					message = "You haven't had any alcohol; it's safe for you to drive!";
				}
				outStream.println(EBAC + "");
				outStream.println(message);

			} catch (Exception exc) {
				System.out.println(exc);
				socket = null;
				break;
			}
		}
	}
}
