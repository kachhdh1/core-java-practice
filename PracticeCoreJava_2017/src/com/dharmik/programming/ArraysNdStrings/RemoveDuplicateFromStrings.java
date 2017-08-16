package com.dharmik.programming.ArraysNdStrings;

import java.util.Arrays;

public class RemoveDuplicateFromStrings {

	public static void main(String[] args) {
		String str = "geeksforgeeks";
		System.out.println(removeDups(str));
	}

	/* Method to remove duplicates in a sorted array */
	static String removeDupsSorted(String str) {
		int res_ind = 1, ip_ind = 1;

		// Character array for removal of duplicate characters
		char arr[] = str.toCharArray();

		/* In place removal of duplicate characters */
		while (ip_ind != arr.length) {
			if (arr[ip_ind] != arr[ip_ind - 1]) {
				arr[res_ind] = arr[ip_ind];
				res_ind++;
			}
			ip_ind++;

		}

		str = new String(arr);
		return str.substring(0, res_ind);
	}

	/*
	 * Method removes duplicate characters from the string This function work
	 * in-place and fills null characters in the extra space left
	 */
	static String removeDups(String str) {
		// Sort the character array
		char temp[] = str.toCharArray();
		Arrays.sort(temp);
		str = new String(temp);

		// Remove duplicates from sorted
		return removeDupsSorted(str);
	}

	// this SIMPLE
	static String removeDuplicates(String s) {
		StringBuilder noDupes = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			String si = s.substring(i, i + 1);
			if (noDupes.indexOf(si) == -1) {
				noDupes.append(si);
			}
		}
		return noDupes.toString();
	}

}
