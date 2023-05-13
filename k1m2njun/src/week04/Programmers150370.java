package week04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Programmers150370 {
	
	public static void addArr(int[] arr, int a) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 0) {
				arr[i] = a;
				break;
			}
		}
	}

	public static void main(String[] args) {
		
		// 입력 예시
		String today = "2022.05.19";
		String[] terms = {"A 6", "B 12", "C 3"};
		String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
		
//		int[] answer = new int[privacies.length];
		
		// terms 약관 : 유효기간
		HashMap<String, Integer> termsMap = new HashMap<>();
		for(String term : terms) {
			termsMap.put(term.split(" ")[0], Integer.parseInt(term.split(" ")[1])) ;
		}
		
		// 수집기간 만료 날짜
		int yearOfEnd = 0;
		int monthOfEnd = 0;
		int dayOfEnd = 0;
		
		// 오늘 날짜
		int yearOfToday = Integer.parseInt(today.split("\\.")[0]);
		int monthOfToday = Integer.parseInt(today.split("\\.")[1]);
		int dayOfToday = Integer.parseInt(today.split("\\.")[2]);
		
		for(int i = 0; i < privacies.length; i++) {
			String privaciesDate = privacies[i].split(" ")[0];
			
			int yyyy = Integer.parseInt(privaciesDate.split("\\.")[0]);
			int mm = Integer.parseInt(privaciesDate.split("\\.")[1]);
			int dd = Integer.parseInt(privaciesDate.split("\\.")[2]);
			
			for(Map.Entry<String, Integer> kv : termsMap.entrySet()) {
				
				// 수집된 개인정보에서 약관 탐색
				if(kv.getKey().equals(privacies[i].split(" ")[1])) {
					int day = (kv.getValue() * 28) + dd;
					int month = mm + (day / 28);
					
					if (day % 28 == 1) {
						monthOfEnd = month % 12 - 1;
						dayOfEnd = 28;
					} else {
						monthOfEnd = month % 12;
						dayOfEnd = day % 28 - 1;
					}
					
					yearOfEnd = yyyy + (month / 12);
					
				}
			}
			ArrayList<Integer> answer = new ArrayList<>();
			answer.add(2);
			answer.toArray();
			
//			Arrays.copyOf(answer, answer.size());
			
			System.out.println(answer.toString());
			
//			if (yearOfToday > yearOfEnd) {
//				addArr(answer, i + 1);
//				continue;
//			} else if (monthOfToday > monthOfEnd) {
//				addArr(answer, i + 1);
//				continue;
//			} else if (dayOfToday > dayOfEnd) {
//				addArr(answer, i + 1);
//				continue;
//			}
		}
//		System.out.println(Arrays.toString(answer));
	}
}

// https://school.programmers.co.kr/learn/courses/30/lessons/150370