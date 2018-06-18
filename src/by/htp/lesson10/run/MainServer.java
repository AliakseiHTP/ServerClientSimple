package by.htp.lesson10.run;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {

	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = null;
		
		try {
			System.out.println("Server started: ");
			/*ServerSocket */serverSocket = new ServerSocket(9696);
			Socket clientSocket = serverSocket.accept();
			
			System.out.println("Client connected: ");
//			OutputStream os = clientSocket.getOutputStream();
//			PrintWriter writer = new PrintWriter(os);
			
			InputStream is = clientSocket.getInputStream();
			
			byte[] data = new byte[1024];
			is.read(data);
			
			System.out.println("Data recieved: ");
			System.out.println(new String(data));
			
			OutputStream os = clientSocket.getOutputStream();
			PrintWriter writer = new PrintWriter(os);
			
//			writer.print("HTTP/1.1 200 \r\n");
//			writer.print("Content-Type: text/html\r\n");
//
//			// writer.print("Connection: close\r\n");
//			writer.print("\r\n");
//			writer.print("<html><head></head><body><h1>Hello User!</h1></body></html>");
//			writer.print("Conenection: close\r\n");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			serverSocket.close();
		}
	}

}
