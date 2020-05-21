package com.mlcc.week3;

import java.util.ArrayList;
import java.util.List;

public class PermutationInString {

	/*
	 * 
	 * Given two strings s1 and s2, write a function to return true if s2 contains
	 * the permutation of s1. In other words, one of the first string's permutations
	 * is the substring of the second string.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: s1 = "ab" s2 = "eidbaooo" Output: True Explanation: s2 contains one
	 * permutation of s1 ("ba"). Example 2:
	 * 
	 * Input:s1= "ab" s2 = "eidboaoo" Output: False
	 * 
	 * 
	 * Note:
	 * 
	 * The input strings only contain lower case letters. The length of both given
	 * strings is in range [1, 10,000].
	 */
	
	public static void main(String[] args) {
		System.out.println("Test Case1: " + checkInclusion("ab", "eidbaooo") );
		System.out.println("Test Case2: " + checkInclusion("ab", "eidboaoo") );
		System.out.println("Test Case3: " + checkInclusion("a", "a") );
		System.out.println("Test Case4: " + checkInclusion("ab", "d") );
	}

	/* Sliding Window Approach */
	public static boolean checkInclusion(String s1, String s2) {
		int[] cnt_arr = new int[26];
		int n = s1.length();
		int m = s2.length();
		if (n > m)
			return false;

		for (int i = 0; i < n; i++) {
			cnt_arr[s2.charAt(i) - 'a']++;
			cnt_arr[s1.charAt(i) - 'a']--;
		}

		for (int i = n; i < m; i++) {
			if (areAllZeros(cnt_arr))
				return true;
			cnt_arr[s2.charAt(i) - 'a']++;
			cnt_arr[s2.charAt(i - n) - 'a']--;
		}

		if (areAllZeros(cnt_arr))
			return true;

		return false;
	}

	public static boolean areAllZeros(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0)
				return false;
		}
		return true;
	}
}
