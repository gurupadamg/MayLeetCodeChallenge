package com.mlcc.week4;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {

	/*
	 * @Link:
	 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/537/week-
	 * 4-may-22nd-may-28th/3338/
	 * 
	 * Given two lists of closed intervals, each list of intervals is pairwise
	 * disjoint and in sorted order.
	 * 
	 * Return the intersection of these two interval lists.
	 * 
	 * (Formally, a closed interval [a, b] (with a <= b) denotes the set of real
	 * numbers x with a <= x <= b. The intersection of two closed intervals is a set
	 * of real numbers that is either empty, or can be represented as a closed
	 * interval. For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * 
	 * 
	 * Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
	 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
	 * 
	 * 
	 * Note:
	 * 
	 * 0 <= A.length < 1000 0 <= B.length < 1000 0 <= A[i].start, A[i].end,
	 * B[i].start, B[i].end < 10^9
	 * 
	 */

	public static int[][] intervalIntersection(int[][] A, int[][] B) {
		List<int[]> result = new ArrayList<>();

		int i = 0, j = 0;

		while (i < A.length && j < B.length) {
			int startIndex = Math.max(A[i][0], B[j][0]);
			int endIndex = Math.min(A[i][1], B[j][1]);

			if (startIndex <= endIndex) {
				result.add(new int[] { startIndex, endIndex });
			}

			if (A[i][1] < B[j][1]) {
				i++;
			} else {
				j++;
			}
		}

		int[][] res = new int[result.size()][2];
		int k = 0;
		for (int[] arr : result) {
			res[k] = arr;
			k++;
		}

		return res;
	}

	public static void main(String[] args) {
		/**
		 * Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
		 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
		 */
		System.out.println("Test Case 1: ");
		int[][] res = intervalIntersection(new int[][] { { 0, 2 }, { 5, 10 }, { 23, 23 }, { 24, 25 } },
				new int[][] { { 1, 2 }, { 5, 5 }, { 8, 10 }, { 15, 23 }, { 24, 24 }, { 25, 25 } });
		System.out.print("{");
		;
		for (int i = 0; i < res.length; i++) {
			System.out.print("{");
			;
			for (int j = 0; j < res[0].length; j++) {
				if (j == 0) {
					System.out.print(res[i][j]);
				} else {
					System.out.print("," + res[i][j]);
				}

			}
			System.out.print("}");
			;
			if (i != res.length - 1) {
				System.out.print(",");
				;
			}

		}

		System.out.print("}");
		;
	}
}
