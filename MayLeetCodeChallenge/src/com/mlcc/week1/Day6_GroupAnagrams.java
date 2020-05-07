package com.mlcc.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day6_GroupAnagrams {

	/*
	 * Given an array of strings, group anagrams together.
	 * 
	 * Example:
	 * 
	 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
	 * 
	 * Output: [ ["ate","eat","tea"], ["nat","tan"], ["bat"] ]
	 * 
	 * Note: All inputs will be in lowercase. The order of your output does not
	 * matter.
	 * 
	 * 
	 * 
	 */

	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> dataMap = new HashMap<>();
		
		for(String s : strs) {
			char[] ch = s.toCharArray();
			Arrays.sort(ch);
			String key = new String(ch);
			if(dataMap.containsKey(key)) {
				dataMap.get(key).add(s);
			}else {
				List<String> list = new ArrayList<>();
				list.add(s);
				dataMap.put(key, list);
			}
		}

		List<List<String>> groupAnagrams = new ArrayList<>();
		
		for(String keys : dataMap.keySet()) {
			groupAnagrams.add(dataMap.get(keys));
		}
		return groupAnagrams;
	}

	public static void main(String[] args) {
		System.out.println("[");
		groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }).forEach(list -> {
			System.out.print("[");
			for(String s : list) {
				System.out.print(s + " ");
			}
			System.out.println("]");
		});
		System.out.println("]");
	}

}
