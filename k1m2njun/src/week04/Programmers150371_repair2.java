package week04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Programmers150371_repair2 {
	
	public static int getTotalDate(String date) {
		int year = Integer.parseInt(date.split("\\.")[0]);
		int month = Integer.parseInt(date.split("\\.")[1]);
		int day = Integer.parseInt(date.split("\\.")[2]);
		
		return (year * 12 * 28) + (month * 28) + day;
	}

	public static void main(String[] args) {
		
		// 입력 예시
		String today = "2020.01.01";
		String[] terms = {"Z 3", "D 5"};
		String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
		
		List<Integer> result = new ArrayList<>();
		
		int[] answer = {};
		
		// 약관 별 유효기간 HashMap, K=약관 : V=유효기간
		HashMap<String, Integer> termsMap = new HashMap<>();
		for(String term : terms) {
			termsMap.put(term.split(" ")[0], Integer.parseInt(term.split(" ")[1])) ;
		}
		
		// 오늘 날짜
		int totalOfToday = getTotalDate(today);
		
		for(int i = 0; i < privacies.length; i++) {
			// 개인정보 수집기간 만료 날짜
			int totalOfEnd = 0;
			
			// 개인정보 수집 날짜
			String privaciesDate = privacies[i].split(" ")[0];
			int totalOfPrivaciesDate = getTotalDate(privaciesDate);
		
			// 고객 약관 타입
			String termsType = privacies[i].split(" ")[1];
			
			// 수집된 개인정보에서 약관 탐색, 기간 만료 날짜 계산
			for(Map.Entry<String, Integer> kv : termsMap.entrySet()) {
				if(kv.getKey().equals(termsType)) {
					totalOfEnd = totalOfPrivaciesDate + (kv.getValue() * 28) - 1;
				}
			}
			
			if (totalOfEnd < totalOfToday) {
				result.add(i+1);
			}
		}
		
		answer = result.stream().mapToInt(Integer::intValue).toArray();
		System.out.println(Arrays.toString(answer));
	}
}

// https://school.programmers.co.kr/learn/courses/30/lessons/150370