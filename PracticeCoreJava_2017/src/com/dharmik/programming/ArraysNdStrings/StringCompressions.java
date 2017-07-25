package com.dharmik.programming.ArraysNdStrings;

public class StringCompressions {

	public static void main(String[] args) {
		String input = "aabcccccaaa";
		//output should be = "a2b1c5a3";
		
		System.out.println(compress(input));

	}

	private static String compress(String input) {
		StringBuilder result = new StringBuilder();
		int countConsecutive = 0;
		
		for(int i=0;i<input.length();i++){
			//increase the count as first occurance should be 1
			countConsecutive++;
			
			if(i+1>=input.length() || input.charAt(i)!=input.charAt(i+1)){
				result.append(input.charAt(i));
				result.append(countConsecutive);
				//reset the value after appending count
				countConsecutive=0;
			}
			
		}
		return result.toString();
	}

}
