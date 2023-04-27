package week01;

import java.util.Scanner;

public class BOJ2979_repair {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// 주차요금
		int A = scanner.nextInt();
		int B = scanner.nextInt();
		int C = scanner.nextInt();

		int[] countArr = new int[100];
		int total = 0;

		for (int i = 0; i < 3; i++) {
			int startMinute = scanner.nextInt();
			int endMinute = scanner.nextInt();

			for (int j = startMinute; j < endMinute; j++) {
				countArr[j]++;
			}
		}
		scanner.close();

		for (int i = 0; i < 100; i++) {
			total += (countArr[i] == 1) ? countArr[i] * A : 0;
			total += (countArr[i] == 2) ? countArr[i] * B : 0;
			total += (countArr[i] == 3) ? countArr[i] * C : 0;
		}

		System.out.println(total);

	}
}

// BOJ 2979 삽질 과정
// https://k1m2njun.notion.site/BOJ-2979-5848e8e1d7184c8fa57c0a9495fedf03