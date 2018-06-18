package by.htp.lesson10.run;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MainClient {

	public static void main(String[] args) {

		try {
			Socket clientSocket = new Socket("localhost",9696);

//			PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
//			writer.println("Hello Server!");
			
			clientSocket.getOutputStream().write("Hello Server".getBytes());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
