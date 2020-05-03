package com.mlcc.week1;

public class Day3_MaximumSubArray {

	/**
	 * 
	 * Given an integer array nums, find the contiguous subarray (containing at
	 * least one number) which has the largest sum and return its sum.
	 * 
	 * Example:
	 * 
	 * Input: [-2,1,-3,4,-1,2,1,-5,4], Output: 6 Explanation: [4,-1,2,1] has the
	 * largest sum = 6. Follow up:
	 * 
	 * If you have figured out the O(n) solution, try coding another solution using
	 * the divide and conquer approach, which is more subtle.
	 */
	public static int maxSubArray(int[] nums) {
		int currentSum = 0;
		int maxSum = Integer.MIN_VALUE;
		for(int num : nums) {
			currentSum = currentSum + num;
			maxSum = Math.max(currentSum, maxSum);
			currentSum = Math.max(currentSum, 0);
		}
		return maxSum;
	}

	public static void main(String[] args) {
		System.out.println("Test Case1 : " + maxSubArray(new int[] {-2, 1, -3, 4,-1,2,1,-5,4})); //6
		System.out.println("Test Case2 : " + maxSubArray(new int[] {5, -1, 3, 4})); //11
		System.out.println("Test Case3 : " + maxSubArray(new int[] {5, -10, 3, 4})); //7
		System.out.println("Test Case4 : " + maxSubArray(new int[] {-5, -10, -3, -4})); // -3
		System.out.println("Test Case5 : " + maxSubArray(new int[] {-1, -1, 1, 1})); //2
		System.out.println("Test Case5 : " + maxSubArray(new int[] {-1}));
	}
}
