package seonghyeon.week07.problem2503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int cnt = Integer.parseInt(reader.readLine());

		int[] arr = new int[cnt];
		int[] strikes = new int[cnt];
		int[] balls = new int[cnt];

		for (int i = 0; i < cnt; i++) {
			String str = reader.readLine();

			arr[i] = Integer.parseInt(str.split(" ")[0]);
			strikes[i] = Integer.parseInt(str.split(" ")[1]);
			balls[i] = Integer.parseInt(str.split(" ")[2]);
		}

		int answer = 0;
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (j == i)
					continue;

				for (int k = 1; k <= 9; k++) {
					if (k == i || k == j)
						continue;

					boolean check = true;

					for (int l = 0; l < cnt; l++) {
						int strike = 0;
						int ball = 0;

						int firstNum = arr[l] / 100;
						int secondNum = arr[l] / 10 % 10;
						int lastNum = arr[l] % 10;

						if (firstNum == i)
							strike++;

						if (secondNum == j)
							strike++;

						if (lastNum == k)
							strike++;

						if (firstNum == j || firstNum == k)
							ball++;

						if (secondNum == i || secondNum == k)
							ball++;

						if (lastNum == i || lastNum == j)
							ball++;

						if (strike != strikes[l] || ball != balls[l]) {
							check = false;
							break;
						}
					}
					if (check)
						answer++;
				}
			}
		}

		System.out.println(answer);
	}
}
