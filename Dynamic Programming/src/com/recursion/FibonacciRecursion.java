package com.recursion;

public class FibonacciRecursion {
	
	public static void main(String a[]) {
		int n=33;
		
		if(n < 1) {
			System.out.println("please enter n > 0");
		}else {
			for(int i=1; i <= n; i++ ) {
				System.out.print(fib(i) + " ");
			}
		}
		
		System.out.println("ok");
	}

	private static int fib(int n) {
		if(n == 0 || n == 1) {
			return n;
		}
		
		return fib(n-1) + fib(n-2);
	}
}
