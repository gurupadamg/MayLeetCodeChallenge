package com.mlcc.week1;

import java.util.LinkedHashMap;
import java.util.Map;

public class Day5_FirstUniqueCharacterInAString {

	/*
	 * Given a string, find the first non-repeating character in it and return it's
	 * index. If it doesn't exist, return -1.
	 * 
	 * Examples:
	 * 
	 * s = "leetcode" return 0.
	 * 
	 * s = "loveleetcode", return 2. Note: You may assume the string contain only
	 * lowercase letters.
	 */

	public static int firstUniqChar(String s) {
		/*
		 * Note: You may assume the string contain only lower case letters.
		 * So Using array size with 26. 
		 */
		int[] charCount = new int[26];
		for(char c : s.toCharArray()) {
			charCount[c - 'a'] += 1;
		}
		
		/*
		for(int i = 0; i< s.length(); i++){
            if(charCount[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }*/
		
		for(char c : s.toCharArray()) {
			if(charCount[c - 'a'] == 1) {
				return s.indexOf(c);
			}
		} 
		return -1;
	}
	public static int firstUniqChar2(String s) {
		/* Second Approach - Using HashMap */
		/*
		 * Time Complexity is O(n + n) Space Complexity is O(n)
		 */
		Map<Character, Integer> dataMap = new LinkedHashMap<>();
		for (char c : s.toCharArray()) {
			dataMap.put(c, dataMap.getOrDefault(c, 0) + 1);
		}

		for (Map.Entry<Character, Integer> dataEntrySet : dataMap.entrySet()) {
			if (dataEntrySet.getValue() == 1) {
				return s.indexOf(dataEntrySet.getKey());
			}
		}
		return -1;
	}

	public static int firstUniqChar1(String s) {

		/* First Approach - Brute Force */
		/*
		 * Time Complexity is o(n^2) Space Complexity is (1)
		 */
		for (int i = 0; i < s.length(); i++) {
			boolean isUniqChar = true;
			for (int j = 0; j < s.length(); j++) {
				if (i != j && s.charAt(i) == s.charAt(j)) {
					isUniqChar = false;
					break;
				}
			}
			if (isUniqChar) {
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		System.out.println("Test Case 1: " + firstUniqChar("leetcode")); // l -> index is "0"
		System.out.println("Test Case 1: " + firstUniqChar("loveleetcode"));// v -> index is "2"
		System.out.println("Test Case 1: " + firstUniqChar("aabbccddeeff"));// -1
		System.out.println("Test Case 1: " + firstUniqChar("laabbccddmeeffxyzxyzpqrssrpqlm"));// -1
		System.out.println("Test Case 1: " + firstUniqChar("laabbccddmeeffxyzxyzpqrssrpqlmg"));// 30
	}
}
