package by.htp.homework.entity;

import java.io.*;

public class FileCreator {

    public static File createFile(String sPath){
        File fFile = new File(sPath);
        if(!fFile.exists()){
            try {
                fFile.createNewFile();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return fFile;
    }
}
