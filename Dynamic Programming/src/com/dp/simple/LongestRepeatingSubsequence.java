package com.dp.simple;

public class LongestRepeatingSubsequence {

	public static void main(String args[]) {
		String X= "ATACTCGGA";
		int m= X.length();
		int n=m;
		int T[][]= new int[m+1][n+1];
		fillArray(X, m, n, T);
		
		String seq= LRS_Seq(X, m, n, T);
		System.out.println(seq);
	}

	private static String LRS_Seq(String X, int m, int n, int[][] T) {
		
		if(m==0 || n==0 ) {
			return new String();
		}
		
		if(X.charAt(m-1) == X.charAt(n-1) && m!=n) {
			return LRS_Seq(X, m-1, n-1, T) + X.charAt(m-1);
		}
		
		if(T[m-1][n] > T[m][n-1]) {
			return LRS_Seq(X, m-1, n, T);
		}else {
			return LRS_Seq(X, m, n-1, T);
		}
	}

	private static void fillArray(String X, int m, int n, int[][] T) {
		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				if(X.charAt(i-1) == X.charAt(j-1) && i!=j) {
					T[i][j]= T[i-1][j-1] + 1;
				}else {
					T[i][j]= Integer.max(T[i-1][j], T[i][j-1]);
				}
			}
		}
	}
}
