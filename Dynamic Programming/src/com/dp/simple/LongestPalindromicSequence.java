package com.dp.simple;

public class LongestPalindromicSequence {
	
	public static void main(String a[]) {
		String X= "ABCDDCB";
		
		String Y= new StringBuilder(X).reverse().toString();
		System.out.println(Y);
		
		int m=X.length(), n=Y.length();
		
		int T[][]= new int[m+1][n+1];
		
		LPS_ArrayFill(X, Y, m, n, T);
		
		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				System.out.print(T[i][j] + " ");
			}
			System.out.println();
		}
		
		String lonSeq= findLongPalSeq(X, Y, m, n, T);
		System.out.println(lonSeq);
	}

	private static String findLongPalSeq(String X, String Y, int m, int n, int[][] T) {
		if(m==0 || n==0) {
			return new String();
		}
		
		if(X.charAt(m-1) == Y.charAt(n-1)) {
			return findLongPalSeq(X, Y, m-1, n-1, T) + X.charAt(m-1);
		}
		
		if(T[m-1][n] > T[m][n-1]) {
			return findLongPalSeq(X, Y, m-1, n, T);
		}else {
			return findLongPalSeq(X, Y, m, n-1, T);
		}
	}

	private static void LPS_ArrayFill(String X, String Y, int m, int n, int[][] T) {
		
		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				if(X.charAt(i-1) == Y.charAt(j-1)) {
					T[i][j]= T[i-1][j-1] + 1;
				}else {
					T[i][j]= Integer.max(T[i-1][j], T[i][j-1]);
				}
			}
		}
	}
}
