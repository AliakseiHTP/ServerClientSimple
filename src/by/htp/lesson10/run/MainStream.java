package by.htp.lesson10.run;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;

public class MainStream {

	public static void main(String[] args) {
		
		File fFile = new File("resources/sample.txt");
		if(!fFile.exists()) {
			try {
				fFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//byteStreamWorker(fFile);
		//charStreamWorker(fFile);
		bufferCharStreamWorker(fFile);
	}
	
	public static void bufferCharStreamWorker(File fFile) {
		/*try(Reader reader = new FileReader(fFile);
				BufferedReader br = new BufferedReader(reader)) {*/
		try(BufferedReader br = new BufferedReader(new FileReader(fFile))){
			System.out.println("___________________________");
			String str = null;
			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void charStreamWorker(File fFile) {
		try (Reader reader = new FileReader(fFile)){
			char[] aArray = new char[1024];
			reader.read(aArray);
			System.out.println(new String(aArray));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void byteStreamWorker(File fFile) {
		try(InputStream is = new FileInputStream(fFile);
				OutputStream os = new FileOutputStream(fFile,true)){
			int bytes = is.available();
			System.out.println("available: " + bytes);
			
			byte[] data = "Hello World!".getBytes();
			os.write(data);
			
			bytes = is.available();
			System.out.println("available: " + bytes);
			
			int b = 0;
			while((b = is.read())>-1) {
				System.out.print((char)b);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
