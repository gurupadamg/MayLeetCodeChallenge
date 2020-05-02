package com.mlcc.week1;

import java.util.HashMap;
import java.util.Map;

public class Day1_April_SingleNumber {

	/*
	 * Given a non-empty array of integers, every element appears twice except for
	 * one. Find that single one.
	 * 
	 * Note:
	 * 
	 * Your algorithm should have a linear runtime complexity. Could you implement
	 * it without using extra memory?
	 * 
	 * Example 1:
	 * 
	 * Input: [2,2,1] Output: 1 Example 2:
	 * 
	 * Input: [4,1,2,1,2] Output: 4
	 */

	/*
	 * Approach1: Using Map (i.e., Using Extra Space)
	 * 
	 */
	public static int singleNumber1(int[] nums) {
		Map<Integer, Integer> dataMap = new HashMap<Integer, Integer>();
		for (int num : nums) {
			dataMap.put(num, dataMap.getOrDefault(num, 0) + 1);
		}
		for (Map.Entry<Integer, Integer> entry : dataMap.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		return -1;
	}

	/*
	 * Approach 2: Bit Manipulation Concept
	 * 
	 * i. If we take XOR of zero and some bit, it will return that bit a ^ 0 = a
	 * 
	 * ii. If we take XOR of two same bits, it will return 0 a ^ a = 0
	 * 
	 * iii. a^b^a = a^a^b = (a^a)^b = 0^b = b
	 * 
	 * iv. So we can XOR all bits together to find the unique number.
	 */
	public static int singleNumber(int[] nums) {
		int ans = 0;
		for (int num : nums) {
			ans = ans ^ num;
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println("Test Case 1: " + singleNumber(new int[] { 4, 1, 2, 1, 2 }));
		System.out.println("Test Case 2: " + singleNumber(new int[] { 4, 1, 2, 1, 2, 4 }));// No Value
		System.out.println("Test Case 3: " + singleNumber(new int[] { 4, 1, 2, 1, 2, 4, 5, 5, 3 }));
	}
}
