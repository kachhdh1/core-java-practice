package com.cts.ccjp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileRw2 {

	public static void main(String[] args) {
		String fileName = "temp1.txt";
		
		String data = "Hello there";
		byte[] buffer = data.getBytes();
		
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			fos.write(buffer);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
