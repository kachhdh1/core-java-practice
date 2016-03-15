package com.junitTestCases.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.java.core.programming.ReverserMsInt;

public class TestReverseMsInt {

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/
	
	@Test
	public void testGeneralInput(){

		assertEquals(3478, ReverserMsInt.reverse(8743));
	}
	
	@Test
	public void testZeroAndOne(){

		assertEquals(1, ReverserMsInt.reverse(1));
		assertEquals(0, ReverserMsInt.reverse(0));
	}
	
	@Test
	public void testNumberEndingWithZero(){

		assertEquals(42, ReverserMsInt.reverse(24000));
	}

}
