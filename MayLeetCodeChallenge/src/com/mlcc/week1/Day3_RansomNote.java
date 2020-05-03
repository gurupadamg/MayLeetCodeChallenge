package com.mlcc.week1;

public class Day3_RansomNote {

	/*
	 * Given an arbitrary ransom note string and another string containing letters
	 * from all the magazines, write a function that will return true if the ransom
	 * note can be constructed from the magazines ; otherwise, it will return false.
	 * 
	 * Each letter in the magazine string can only be used once in your ransom note.
	 * 
	 * Note: You may assume that both strings contain only lowercase letters.
	 * 
	 * canConstruct("a", "b") -> false canConstruct("aa", "ab") -> false
	 * canConstruct("aa", "aab") -> true
	 */
	public static boolean canConstruct(String ransomNote, String magazine) {
		int[] ransomCount = new int[26];
		
		for(char c : magazine.toCharArray()) {
			++ransomCount[c - 'a'];
		}
		
		for(char c : ransomNote.toCharArray()) {
			if(--ransomCount[c - 'a'] < 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println("Test Case1: " + canConstruct("a", "b"));
		System.out.println("Test Case2: " + canConstruct("aa", "ab"));
		System.out.println("Test Case3: " + canConstruct("aa", "baa"));
	}

}
