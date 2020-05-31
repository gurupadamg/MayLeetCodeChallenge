package com.mlcc.week4;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

	/*
	 * Given a binary array, find the maximum length of a contiguous subarray with
	 * equal number of 0 and 1.
	 * 
	 * Example 1: Input: [0,1] Output: 2 Explanation: [0, 1] is the longest
	 * contiguous subarray with equal number of 0 and 1. Example 2: Input: [0,1,0]
	 * Output: 2 Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray
	 * with equal number of 0 and 1. Note: The length of the given binary array will
	 * not exceed 50,000.
	 */
	
	public static int findMaxLength(int[] nums) {
        int sum = 0, max = 0;
        Map<Integer,Integer> dataMap = new HashMap<>();
        
        for(int i =0; i < nums.length; i++){
            if(nums[i] == 0){
                sum = sum - 1;
            }else{
                sum = sum + 1;
                
            }
            
            if(!dataMap.containsKey(sum)){
                dataMap.put(sum, i);
            }else{
                max = Math.max(max, i - dataMap.get(sum));
            }
            
            if(sum == 0){
                max = Math.max(max, i + 1);
            }
        }
        
        
        
        return max;
 
	}
	
	public static void main(String[] args) {
		System.out.println("Test Case1: " + findMaxLength(new int[] {0,1}) );
		System.out.println("Test Case2: " + findMaxLength(new int[] {0,1,0}) );
	}
}
