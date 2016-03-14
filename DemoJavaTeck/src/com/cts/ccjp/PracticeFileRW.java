package com.cts.ccjp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class PracticeFileRW {

	public static void main(String[] args) {
		FileReadWrite frw = new FileReadWrite();
		//frw.createFile();
		Map<Integer, String> empMap = frw.readFileData();
		frw.disp(empMap);
		System.out.println(frw.search(empMap, 4343));
		System.out.println(frw.searchRange(empMap, 334667,500000));
	}

}

class FileReadWrite{
	static final String fileName = "C:\\Dharmik\\employees.txt";
	
	public String search(Map<Integer, String> map, int key){
		if(map.containsKey(key)){
			return map.get(key);
		}
		else{
			return "No records with key "+key;
		}
	}
	
	public Map searchRange(Map<Integer, String> map, int ul, int ll){
		return ((TreeMap) map).subMap(ul, ll);
	}
	
	public void createFile(){
		try {
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fileWriter);
			bw.write("Dharmik");bw.write(" ");bw.write("324667");
			bw.newLine();
			bw.write("Nilya");bw.write(" ");bw.write("400000");
			bw.close();
			System.out.println("File Created succesfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Map<Integer, String> readFileData(){
		Map<Integer, String> empMap = new TreeMap<Integer, String>();
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fileReader);
			
			String line = null;
			while( (line = br.readLine()) !=null ){
				String[] temp =line.split(" ");
				empMap.put(new Integer(temp[1]), temp[0]);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return empMap;
	}
	
	public void disp(Map<Integer, String> map){
		Set<Entry<Integer, String>> set = map.entrySet();
		for(Entry<Integer, String> e : set){
			System.out.println("Employee id :"+e.getKey()+" and name :"+e.getValue());
		}
	}
}
