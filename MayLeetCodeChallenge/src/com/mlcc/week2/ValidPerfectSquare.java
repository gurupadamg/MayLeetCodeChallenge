package com.mlcc.week2;

public class ValidPerfectSquare {

	/*
	 * Given a positive integer num, write a function which returns True if num is a
	 * perfect square else False.
	 * 
	 * Note: Do not use any built-in library function such as sqrt.
	 * 
	 * Example 1:
	 * 
	 * Input: 16 Output: true Example 2:
	 * 
	 * Input: 14 Output: false
	 */

	public static boolean isPerfectSquare(int num) {

		long left = 1, right = num;
		while (left <= right) {
			long mid = (left + right) / 2;
			if (mid * mid == num)
				return true; // check if mid is perfect square
			if (mid * mid < num) { // mid is small -> go right to increase mid
				left = mid + 1;
			} else {
				right = mid - 1; // mid is large -> to left to decrease mid
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println("Test Case 1 : " + isPerfectSquare(3));
		System.out.println("Test Case 2 : " + isPerfectSquare(4));
		System.out.println("Test Case 3 : " + isPerfectSquare(5));
		System.out.println("Test Case 4 : " + isPerfectSquare(9));
		System.out.println("Test Case 5 : " + isPerfectSquare(808201));
	}
}
