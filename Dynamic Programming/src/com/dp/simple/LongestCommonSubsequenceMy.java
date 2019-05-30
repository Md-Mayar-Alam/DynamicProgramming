package com.dp.simple;

public class LongestCommonSubsequenceMy {
	public static void main(String args[]) {
		String X= "AAEBCD";
		String Y= "AABFCD";
		
		int m=X.length(), n=Y.length();
		
		int T[][]= new int[m+1][n+1];
		
		LCS_Array(X, Y, m, n, T);
		
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				System.out.print(T[i][j] + " ");
			}
			System.out.println();
		}
		
		String longestSeq= LCS_Seq(X, Y, m, n, T);
		System.out.println("Longest String "+longestSeq);
	}

	private static String LCS_Seq(String X, String Y, int m, int n, int[][] T) {
		if(m==0 || n==0) {
			return new String();
		}
		
		//means last character are same
		if(X.charAt(m-1) == Y.charAt(n-1)) {
			return LCS_Seq(X, Y, m-1, n-1, T) + X.charAt(m-1);
		}
		
		//last character not same
		
		//check from T[][] table now
		
		if(T[m-1][n] > T[m][n-1]) {	//means upper value is greater
			return LCS_Seq(X, Y, m-1, n, T);
		}else {	//means left value is greater
			return LCS_Seq(X, Y, m, n-1, T);
		}
	}

	private static void LCS_Array(String X, String Y, int m, int n, int[][] T) {
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
