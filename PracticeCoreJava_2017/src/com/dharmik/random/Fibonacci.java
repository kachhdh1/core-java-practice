package com.dharmik.random;

import java.util.HashMap;
import java.util.Map;

/**
 * Interesting point is that improved method only shows better performance for
 * large numbers like 100M otherwise iterative version of Fibonacci method is
 * faster. That could be explained by extra work done by improved method in
 * terms of storing value in cache and getting it from there
 * 
 * Read more:
 * http://www.java67.com/2016/05/fibonacci-series-in-java-using-recursion.html
 * 
 * @author dharmik
 *
 */
public class Fibonacci {

	public static void main(String[] args) {

		int number = 12; // number upto which series is printed
		for (int i = 1; i <= number; i++) {
			System.out.println(fiboCached(i));
		}
	}

	/*
	 * * Java Program to calculate Fibonacci numbers with memorization * This is
	 * quite fast as compared to previous Fibonacci function * especially for
	 * calculating factorial of large numbers.
	 */
	private static int fiboCached(int number) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(number);

		if (number == 1 || number == 2) {
			return 1;
		}

		// check in the map if the value is already computed
		if (map.containsKey(number)) {
			return (int) map.get(number);
		} else {
			// calculate the value with iterative or recursive
			int fiboRes = fiboIter(number); // call fibonacci calculations
			map.put(number, fiboRes);
			return fiboRes;
		}

	}

	// recursive way of calculating the fibonacci
	private static int fiboRecursive(int number) {

		if (number == 1 || number == 2) {
			return 1;
		}

		return fiboRecursive(number - 2) + fiboRecursive(number - 1);
	}

	/**
	 * this is the iterative method of fibonacci
	 * 
	 * @param number
	 * @return
	 */
	private static int fiboIter(int number) {
		if (number == 1 || number == 2) {
			return 1;
		}

		int num1 = 1;
		int num2 = 1;
		int next = 1;
		for (int i = 3; i <= number; i++) {
			next = num1 + num2;
			num1 = num2;
			num2 = next;
		}
		return next;
	}

}
