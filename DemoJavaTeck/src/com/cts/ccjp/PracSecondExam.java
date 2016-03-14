package com.cts.ccjp;

import java.util.Arrays;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class PracSecondExam {

	public static void main(String[] args) {
		Arrays.asList(null);
		//Arrays.sort(); //invalid method
		//Arrays.search(); //invalid method
		//--------------------------------------
		int[] a = {};
		short[] b = {};
		byte[] c = {};
		//String aa = new String(b);
		//--------------------------------------
		double d = -100.675;
		System.out.println(Math.ceil(d));//-100
		//--------------------------------------
		NavigableSet treeSet = new TreeSet();
		treeSet.add(2);
		treeSet.add(5);
		treeSet.add(9);
		// to show 2 as output?
		System.out.println(treeSet.lower(8));
		System.out.println(treeSet.headSet(5));
		System.out.println(treeSet.tailSet(3));
		System.out.println(treeSet.pollLast());
		//----------------------------------------
		boolean test = true; test = !test;
		
	}

}
