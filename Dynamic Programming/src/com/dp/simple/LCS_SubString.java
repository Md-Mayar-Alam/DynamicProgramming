package com.dp.simple;

public class LCS_SubString {
	public static void main(String[] args) {
		String X= "ABC", Y= "ADBCE";
		
		int m= X.length(), n=Y.length();
		
		int T[][]= new int[m+1][n+1];
		
		String subStr= LCS_Sub(X, Y, m, n);
	}

	private static String LCS_Sub(String X, String Y, int m, int n) {
		
		return null;
	}
}
