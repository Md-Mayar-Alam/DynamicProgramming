package com.dp.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class FactorialDP {
	
	static HashMap<Long, Long> cache= new HashMap<>(); 
	
	public static void main(String a[]) {
		Scanner sc= new Scanner(System.in);
		
		/*int noOfTestCases= sc.nextInt();
		Long N[]= new Long[noOfTestCases];
		for(int i=0; i< noOfTestCases; i++) {
			N[i]= sc.nextLong();
		}*/
		
		int noOfTestCases= 6;
		//Long N[]= {0L, 1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L};
		
		//ArrayList<Long> list = new ArrayList<Long>(Arrays.asList(N));
		
		ArrayList<Long> list = new ArrayList<>();
		list.add(0L);
		list.add(1L);
		list.add(2L);
		list.add(3L);
		list.add(4L);
		list.add(5L);
		list.add(6L);
		list.add(7L);
		list.add(8L);
		list.add(9L);
		list.add(10L);
		list.add(11L);
		list.add(12L);
		list.add(13L);
		/*list.add(14L);
		list.add(15L);
		list.add(16L);
		list.add(17L);
		list.add(18L);
		list.add(19L);
		list.add(20L);
		list.add(21L);
		list.add(22L);
		list.add(23L);
		list.add(24L);*/
		/*list.add(25L);
		list.add(26L);
		list.add(27L);
		list.add(28L);
		list.add(29L);
		list.add(30L);
		list.add(31L);
		list.add(32L);
		list.add(33L);
		list.add(34L);
		list.add(35L);
		list.add(36L);
		list.add(37L);
		list.add(38L);
		list.add(39L);
		list.add(40L);
		list.add(41L);
		list.add(42L);
		list.add(43L);
		list.add(44L);
		list.add(45L);
		list.add(46L);
		list.add(47L);
		list.add(48L);
		list.add(49L);
		list.add(50L);*/
		
		for(int i=0; i< list.size(); i++) {
			System.out.println(factorial(list.get(i)));
		}
	}
	
	private static long factorial(long currentNumber) {
		if(currentNumber == 0) {
			return 1;
		}
		
		if(cache.containsKey(currentNumber)) {
			return cache.get(currentNumber);
		}
		
		Long value= currentNumber * factorial(currentNumber-1);
		
		StringBuffer longValueString= new StringBuffer(Long.toString(value));
		
		StringBuffer reversedLongValueString= longValueString.reverse();
		
		if(reversedLongValueString.length() > 9) {
			String subReversedLongValueString= reversedLongValueString.substring(0, 9);
			
			String subLongValueString= new StringBuffer(subReversedLongValueString).reverse().toString();
			
			Long finalValue= Long.parseLong(subLongValueString);
			cache.put(currentNumber, finalValue);
			return finalValue;
		}else {
			cache.put(currentNumber, value);
		}
		
		
		/*Long reversedLong= Long.reverse(value);
		String reversedString= Long.toString(reversedLong);
		
		if(reversedString.length() > 9) {
			String subReversedString= reversedString.substring(0, 9);
			Long finalRevLong= Long.parseLong(subReversedString);
			Long finalLong= Long.reverse(finalRevLong);
			cache.put(currentNumber, finalLong);
		}else {
			
		}*/
		
		return  value;
	}
}
