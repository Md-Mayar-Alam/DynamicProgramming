package com.dp.simple;

import java.util.Arrays;

public class WineSellingProblemDP {
	static int N=5;
	//static int p[]= {2, 3, 5, 1, 4};
	static int p[]= {1, 2, 3, 4, 5};
	
	static int cache[][]= new int[N][N];
	
	public static void main(String a[]) {
		
		for(int[] row: cache) {
			Arrays.fill(row, -1);
		}
		
		System.out.println("Profit1 "+ profit(1, 0, N-1));
		System.out.println("Profit2 "+ profit(0, N-1));
		System.out.println("Profit3 "+ profitCache(0, N-1));
	}

	private static int profit(int year, int be, int en) {
		// there are no more wines on the shelf
		  if (be > en)
		    return 0;
		  // try to sell the leftmost or the rightmost wine, recursively calculate the 
		  // answer and return the better one
		  return max(
		    profit(year+1, be+1, en) + year * p[be],
		    profit(year+1, be, en-1) + year * p[en]);
	}

	static int profit(int be, int en) {
		if (be > en)
			return 0;
		// (en-be+1) is the number of unsold wines
		int year = N - (en - be + 1) + 1; // as in the description above
		return max(profit(be + 1, en) + year * p[be], profit(be, en - 1) + year * p[en]);
	}
	
	static int profitCache(int be, int en) {
		if (be > en)
			return 0;
		// these two lines save the day
		if (cache[be][en] != -1)
			return cache[be][en];
		int year = N - (en - be + 1) + 1;
		// when calculating the new answer, don't forget to cache it
		return cache[be][en] = max(profit(be + 1, en) + year * p[be], profit(be, en - 1) + year * p[en]);
	}
	
	private static int max(int i, int j) {
		// TODO Auto-generated method stub
		return Math.max(i, j);
	}
}
