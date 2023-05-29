package week06;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BOJ11047_repair {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int K = scanner.nextInt();
		
		Integer[] coins = new Integer[N];
		
		for(int i = 0; i < N; i++) {
			coins[i] = scanner.nextInt();
		}
		
		Arrays.sort(coins, Collections.reverseOrder());
		
		int i = 0;
		int sum = 0;
		while(K > 0) {
			int a = K/coins[i];
			K = K - coins[i] * a; 
			i++;
			sum+=a;
		}
		
		System.out.println(sum);
	}
}

//https://www.acmicpc.net/problem/11047