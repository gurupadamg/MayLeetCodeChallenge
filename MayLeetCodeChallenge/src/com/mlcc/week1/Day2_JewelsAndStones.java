package com.mlcc.week1;

import java.util.HashSet;
import java.util.Set;

public class Day2_JewelsAndStones {

	/*
	 * You're given strings J representing the types of stones that are jewels, and
	 * S representing the stones you have. Each character in S is a type of stone
	 * you have. You want to know how many of the stones you have are also jewels.
	 * 
	 * The letters in J are guaranteed distinct, and all characters in J and S are
	 * letters. Letters are case sensitive, so "a" is considered a different type of
	 * stone from "A".
	 * 
	 * 
	 * Example 1: Input: J = "aA", S = "aAAbbbb" Output: 3
	 * 
	 * Example 2: Input: J = "z", S = "ZZ" Output: 0
	 * 
	 * Note: S and J will consist of letters and have length at most 50. The
	 * characters in J are distinc
	 */

	public static int numJewelsInStones(String J, String S) {
		int count = 0;
		
		// Second Approach using Set
		Set<Character> jewels = new HashSet<Character>();
		for(Character ch : J.toCharArray()) {
			jewels.add(ch);
			
		}
		for(Character s : S.toCharArray()) {
			if(jewels.contains(s)) {
				count++;
			}
		}
		/*
		 * First Approach
		 */
	/*	for (char c : S.toCharArray()) {
			if (J.contains(c + "")) {
				count++;
			}
		} */
		 
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println("Test Case1::"+ numJewelsInStones("aA", "aAAbbbb"));
		System.out.println("Test Case2::"+ numJewelsInStones("z", "ZZ"));
		System.out.println("Test Case3::"+ numJewelsInStones("z", ""));
		System.out.println("Test Case4::"+ numJewelsInStones("", "ABC"));
	}
}
