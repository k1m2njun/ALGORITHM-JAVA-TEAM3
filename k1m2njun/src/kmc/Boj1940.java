package kmc;

import java.util.Arrays;
import java.util.Scanner;

public class Boj1940 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int count = 0;
		int start = 0;
		int end = N - 1;
		
		while(start < end) {
			if(arr[start] + arr[end] < M) {
				start++;
			} else if (arr[start] + arr[end] > M) {
				end--;
			} else if (arr[start] + arr[end] == M) {
				count++;
				start++;
				end--;
			}
		}
		
		System.out.println(count);
	}
}
