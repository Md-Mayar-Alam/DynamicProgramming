package com.dp.simple;

import java.util.StringTokenizer;

public class Test {
	public static void main(String a[]) {
		String numString="0\r\n" + 
				"1\r\n" + 
				"2\r\n" + 
				"3\r\n" + 
				"4\r\n" + 
				"5\r\n" + 
				"6\r\n" + 
				"7\r\n" + 
				"8\r\n" + 
				"9\r\n" + 
				"10\r\n" + 
				"11\r\n" + 
				"12\r\n" + 
				"13\r\n" + 
				"14\r\n" + 
				"15\r\n" + 
				"16\r\n" + 
				"17\r\n" + 
				"18\r\n" + 
				"19\r\n" + 
				"20\r\n" + 
				"21\r\n" + 
				"22\r\n" + 
				"23\r\n" + 
				"24\r\n" + 
				"25\r\n" + 
				"26\r\n" + 
				"27\r\n" + 
				"28\r\n" + 
				"29\r\n" + 
				"30\r\n" + 
				"31\r\n" + 
				"32\r\n" + 
				"33\r\n" + 
				"34\r\n" + 
				"35\r\n" + 
				"36\r\n" + 
				"37\r\n" + 
				"38\r\n" + 
				"39\r\n" + 
				"40\r\n" + 
				"41\r\n" + 
				"42\r\n" + 
				"43\r\n" + 
				"44\r\n" + 
				"45\r\n" + 
				"46\r\n" + 
				"47\r\n" + 
				"48\r\n" + 
				"49\r\n" + 
				"50\r\n";
				
		StringTokenizer st= new StringTokenizer(numString, "\r\n");
		
		while(st.hasMoreTokens()) {
			System.out.println("list.add("+st.nextToken()+".0);");
		}
	}
}
