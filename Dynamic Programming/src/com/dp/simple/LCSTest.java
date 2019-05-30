package com.dp.simple;

public class LCSTest {
	
	public static void main(String ar[]) {
		
		String X= "ABEC", Y= "ABDEC";
		
		int m=X.length(), n=Y.length();
		
		int length= LCS_Seq_Len(X, Y, m, n);
		System.out.println(length);
		
		int T[][]= new int[m+1][n+1];
		
		LCS_Str_ArrFill(X, Y, m, n, T);
		
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				System.out.print(T[i][j] + " ");
			}
			System.out.println();
		}
		
		String seqj= LCS_Str_Seq(X, Y, m, n, T);
		
		System.out.println(seqj);
	}

	private static String LCS_Str_Seq(String X, String Y, int m, int n, int[][] T) {
		
		if(m==0 || n==0) {
			return new String();
		}
		
		if(X.charAt(m-1) == Y.charAt(n-1)) {
			return LCS_Str_Seq(X, Y, m-1, n-1, T) + X.charAt(m-1);
		}
		
		if(T[m-1][n] > T[m][n-1]) {
			return LCS_Str_Seq(X, Y, m-1, n, T);
		}else {
			return LCS_Str_Seq(X, Y, m, n-1, T);
		}
	}

	private static void LCS_Str_ArrFill(String X, String Y, int m, int n, int[][] T) {
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

	private static int LCS_Seq_Len(String X, String Y, int m, int n) {
		if(m==0 || n==0) {
			return 0;
		}
		
		if(X.charAt(m-1) == Y.charAt(n-1)) {
			return LCS_Seq_Len(X, Y, m-1, n-1) + 1;
		}
		
		return Integer.max(LCS_Seq_Len(X, Y, m-1, n), LCS_Seq_Len(X, Y, m, n-1));
	}
}
