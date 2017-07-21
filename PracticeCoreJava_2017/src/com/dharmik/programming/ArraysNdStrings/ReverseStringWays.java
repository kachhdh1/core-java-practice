package com.dharmik.programming.ArraysNdStrings;

public class ReverseStringWays {

	public static void main(String[] args) {

		System.out.println(reverse1("Dharmik"));
	}

	private static String reverse1(String input) {
		char[] strChars = input.toCharArray();
		int end = strChars.length - 1;
		for (int start = 0; start < end; start++, end--) {
			char temp = strChars[start];
			strChars[start] = strChars[end];
			strChars[end] = temp;
		}
		return new String(strChars);
	}

	public static String inPlaceReverse(final String input) {
		final StringBuilder builder = new StringBuilder(input);
		int length = builder.length();
		for (int i = 0; i < length / 2; i++) {
			final char current = builder.charAt(i);
			final int otherEnd = length - i - 1;
			builder.setCharAt(i, builder.charAt(otherEnd)); // swap
			builder.setCharAt(otherEnd, current);
		}
		return builder.toString();

	}
}
