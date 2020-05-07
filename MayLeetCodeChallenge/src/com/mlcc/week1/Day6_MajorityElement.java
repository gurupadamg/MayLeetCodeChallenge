package com.mlcc.week1;

import java.util.LinkedHashMap;
import java.util.Map;

public class Day6_MajorityElement {

	/*
	 * Given an array of size n, find the majority element. The majority element is
	 * the element that appears more than ⌊ n/2 ⌋ times.
	 * 
	 * You may assume that the array is non-empty and the majority element always
	 * exist in the array.
	 * 
	 * Example 1:
	 * 
	 * Input: [3,2,3] Output: 3 Example 2:
	 * 
	 * Input: [2,2,1,1,1,2,2] Output: 2
	 * 
	 * 
	 */

	/**
	 * https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
	 * 
	 * Using Boyer–Moore majority vote algorithm
	 * 
	 * TC = O(n) and SC = O(1)
	 * 
	 */
	public static int majorityElement(int[] nums) {

		/*
		 * Based on Given Condition, You may assume that the array is non-empty and the
		 * majority element always exist in the array. So we can use Boyer-Moore Algo.
		 */
		int count = 0;
		int candidate = -1;

		for (int i = 0; i < nums.length; i++) {
			if (count == 0) {
				candidate = nums[i];
			}

			count = count + (nums[i] == candidate ? 1 : -1);
		}

		return candidate;

	}

	/*
	 * Approach1: Using Map.
	 * 
	 * TC : O(n) and SC: O(n)
	 * 
	 */
	public static int majorityElement1(int[] nums) {
		Map<Integer, Integer> countMap = new LinkedHashMap<>();

		for (int num : nums) {
			countMap.put(num, countMap.getOrDefault(num, 0) + 1);
		}

		for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
			if (entry.getValue() > (nums.length / 2)) {
				return entry.getKey();
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		System.out.println("Test Case1: " + majorityElement(new int[] { 3, 2, 3 }));
		System.out.println("Test Case2: " + majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 }));
	}
}
