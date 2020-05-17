package com.mlcc.week3;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsinaString {

	/*
	 * Given a string s and a non-empty string p, find all the start indices of p's
	 * anagrams in s.
	 * 
	 * Strings consists of lowercase English letters only and the length of both
	 * strings s and p will not be larger than 20,100.
	 * 
	 * The order of output does not matter.
	 * 
	 * Example 1:
	 * 
	 * Input: s: "cbaebabacd" p: "abc"
	 * 
	 * Output: [0, 6]
	 * 
	 * Explanation: The substring with start index = 0 is "cba", which is an anagram
	 * of "abc". The substring with start index = 6 is "bac", which is an anagram of
	 * "abc". Example 2:
	 * 
	 * Input: s: "abab" p: "ab"
	 * 
	 * Output: [0, 1, 2]
	 * 
	 * Explanation: The substring with start index = 0 is "ab", which is an anagram
	 * of "ab". The substring with start index = 1 is "ba", which is an anagram of
	 * "ab". The substring with start index = 2 is "ab", which is an anagram of
	 * "ab".
	 */

	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<Integer>();
		int[] cnt_arr = new int[26]; // String contains only a-z.
		int m = s.length(), n = p.length();

		if (n > m)
			return result;

		for (int i = 0; i < n; i++) {
			cnt_arr[s.charAt(i) - 'a']++;
			cnt_arr[p.charAt(i) - 'a']--;
		}
		
		
		/**
		 * Pattern: Sliding Window Pattern Approach
		 * 
		 * Reference:
		 * https://www.geeksforgeeks.org/window-sliding-technique/
		 * https://www.youtube.com/watch?v=__guhvzO540
		 */
		for (int j = n; j < m; j++) {
			// Check Anagram Found and add start index of anagram.
			if(areAllZeros(cnt_arr)) {
				result.add(j - n);
			}
			cnt_arr[s.charAt(j) - 'a']++;
			cnt_arr[s.charAt(j - n) - 'a']--;
		}
		
		// Check Anagram Found and add start index of anagram.
		if(areAllZeros(cnt_arr)) {
			result.add(m -n);
		}
		return result;
	}

	public static boolean areAllZeros(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0)
				return false;
		}
		return true;
	}
	
	

	public static void main(String[] args) {
		System.out.println("Test Case1: " + findAnagrams("cbaebabacd", "cba"));
		System.out.println("Test Case2: " + findAnagrams("abab", "ab"));
		System.out.println("Test Case3: " + findAnagrams("a", "a"));
		System.out.println("Test Case4: " + findAnagrams("aaaaaaaaa", "a"));
		System.out.println("Test Case5: " + findAnagrams("aaaaaaaaa", "ab"));
	}
}
