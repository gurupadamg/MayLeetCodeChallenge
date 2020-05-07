package com.mlcc.week1;

import java.util.HashMap;
import java.util.Map;

public class Day7_CountingElements {
	
	/*
	 * Given Integer Array, count element x such that x + 1 also in arr.
	 * 
	 * Input: {1,2,3}
	 * Output: 2
	 *  x -> x + 1 
	 *  count - 1 ( for 1 - we have 2)
	 *  count - 2 ( for 2 - we have 3)
	 */
	public static int countElements(int[] arr) {
		Map<Integer, Integer> dataMap = new HashMap<>();
		for(int num : arr) {
			dataMap.put(num, dataMap.getOrDefault(num, 0) + 1);
		}
		int ans = 0;
		for(int i : dataMap.keySet()) {
			if(dataMap.containsKey( i + 1)) {
				ans = ans + dataMap.get(i + 1);
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		System.out.println("Test Case1 : " + countElements(new int[] {1, 2, 3})); // 2
		System.out.println("Test Case1 : " + countElements(new int[] {1, 2, 2, 2, 2,3,3})); // 6
	}

}
