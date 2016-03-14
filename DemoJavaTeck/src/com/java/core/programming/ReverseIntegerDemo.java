package com.java.core.programming;

public class ReverseIntegerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(reverseInt(134236469));
	}
	
	public static int reverseInt(int input){
		int reverse = 0;
		boolean isNegative=input<0?true:false;
		
		if(isNegative){
			input=input*-1;
		}
		
		while(input>0){
			int lastDigit = input%10;
			reverse = reverse*10+lastDigit;
			input=input/10;
		}
		
		
		return isNegative==true?reverse*=-1:reverse;
	}

}
