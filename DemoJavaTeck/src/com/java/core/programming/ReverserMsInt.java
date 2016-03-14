package com.java.core.programming;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReverserMsInt {

	public static void main(String args[]){
		//System.out.println(ReverserMsInt.reverse(3678));
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		
		for(Iterator<Integer> i = list.iterator();i.hasNext();){
			System.out.println(i.next());
		}
	}
	
	public static int reverse(int input){
		int res = 0;
		
		int lastDigit;
		while(input>0){
			lastDigit = input%10;
			res = res*10+lastDigit;
			input = input/10;
		}
		
		return res;
	}
	
}
