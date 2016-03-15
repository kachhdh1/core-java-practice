package com.junitTestCases.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.java.core.programming.MyBinarySearch;

public class TestMyBinarySearch {

	@Test
	public void testGeneralLinearSearch(){
		int[] a = {3,4,5,6,7,8}; 
		assertEquals(2, MyBinarySearch.search(a,5));
	}
}
