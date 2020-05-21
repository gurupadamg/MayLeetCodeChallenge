package com.mlcc.week3;

public class CountSquareSubmatriceswithAllOnes {

	/*
	 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

 

Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
Example 2:

Input: matrix = 
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation: 
There are 6 squares of side 1.  
There is 1 square of side 2. 
Total number of squares = 6 + 1 = 7.
 

Constraints:

1 <= arr.length <= 300
1 <= arr[0].length <= 300
0 <= arr[i][j] <= 1

	 */
	
	public static int min(int a, int b, int c){
        int result = 0;
        if(a <= b && a <= c){
            return a;
        }else if(b <= a && b <= c ){
            return b;
        }else if( c <= a && c <= b){
            return c;
        }
        return result;
    }
    public static int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = matrix[i][j];
                }else if(matrix[i][j] == 0){
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = min(dp[i][j-1], dp[i-1][j-1], dp[i-1][j]) + 1;
                }
            }
        }
        
        int sum = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                sum += dp[i][j];
            }
        }
        return sum;
    }
    
	public static void main(String[] args) {
		/**
		 * Example 1:
		 * 
		 * Input: matrix = [ [0,1,1,1], [1,1,1,1], [0,1,1,1] ] Output: 15 Explanation:
		 * There are 10 squares of side 1. There are 4 squares of side 2. There is 1
		 * square of side 3. Total number of squares = 10 + 4 + 1 = 15.
		 */
		int[][] testCase1 = new int[][] { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } };
		System.out.println("Test Case 1: " + countSquares(testCase1));

		/*
		 * Example 2:
		 * 
		 * Input: matrix = [ [1,0,1], [1,1,0], [1,1,0] ] Output: 7 Explanation: There
		 * are 6 squares of side 1. There is 1 square of side 2. Total number of squares
		 * = 6 + 1 = 7.
		 * 
		 */
		
		int[][] testCase2 = new int[][] { { 1,0,1 }, { 1,1,0 }, { 1,1,0 } };
		System.out.println("Test Case 2: " + countSquares(testCase2));

	}
}
