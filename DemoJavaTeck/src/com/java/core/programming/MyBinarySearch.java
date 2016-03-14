package com.java.core.programming;

public class MyBinarySearch {
	
	public static int search(int[] input, int val){
		int start = 0;
		int end = input.length-1;
		int mid = (start+end)/2;
		
		while(start<=end){
			if(input[mid]==val)
				return mid;
			if(val<input[mid]){
				mid=mid-1;
			}
			else{
				start=mid+1;
			}
		}
		
		return -1;
	}

}
