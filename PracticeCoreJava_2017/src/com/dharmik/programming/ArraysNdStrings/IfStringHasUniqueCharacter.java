package com.dharmik.programming.ArraysNdStrings;

public class IfStringHasUniqueCharacter {

	public static void main(String[] args) {
		String inp = "aba";
		if (isUniqueChars2(inp))
			System.out.println("String has unique character");
		else
			System.out.println("Duplicate characters in String");
	}

	// if strings has only aschi characters, all can
	// fit inside 256 length array all initialized with false .
	public static boolean isUniqueChars2(String str) {
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val])
				return false;
			char_set[val] = true;
		}
		return true;
	}

	// https://www.quora.com/Could-someone-explain-how-this-code-dictates-if-the-string-has-all-unique-characters-or-not
	public static boolean isUniqueChars3(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); ++i) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0)
				return false;
			checker |= (1 << val);
		}
		return true;
	}

	private static boolean isUniqueDk(String input) {

		if (input.length() == 1)
			return true;

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			// this for loop counter is imp as the checking should
			// start after every iteration if one element is checked (i+1)
			for (int cnt = i + 1; cnt < input.length(); cnt++) {
				if (input.charAt(cnt) == c) {
					return false;
				}
			}
		}
		return true;
	}
}
