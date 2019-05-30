package com.dp.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class LongestIncreasingSubsequenceDP {
	
	public static void main(String args[]) {
	
		Integer arr[] = { 10, 22, 8, 9, 21, 41, 50, 60 };
		//int arr[]= {10, 2, 9, 3, 5, 4, 6, 8};
		int length= arr.length;
		
		lis(arr, length);
	}

	private static void lis(Integer[] arr, int length) {
		Integer lis[]= new Integer[length];
		
		Arrays.fill(lis, 1);
		
		ArrayList<Integer> longestList = null;
		
		TreeSet<Integer> set= new TreeSet<>();
		
		int highestCount=0;
		//int currentMax;
		int count;
		for(int i=1; i< length; i++) {
			//currentMax=Integer.MIN_VALUE;
			count= 0;
			for(int j=0; j< i; j++) {
				if(arr[i] > arr[j] && lis[i] < lis[j] + 1) {
					if(count == 0) {
						set.add(arr[j]);
						set.add(arr[i]);
						count++;
					}else {
						//check for the element is greater than all except last one
						int lesserCount=0;
						for(int k=0; k< set.size()-1; k++) {
							if(arr[j] < arr[k]) {
								lesserCount++;
							}
						}
						if(lesserCount == 0) {
							set.add(arr[j]);
						}
					}
					lis[i]= lis[j]+1;
				}
			}
			
			if(highestCount < set.size()) {
				longestList= new ArrayList<>(set);
				highestCount= set.size();
			}
			set.clear();
		}
		
		int max= Collections.max(Arrays.asList(lis));
		
		System.out.println("Max is "+max);
		
		if(max== longestList.size()) {
			//no problem
		}else {
			List<Integer> lisList=Arrays.asList(lis);
			int index= lisList.indexOf(max);
			
			List<Integer> arrList= Arrays.asList(arr);
			
			
		}
		
		Collections.sort(longestList);
		Iterator<Integer> it=longestList.iterator();
		while(it.hasNext()) {
			System.out.print(it.next()+ " ");
		}
		
		/*int start=1;
		
		for(int i=0; i< length; i++) {
			if(lis[i] == start) {
				System.out.print(arr[i]+" ");
				start++;
			}
		}*/
	}
}
