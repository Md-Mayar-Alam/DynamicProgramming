package com.dp.memo;

import java.util.HashMap;

public class LongestCommonSubsequenceLength {
	
	public static void main(String args[]) {
		long startTime = System.nanoTime(); 
		
		/*String string1= "CDABEGAUNGA";
		String string2= "ABHIDABUNGA";*/
		
		String string1 = "ABCBDAB", string2 = "BDCABAS";
		
		int string1Length= string1.length();
		int string2Length= string2.length();
		
		HashMap<String, Integer> cacheMap= new HashMap<>();
		
		int longestLenSubString= LCSString(string1, string2, string1Length, string2Length, cacheMap);
		
		System.out.println("Longest Length "+ longestLenSubString);
		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " ns"); 
	}

	private static int LCSString(String string1, String string2, int string1Length, 
			int string2Length, HashMap<String, Integer> cacheMap) {

		if(string1Length == 0 || string2Length == 0) {
			return 0;
		}
		
		String key= string1Length + "|" + string2Length;
		
		if(!cacheMap.containsKey(key)) {
			if(string1.charAt(string1Length-1) == string2.charAt(string2Length-1)) {
				int value= LCSString(string1, string2, string1Length-1, string2Length-1, cacheMap) + 1;
				cacheMap.put(key, value);
				return value;
			}
			
			int value= Integer.max(LCSString(string1, string2, string1Length-1, string2Length, cacheMap),
					LCSString(string1, string2, string1Length, string2Length-1, cacheMap));
			cacheMap.put(key, value);
			return value;
		}
		return cacheMap.get(key);
	}
}
