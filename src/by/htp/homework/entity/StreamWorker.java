package by.htp.homework.entity;

import java.io.*;

public class StreamWorker {

    public static String bufferCharStreamWorker(File fFile){
        String str, sResult = null;
        try(BufferedReader br = new BufferedReader(new FileReader(fFile))){
            while ((str = br.readLine()) != null){
                sResult = str;
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return sResult;
    }

    public static void byteStreamWorker(File fFile, String sText){
        try(InputStream is = new FileInputStream(fFile);
                OutputStream os = new FileOutputStream(fFile)){
            byte[] data = sText.getBytes();
            os.write(data);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
        
}
