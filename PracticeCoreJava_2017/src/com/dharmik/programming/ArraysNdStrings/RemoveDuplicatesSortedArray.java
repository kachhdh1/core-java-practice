package com.dharmik.programming.ArraysNdStrings;

import java.util.*;

public class RemoveDuplicatesSortedArray {


	/**
	 * Time Complexity : O(n)
	   Auxiliary Space : O(1)
	 * @param args
	 */
    public static void main(String[] args) {

    	int[] arr = {1,2,2,2,3,3,4,5,5,5,6,6};
    	
    	int j=0;
    	for(int i=0;i<arr.length-1;i++){//length
    		if(arr[i]!=arr[i+1]){
    			arr[j++] = arr[i];
    		}
    	}
    	arr[j]=arr[arr.length-1];
    	
    	// Print updated array till J position
    	//since it is updating the same array without any buffer,
    	//use only till jth position as it is duplicate removed
        for (int i=0; i<=j; i++)
           System.out.print(arr[i]+" ");    	
    }
}
