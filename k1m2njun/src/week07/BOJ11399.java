package week07;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ11399 {
	public static void main(String[] args) {

//		Scanner scanner = new Scanner(System.in);
//		int N = scanner.nextInt();
//		
//		int[] arr = new int[N];
//		
//		for(int i = 0; i < N; i++) {
//			arr[i] = scanner.nextInt();
//		}
//		Arrays.sort(arr);
//		
//		int total = 0;
//		for(int i = 0; i < arr.length; i++) {
//			int sum = 0;
//			for(int j = 0; j < i+1; j++) {
//				sum = sum + arr[j];
//			}
//			total += sum; // 1, 1+2,  
//		}
//		System.out.println(total);
			
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] list = new int[N];
		for(int i = 0; i < N; i++) {
			list[i] = sc.nextInt();
		}
		
		Arrays.sort(list);
		
		int sum = 0;
		int answer = 0;
		for(int i : list) {
			sum = (sum + i);
			answer += sum;
		}
		System.out.println(answer);
	}
}

//https://www.acmicpc.net/problem/11399
// 시간이 적게 걸리는 사람 순으로 돈을 뽑으면 최소 시간으로 할수 있다.

// 1 + 1+2 + 1+2+3 + 1+2+3+3 + 1+2+3+3+4
// 1 + 3 + 6 + 9 + 13
// 32