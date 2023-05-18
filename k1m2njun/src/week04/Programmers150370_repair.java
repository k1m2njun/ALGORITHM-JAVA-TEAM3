package week04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Programmers150370_repair {
	
	public static int[] addArr(int[] arr, int size, int num) {
		if (size >= arr.length) {
			int[] copyArr = new int[size+1];
			for(int i = 0; i < arr.length; i++) {
				copyArr[i] = arr[i];
			}
			copyArr[size] = num;
			size++;
			return copyArr;
		}
		return null;
	}

	public static void main(String[] args) {
		
		// 입력 예시
		String today = "2020.01.01";
		String[] terms = {"Z 3", "D 5"};
		String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
		
		int[] answer = {};
		int size = 1;
		
		// 약관 별 유효기간 HashMap, K=약관 : V=유효기간
		HashMap<String, Integer> termsMap = new HashMap<>();
		for(String term : terms) {
			termsMap.put(term.split(" ")[0], Integer.parseInt(term.split(" ")[1])) ;
		}
		
		// 오늘 날짜
		int yearOfToday = Integer.parseInt(today.split("\\.")[0]);
		int monthOfToday = Integer.parseInt(today.split("\\.")[1]);
		int dayOfToday = Integer.parseInt(today.split("\\.")[2]);
		int totalOfToday = (yearOfToday * 12 * 28) + (monthOfToday * 28) + dayOfToday;
		
		for(int i = 0; i < privacies.length; i++) {
			// 개인정보 수집기간 만료 날짜
			int totalOfEnd = 0;
			
			// 개인정보 수집 날짜
			String privaciesDate = privacies[i].split(" ")[0];
			int yearOfPrivaciesDate = Integer.parseInt(privaciesDate.split("\\.")[0]);
			int monthOfPrivaciesDate = Integer.parseInt(privaciesDate.split("\\.")[1]);
			int dayOfPrivaciesDate = Integer.parseInt(privaciesDate.split("\\.")[2]);
			int totalOfPrivaciesDate = (yearOfPrivaciesDate * 12 * 28) + (monthOfPrivaciesDate * 28) + dayOfPrivaciesDate;
		
			// 고객 약관 타입
			String termsType = privacies[i].split(" ")[1];
			
			// 수집된 개인정보에서 약관 탐색
			for(Map.Entry<String, Integer> kv : termsMap.entrySet()) {
				if(kv.getKey().equals(termsType)) {
					totalOfEnd = totalOfPrivaciesDate + (kv.getValue() * 28);
				}
			}
			
			if (totalOfEnd > totalOfToday) {
				answer = addArr(answer, size, i);
				size++;
			}
		}
		System.out.println(Arrays.toString(answer));
	}
}

// https://school.programmers.co.kr/learn/courses/30/lessons/150370