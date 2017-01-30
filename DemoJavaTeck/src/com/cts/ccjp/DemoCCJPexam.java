package com.cts.ccjp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DemoCCJPexam {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileManager.writeFile();
		List<CCJPbean> list =  new FileManager().readFile();
		for(CCJPbean bean : list){
			System.out.println(bean.getFirstName()+" and "+bean.getStartDate());
		}

	}

}

class FileManager{
	
	
	static String fileName = "CCJP.txt";
	
	public List<CCJPbean> readFile(){
		FileReader reader;
		String line = null;
		BufferedReader br = null;
		List<CCJPbean> listOfRecords = null;
		//date for which policy can not be greater
		String threasholdDate = "01/01/2016";
		Date td = null;
		try {
			td = new SimpleDateFormat("dd/MM/yyyy").parse(threasholdDate);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		try {
			reader = new FileReader(fileName);
			br = new BufferedReader(reader);
			listOfRecords = new ArrayList<CCJPbean>();
			while((line = br.readLine()) !=null){
				/*filter condition to check if policy is available*/
				CCJPbean bean = getBeanForLine(line);
				//read the actual date from fiel
				Date actualDate = bean.getStartDate();
				Calendar cal = Calendar.getInstance();
				//set the date to calendar instance
				cal.setTime(actualDate);
				//add three years
				cal.add(Calendar.YEAR, 3);
				//extract date from calendar
				Date eliDate = cal.getTime();
				if(eliDate.compareTo(td) < 0)
					listOfRecords.add(bean);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return listOfRecords;
	}
	
	public CCJPbean getBeanForLine(String line){
		CCJPbean bean = new CCJPbean();
		//escape metacharacter "|"
		String[] arr = line.split("\\|");
		bean.setEmpId(Integer.parseInt(arr[0]));
		bean.setFirstName(arr[1]);
		bean.setLastName(arr[2]);
		bean.setPolicyId(Long.valueOf(arr[3]));
		try {
			SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
			//convert string to date
			Date date = formater.parse(arr[4]);
			bean.setStartDate(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return bean;
	}
	public static void writeFile(){	
	}
}