package kmc;

import java.util.Scanner;

public class Boj24416 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(fib(n));
		System.out.println(fibonacci(n));
		
		
	}
	
	public static int fib(int n) {
	    if (n == 1 || n == 2) {
	    	return 1;
	    } else {
	    	return (fib(n - 1) + fib(n - 2));
	    }
	}
	
	public static int fibonacci(int n) {
		int[] f = new int[n];
	    f[1] = f[2];
	    f[2] = 1;
	    
	    for (int i = 3; i < n; i++) {
	    	f[i] = f[i - 1] + f[i - 2];
	    }
	        
	    return f[n-1];
	}

}
