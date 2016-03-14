package com.cts.ccjp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileRw1 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) {
		String file = "temp.txt";
	
		
		try {
			
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("Dharmik");
			
			/*bufferedWriter.newLine();
			bufferedWriter.write("Kachhia");*/
			bufferedWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
