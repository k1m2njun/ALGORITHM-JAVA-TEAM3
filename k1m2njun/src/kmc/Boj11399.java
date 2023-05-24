package kmc;

import java.util.Arrays;
import java.util.Scanner;

public class Boj11399 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = scanner.nextInt();
		}
		Arrays.sort(arr);
		
		
		int total = 0;
		
		for(int i = 0; i < arr.length; i++) {
			int sum = 0;
			for(int j = 0; j < i+1; j++) {
				sum = sum + arr[j];
			}
			total += sum; // 1, 1+2,  
		}
		System.out.println(total);
	}
}
