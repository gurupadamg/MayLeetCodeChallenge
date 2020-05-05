package com.mlcc.week1;

public class Day4_MoveZeros {

	/*
	 * Given an array nums, write a function to move all 0's to the end of it while
	 * maintaining the relative order of the non-zero elements.
	 * 
	 * Example:
	 * 
	 * Input: [0,1,0,3,12] Output: [1,3,12,0,0] Note:
	 * 
	 * You must do this in-place without making a copy of the array. Minimize the
	 * total number of operations.
	 */

	public static void moveZeroes(int[] nums) {
		int count = 0;

		// Move All Zero's to Left Side.
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				count++;
			} else {
				nums[i - count] = nums[i];
			}
		}
		// 0 1 2 0 4 => 124 => 12400
		// length - 5, count = 2
		// Fill the Zero with Right Side.
		for (int i = nums.length - count; i < nums.length; i++) {
			nums[i] = 0;
		}

		// Print
		for (int n : nums) {
			System.out.print(n + " ");
		}
	}

	public static void main(String[] args) {
		System.out.println("Test Case 1: ");
		moveZeroes(new int[] { 1, 0, 2, 3, 4, 5, 0 });

		System.out.println();
		System.out.println("**********");
		System.out.println("Test Case 2: ");
		moveZeroes(new int[] { 0, 1, 0, 3, 12 });

		System.out.println();
		System.out.println("**********");
		System.out.println("Test Case 3: ");
		moveZeroes(new int[] { 0, 0, 1, 0, 3, 12 });

		System.out.println();
		System.out.println("**********");
		System.out.println("Test Case 4: ");
		moveZeroes(new int[] { 9, 1, 10, 34, 12 });

		System.out.println();
		System.out.println("**********");
		System.out.println("Test Case 5: ");
		moveZeroes(new int[] { 0, 0, 0, 0, 0, 0 });
	}
}
