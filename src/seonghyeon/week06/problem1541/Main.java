package seonghyeon.week06.problem1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String str = reader.readLine();

		String[] substractions = str.split("-");

		int answer = 0;
		for (int i = 0; i < substractions.length; i++) {
			String[] additions = substractions[i].split("\\+");

			int sum = 0;
			for (int j = 0; j < additions.length; j++) {
				sum += Integer.parseInt(additions[j]);
			}

			if (i == 0) {
				answer += sum;
				continue;
			}

			answer -= sum;
		}

		System.out.println(answer);
	}
}
