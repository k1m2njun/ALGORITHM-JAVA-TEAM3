package seonghyeon.week06.problem11047;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cnt = sc.nextInt();
		int amount = sc.nextInt();

		int[] coins = new int[cnt];
		for (int i = 0; i < cnt; i++) {
			coins[i] = sc.nextInt();
		}

		int answer = 0;
		for (int i = coins.length - 1; i > 0; i--) {
			if (amount < coins[i])
				continue;

			answer += amount / coins[i];
			amount = amount % coins[i];
		}

		System.out.println(answer);
	}
}
