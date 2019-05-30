package com.dp.simple;

import java.util.Arrays;

public class CoinExchange {

	public static void main(String[] args) {
		int coin[]= {1, 5, 6, 8};
		
		int total= 11;
		
		int T[][]= new int[coin.length][total + 1];
		
		for(int[] eachRowOfT : T) {
			Arrays.fill(eachRowOfT, Integer.MAX_VALUE-1);
		}

		// assigning 0 to all row first column
		for(int i=0; i< coin.length; i++) {
			T[i][0]= 0;
		}
		
		// assigning value to first row
		
		
		for(int i=0; i< coin.length; i++) {
			for(int j=1; j<= total; j++) {
				if(j > coin[i]) {
					
				}else {
					if(coin[i]%j == 0) {
						T[i][j]= j/(coin[i]);
					}else {
						T[i][j]= 0;
					}
				}
			}
		}
	}
}
