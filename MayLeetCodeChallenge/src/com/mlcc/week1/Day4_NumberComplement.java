package com.mlcc.week1;

public class Day4_NumberComplement {

	/*
	 * Given a positive integer, output its complement number. The complement
	 * strategy is to flip the bits of its binary representation.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: 5 Output: 2 Explanation: The binary representation of 5 is 101 (no
	 * leading zero bits), and its complement is 010. So you need to output 2.
	 * 
	 * 
	 * Example 2:
	 * 
	 * Input: 1 Output: 0 Explanation: The binary representation of 1 is 1 (no
	 * leading zero bits), and its complement is 0. So you need to output 0.
	 * 
	 */

	
	public static int findComplement(int num) {
		int length = (int) (Math.log(num) / Math.log(2)) + 1; 
		System.out.println("Lengh: " + length + " for a numbe" + num);
		int mask = (1 << length) - 1;
		return num ^ mask;
	}
	
	public static void main(String[] args) {
		System.out.println("Test case 1 : " + findComplement(5));
		System.out.println("Test case 2 : " + findComplement(1));
		System.out.println("Test case 3 : " + findComplement(0));
		System.out.println("Test case 4 : " + findComplement(2));
		
		System.out.println((int)(Math.log(1) / Math.log(2)));
	}

}
