package com.dp.simple;

public class LongestPallindromicSeqLength {
	
	public static void main(String ar[]) {
		String X= "ABCDDCB";

		int m=0, n=X.length();
		
		int size= findLongPalSeq(X,m, n-1);
		System.out.println(size);
	}

	private static int findLongPalSeq(String X, int m, int n) {
		if(m > n) {
			return 0;
		}
		
		if(m==n) {
			return 1;
		}
		
		if(X.charAt(m) == X.charAt(n)) {
			return findLongPalSeq(X, m+1 , n-1) + 2;
		}
		
		return Integer.max(findLongPalSeq(X, m+1, n), findLongPalSeq(X,m, n-1));
	}
}
