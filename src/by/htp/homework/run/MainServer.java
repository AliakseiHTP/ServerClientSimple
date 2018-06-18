package by.htp.homework.run;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import by.htp.homework.entity.FileCreator;
import by.htp.homework.entity.StreamWorker;
import by.htp.homework.entity.StringEditor;

public class MainServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        String sPath = "resources/serverData.txt";
        try {
            System.out.println("Server started:");
            serverSocket = new ServerSocket(9987);
            Socket clientSocket = serverSocket.accept();

            InputStream is = clientSocket.getInputStream();

            byte[] data = new byte[1024];
            is.read(data);

            System.out.println("Data received from client:");
            String[] sPart = new String(data).split("[|]");
            clientSocket.getOutputStream().write(StringEditor.replaceSymbol(StreamWorker.bufferCharStreamWorker(FileCreator.createFile(sPath)), Integer.parseInt(sPart[0]), sPart[1].charAt(0)).getBytes());
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            assert serverSocket != null;
            serverSocket.close();
        }
    }
}
