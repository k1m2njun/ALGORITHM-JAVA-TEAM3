package seonghyeon.week07.problem11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int cnt = Integer.parseInt(reader.readLine());

		int[] arr = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		Arrays.sort(arr);

		int sum = 0;
		int prev = 0;
		for (int i = 0; i < arr.length; i++) {
			prev += arr[i];
			sum += prev;
		}

		System.out.println(sum);
	}
}
