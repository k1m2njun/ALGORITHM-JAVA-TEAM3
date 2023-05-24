package week05;

import java.util.HashMap;
import java.util.Map;

public class Programmers118666 {

	public static void main(String[] args) {
		String[] survey = {"TR", "RT", "TR"};
		int[] choices = {7, 1, 3};
		
		System.out.println(solution(survey, choices));
	}
	
    public static String solution(String[] survey, int[] choices) {
    	String answer = "";
        String[][] indicators = {
            {"R", "T"},
            {"C", "F"},
            {"J", "M"},
            {"A", "N"}
        };
        
        Map<String, Integer> map = new HashMap<>();
        
        // 점수 계산
        for(int i = 0; i < survey.length; i++){
            String s = survey[i];
            
            String temp = null;
            int score = 0;
            
            if(choices[i] < 4){ // 비동의
                temp = String.valueOf(s.charAt(0));
                score = 4 - choices[i];
            }
            else if(choices[i] > 4){ // 동의
                temp = String.valueOf(s.charAt(1));
                score = choices[i] - 4;
            }
            // 기존 키가 있으면 점수 가져와서 새로 put
            map.put(temp, map.getOrDefault(temp, 0) + score); // 유형마다 점수 갱신
        }
    
        // 성격유형 검사
        for(int i = 0; i < 4; i++){
        	
        	String L = indicators[i][0];
        	String R = indicators[i][1];
            
        	answer += (map.getOrDefault(L, 0) >= map.getOrDefault(R, 0)) ? L : R;
        }
        return answer;
    }

}

//https://school.programmers.co.kr/learn/courses/30/lessons/118666