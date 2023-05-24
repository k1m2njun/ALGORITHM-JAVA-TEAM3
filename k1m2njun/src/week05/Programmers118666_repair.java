package week05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Programmers118666_repair {

	public static void main(String[] args) {
		String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
		int[] choices = {5, 3, 2, 7, 5};
		
		System.out.println(solution(survey, choices));
	}
	
    public static String solution(String[] survey, int[] choices) {
        String answer = "";
        
        String[] arr = {"1 RT", "2 CF", "3 JM", "4 AN"};
        
        Map<String, String[]> surveyType = new HashMap<>();
        for(String str : arr) {
        	String[] h = {Character.toString(str.split(" ")[1].charAt(0)), Character.toString(str.split(" ")[1].charAt(1))}; 
        	surveyType.put(str.split(" ")[0], h);
        }
        
        // 성격유형 검사지
        Map<String, Integer> result = new HashMap<>();
        for(String str : survey) {
        	
        	result.put(Character.toString(str.charAt(0)), 0);
        	result.put(Character.toString(str.charAt(1)), 0);
        }
        
        // 성격테스트 점수화
        int i = 0;
        for(int choice : choices) {
        	if (choice > 4) {
        		result.replace(Character.toString(survey[i].charAt(1)), choice - 4);
        	} else if (choice < 4) {
        		result.replace(Character.toString(survey[i].charAt(0)), 4 - choice);
        	}
        	i++;
        }
        
        
        return answer;
    }

}

//https://school.programmers.co.kr/learn/courses/30/lessons/118666