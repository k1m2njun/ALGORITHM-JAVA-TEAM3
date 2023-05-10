package seonghyeon.week03.practice9375;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cnt = sc.nextInt();


		for (int i = 0; i < cnt; i++) {
			int clothesCnt = sc.nextInt();

			Map<String, Integer> map = new HashMap<>();

			for (int j = 0; j < clothesCnt; j++) {
				sc.next();

				String category = sc.next();

				if (map.containsKey(category)) {
					map.put(category, map.get(category) + 1);
				} else {
					map.put(category, 1);
				}
			}

			int answer = 1;

			for (int qty : map.values()) {
				answer *= (qty + 1);
			}

			System.out.println(answer - 1);
		}
	}
}
