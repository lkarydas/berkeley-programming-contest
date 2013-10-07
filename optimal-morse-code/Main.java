import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main (String[] args) {
		OptimalMorseEncoding optimalMorseEnconding = new OptimalMorseEncoding();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String msg = null;
		while (true) {
			// Get a message from standard input.
			try {
				msg = br.readLine();
			} catch (IOException ioe) {
				System.err.println(ioe.toString());
			}
			// Calculate and print the transmission time.
			System.out.println(optimalMorseEnconding.calculateTransmitionTime(msg));
		}
	}
}