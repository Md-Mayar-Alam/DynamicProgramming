package com.dp.simple;

public class LongestCommonSubsequenceLength {

	// main function
	public static void main(String[] args)
	{
		long startTime = System.nanoTime();
		
		String string1 = "ABCBDAB", string2 = "BDCABAS";
		
		int string1Length= string1.length();
		int string2Length= string2.length();
		
		int longestStringLength= LCSLength(string1, string2, string1Length, string2Length);
		System.out.println("Longest Length is "+longestStringLength);
		
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " ns"); 
	}

	private static int LCSLength(String string1, String string2, int string1Length, int string2Length) {
		
		if(string1Length == 0 || string2Length == 0) {
			return 0;
		}
		
		if(string1.charAt(string1Length -1) == string2.charAt(string2Length -1)) {
			//means both character are same
			return LCSLength(string1, string2, string1Length-1, string2Length-1) + 1;
		}
		
		return Integer.max(LCSLength(string1, string2, string1Length-1, string2Length),
							LCSLength(string1, string2, string1Length, string2Length-1));
	}
}