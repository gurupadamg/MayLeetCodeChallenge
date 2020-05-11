package com.mlcc.week1;

public class GCD {
	
	static int gcd(int a, int b) {
		if(a == 0)
			return b;
		return gcd(b % a, a);
	}

	static int findGCD(int[] arr) {
		int result = arr[0];
		for(int i = 1; i< arr.length; i++) {
			result = gcd(arr[i], result);
			if(result == 1) {
				return 1;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(gcd(10,20));
		System.out.println(findGCD(new int[] {84,90,120}));
		System.out.println(gcd(84,90));
		System.out.println(findGCD(new int[] {10,20}));
	}
}

