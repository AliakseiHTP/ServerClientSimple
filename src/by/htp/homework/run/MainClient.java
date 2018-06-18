package by.htp.homework.run;


import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import by.htp.homework.entity.FileCreator;
import by.htp.homework.entity.InputData;
import by.htp.homework.entity.StreamWorker;

public class MainClient {
    public static void main(String[] args) {
        String sPath = "resources/clientData.txt";
        try {
            Socket clientSocket = new Socket("localhost",9987);
            System.out.println("Client connected:");
            clientSocket.getOutputStream().write(InputData.data().getBytes());

            InputStream is = clientSocket.getInputStream();

            byte[] data = new byte[1024];
            is.read(data);

            System.out.println("Data received from server:");
            StreamWorker.byteStreamWorker(FileCreator.createFile(sPath),new String(data));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
