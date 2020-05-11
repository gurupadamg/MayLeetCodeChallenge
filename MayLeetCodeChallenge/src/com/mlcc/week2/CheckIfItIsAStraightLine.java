package com.mlcc.week2;

public class CheckIfItIsAStraightLine {

	/*
	 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y]
	 * represents the coordinate of a point. Check if these points make a straight
	 * line in the XY plane.
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * 
	 * 
	 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]] Output: true
	 * Example 2:
	 * 
	 * 
	 * 
	 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]] Output: false
	 * 
	 * 
	 * Constraints:
	 * 
	 * 2 <= coordinates.length <= 1000 coordinates[i].length == 2 -10^4 <=
	 * coordinates[i][0], coordinates[i][1] <= 10^4 coordinates contains no
	 * duplicate point.
	 */

	/* Using Slope Approach */
	public static boolean checkStraightLine(int[][] coordinates) {

		double slope = (double) (coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]);

		for (int i = 1; i < coordinates.length - 1; i++) {

			double slope2 = (double) (coordinates[i + 1][1] - coordinates[i][1])
					/ (coordinates[i + 1][0] - coordinates[i][0]);
			if (slope != slope2) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println("Test Case 1: "
				+ checkStraightLine(new int[][] { { 1, 1 }, { 2, 2 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 7, 7 } }));
		System.out.println("Test Case 2: "
				+ checkStraightLine(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 6, 7 } }));
		System.out.println("Test case 4: " + checkStraightLine(new int[][] { { -4, -3 }, { 1, 0 }, { 3, -1 } }));
		System.out.println("Test Case 3: " + checkStraightLine(new int[][] { { 1, 2 }, { 2, 3 } }));
	}

}
