package com.dharmik.programming.ArraysNdStrings;

/**
 * This class prints the minimum number of character which 
 * will be removed from the input strings to make them anagram
 * @author dharmik
 *
 */
public class StringMakeAnagram {

	public static void main(String[] args) {
		//making string anagrams
		String inp1 = "abc";
		String inp2 = "cde";
		
		int[] one = new int[26];
		int[] two = new int[26];
		
		for(char c: inp1.toCharArray()){
			one[c-'a']++;
		}
		for(char c: inp2.toCharArray()){
			two[c-'a']++;
		}
		
		//traverse count arrays to find the number
		int result = 0;
		for(int i=0;i<26;i++){
			result +=(Math.abs(one[i]-two[i]));
		}
		System.out.println(result);
	}

}
