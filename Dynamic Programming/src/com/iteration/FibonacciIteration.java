package com.iteration;

public class FibonacciIteration {
	
	public static void main(String a[]) {
		int n=0;
		
		int n1= 0, n2= 1, sum;
		
		if(n< 1) {
			System.out.println("please enter n > 0");
		}else {
			for(int i=0; i< n; i++) {
				sum= n1 + n2;
				
				System.out.print(sum + " ");
				
				n2= n1;
				n1= sum;
			}
		}
		
		
	}
}
