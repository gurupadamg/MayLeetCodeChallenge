package com.mlcc.week2;

import java.util.Stack;

public class RemoveKDigits {

	/*
	 * 
	 * Given a non-negative integer num represented as a string, remove k digits
	 * from the number so that the new number is the smallest possible.
	 * 
	 * Note: The length of num is less than 10002 and will be ≥ k. The given num
	 * does not contain any leading zero. Example 1:
	 * 
	 * Input: num = "1432219", k = 3 Output: "1219" Explanation: Remove the three
	 * digits 4, 3, and 2 to form the new number 1219 which is the smallest. Example
	 * 2:
	 * 
	 * Input: num = "10200", k = 1 Output: "200" Explanation: Remove the leading 1
	 * and the number is 200. Note that the output must not contain leading zeroes.
	 * Example 3:
	 * 
	 * Input: num = "10", k = 2 Output: "0" Explanation: Remove all the digits from
	 * the number and it is left with nothing which is 0.
	 */

	/* Using Stack */
	public static String removeKdigits(String num, int k) {

		/* Base Condition */
		if (k >= num.length()) {
			return "0";
		}
		Stack<Character> dataStack = new Stack<>();

		for (int i = 0; i < num.length(); i++) {

			while (k > 0 && !dataStack.isEmpty() && dataStack.peek() > num.charAt(i)) {
				dataStack.pop();
				k--;
			}
			dataStack.push(num.charAt(i));
		}

		while (k > 0) {
			dataStack.pop();
			k--;
		}
		StringBuilder sb = new StringBuilder();
		while (!dataStack.isEmpty()) {
			sb.append(dataStack.pop());
		}

		sb = sb.reverse();

		// Removing Leading Zero's
		while (sb.length() > 1 && sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}

		if (sb.length() == 0) {
			return "0";
		}

		return sb.toString();
	}

	public static String removeKdigits1(String num, int k) {

		/* Base Condition */
		if (k >= num.length()) {
			return "0";
		}
		StringBuilder sb = new StringBuilder(num);

		for (int j = 0; j < k; j++) {
			int i = 0;
			while (i < sb.length() - 1 && sb.charAt(i) <= sb.charAt(i + 1)) {
				i++;
			}
			sb.delete(i, i + 1);
		}

		// Removing Leading Zero's
		while (sb.length() > 1 && sb.charAt(0) == '0') {
			sb.delete(0, 1);
		}

		if (sb.length() == 0) {
			return "0";
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println("Test Case 1: " + removeKdigits("1234", 1));
		System.out.println("Test Case 2: " + removeKdigits("1243", 1));
		System.out.println("Test Case 3: " + removeKdigits("501243", 1));
	}

}
