package week02;

import java.util.Scanner;

public class BOJ2559 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int K = scanner.nextInt();
		int[] arr = new int[N];
		int[] sums = new int[N-K+1];
		int sum = 0;
		
		for(int i = 0; i < N; i++) {
			arr[i] = scanner.nextInt();
		}
		
		for(int i = 0; i < N - K + 1; i++) {
			for(int j = i; j < i + K; j++) {
				sum += arr[j];
			}
			sums[i] = sum;
			sum = 0;
		}
		
		int result = sums[0];
		for(int i = 0; i < sums.length; i++) {
			result = (result > sums[i]) ? result : sums[i];
		}
		
		System.out.println(result);
	}
}

// https://www.acmicpc.net/problem/2559