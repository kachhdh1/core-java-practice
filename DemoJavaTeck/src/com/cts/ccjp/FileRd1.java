package com.cts.ccjp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileRd1 {

	public static void main(String[] args) {
		String file = "temp.txt";
		String line = null;
		try {
			FileReader fileReader = new FileReader(file);
			
			BufferedReader br = new BufferedReader(fileReader);
			while( (line = br.readLine()) !=null){
				System.out.println(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
