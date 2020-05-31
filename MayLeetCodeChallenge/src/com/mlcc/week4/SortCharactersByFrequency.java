package com.mlcc.week4;

import java.util.PriorityQueue;

public class SortCharactersByFrequency {

	/*
	 * 
	 * 
	 * Given a string, sort it in decreasing order based on the frequency of
	 * characters.
	 * 
	 * Example 1:
	 * 
	 * Input: "tree"
	 * 
	 * Output: "eert"
	 * 
	 * Explanation: 'e' appears twice while 'r' and 't' both appear once. So 'e'
	 * must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
	 * Example 2:
	 * 
	 * Input: "cccaaa"
	 * 
	 * Output: "cccaaa"
	 * 
	 * Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is also a valid
	 * answer. Note that "cacaca" is incorrect, as the same characters must be
	 * together. Example 3:
	 * 
	 * Input: "Aabb"
	 * 
	 * Output: "bbAa"
	 * 
	 * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect. Note
	 * that 'A' and 'a' are treated as two different characters.
	 */
	
	  public static String frequencySort(String s) {
	        if(s == null || s.length() == 0) return s; 
	        int[] arr = new int[256];
	        for(char c: s.toCharArray()){
	            arr[c]++;
	        }
	        PriorityQueue<Character> pq = new PriorityQueue<>( (a, b) -> arr[b] - arr[a]);
	        for(int i =0; i<256;i++){
	            pq.offer((char)i);
	        }
	        StringBuilder sb = new StringBuilder();
	        while(!pq.isEmpty()){
	            Character c = pq.poll();
	            for(int i = 0; i< arr[c]; i++){
	                sb.append(c);
	            }
	        }
	        return sb.toString();
	    }
	  
	  public static void main(String[] args) {
		System.out.println("Test Case 1: " + frequencySort("Aabb"));
	}
}
