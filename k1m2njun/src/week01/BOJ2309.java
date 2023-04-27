package week01;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2309 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int[] arr = new int[9];

		int sum = 0;

		for (int i = 0; i < 9; i++) {
			arr[i] = scanner.nextInt();
			sum += arr[i];
		}
		scanner.close();

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if ((arr[i] + arr[j] + 100) == sum) {
					arr[i] = 0;
					arr[j] = 0;
					Arrays.sort(arr);

					for (int k = 2; k < arr.length; k++) {
						System.out.println(arr[k]);
					}
					return;
				}
			}
		}
	}
}