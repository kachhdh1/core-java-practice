package com.java.core.programming;

import java.util.HashSet;
import java.util.Set;

public class DuplicateWordInString {

	public static void main(String[] args) {
		String testStr = "This is is String with two duplicate words. two";
		System.out.println(DuplicateWordInString.duplicateString(testStr));
		
	}
	
	public static Set<String> duplicateString(String str){
		String[] arr = str.split("\\s");
		Set<String> set = new HashSet<String>();
		Set<String> testSet = new HashSet<String>();
		for(String s : arr){
			if(!testSet.add(s)){
				set.add(s);
			}
		}
		
		return set;
		
	}

}
