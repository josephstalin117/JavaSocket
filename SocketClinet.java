import java.io.*;
import java.net.*;

public class SocketClinet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			Socket socket = new Socket("192.168.1.152", 4700);
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			String readline;
			readline = sin.readLine();
			while (!readline.equals("bye")) {
				os.println(readline);
				System.out.println("Client:" + readline);
				os.flush();
				System.out.println("Server:" + is.readLine());
				readline = sin.readLine();
			}
			os.close();
			is.close();
			socket.close();
		} catch (Exception e) {
			System.out.println("Error" + e);
		}
	}
}
