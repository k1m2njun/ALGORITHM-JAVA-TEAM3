package seonghyeon.week04.privacy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		int[] value = solution("2022.05.19", new String[] {"A 6", "B 12", "C 3"},
			new String[] {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});

		Arrays.stream(value).forEach(System.out::println);

		value = solution("2020.01.01", new String[] {"Z 3", "D 5"},
			new String[] {
				"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"
			});

		Arrays.stream(value).forEach(System.out::println);
	}

	public static int[] solution(String today, String[] terms, String[] privacies) {
		ArrayList<Integer> answerList = new ArrayList<>();
		StringTokenizer todayTokenizer = new StringTokenizer(today, ".");
		int year = Integer.parseInt(todayTokenizer.nextToken());
		int month = Integer.parseInt(todayTokenizer.nextToken());
		int day = Integer.parseInt(todayTokenizer.nextToken());

		int todayInt = (year * 12 * 28) + (month * 28) + day;

		Map<String, Integer> termMap = new HashMap<>();

		for (String term : terms) {
			StringTokenizer tokenizer = new StringTokenizer(term);
			termMap.put(tokenizer.nextToken(), Integer.parseInt(tokenizer.nextToken()));
		}

		int index = 1;
		for (String privacy : privacies) {
			StringTokenizer privacyTokenizer = new StringTokenizer(privacy.split(" ")[0], ".");
			int privacyYear = Integer.parseInt(privacyTokenizer.nextToken());
			int privacyMonth = Integer.parseInt(privacyTokenizer.nextToken());
			int privacyDay = Integer.parseInt(privacyTokenizer.nextToken());

			privacyMonth += termMap.get(privacy.split(" ")[1]);

			int privacyInt = (privacyYear * 12 * 28) + (privacyMonth * 28) + privacyDay;

			if (privacyInt <= todayInt) {
				answerList.add(index);
			}

			index++;
		}

		int[] answer = answerList.stream().mapToInt(Integer::intValue).toArray();
		return answer;
	}
}
