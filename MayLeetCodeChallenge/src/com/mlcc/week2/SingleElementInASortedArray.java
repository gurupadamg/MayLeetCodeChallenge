package com.mlcc.week2;

public class SingleElementInASortedArray {

	/*
	 * You are given a sorted array consisting of only integers where every element
	 * appears exactly twice, except for one element which appears exactly once.
	 * Find this single element that appears only once.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: [1,1,2,3,3,4,4,8,8] Output: 2 Example 2:
	 * 
	 * Input: [3,3,7,7,10,11,11] Output: 10
	 * 
	 * 
	 * Note: Your solution should run in O(log n) time and O(1) space.
	 */

	// Your solution should run in O(log n) time and O(1) space.
	// Using Binary Search Approach, As Input Array is Sorted.
	public static int singleNonDuplicate(int[] nums) {
		int si = 0;
		int ei = nums.length - 1;

		if (nums.length == 1) {
			return nums[0];
		}

		while (si <= ei) {
			int mid = si + (ei - si) / 2;

			if (mid - 1 < 0 || mid + 1 >= nums.length) {
				return nums[mid];
			}

			// if mid is even
			if (mid % 2 == 0) {
				if (nums[mid] == nums[mid - 1])
					ei = mid - 2;
				else if (nums[mid] == nums[mid + 1])
					si = mid + 1;
				else
					return nums[mid];
			} else {
				if (nums[mid] == nums[mid - 1])
					si = mid + 1;
				else if (nums[mid] == nums[mid + 1])
					ei = mid - 1;

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
	// T.C = O(N)
	public static int singleNonDuplicate1(int[] nums) {
		int ans = 0;
		for (int num : nums) {
			ans = ans ^ num;
			
			/* As we using XOR Operation. Because of Problem Statement.
			every element appears twice except for one. 
			so xor operation on same element will be come zero. (a ^ a = 0)
			and (0 ^ x = x)  */
		}
		return ans;
	}
	public static void main(String[] args) {
		System.out.println("Test Case 1: " + singleNonDuplicate(new int[] {1,2,2}));
		System.out.println("Test Case 2: " + singleNonDuplicate(new int[] {2,2,3,3,4,5,5}));
		System.out.println("Test Case 3: " + singleNonDuplicate(new int[] {2,2,3,3,4,4,5,6,6}));
		System.out.println("Test Case 4: " + singleNonDuplicate(new int[] {2,2,3,5,5,11,11,12,12}));
		System.out.println("Test Case 1: " + singleNonDuplicate(new int[] {-2,-1,-1}));
	}
}
