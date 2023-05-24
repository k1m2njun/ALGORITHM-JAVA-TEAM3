package week05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Programmers92341 {

	public static void main(String[] args) {
		
//		int[] fees = {180, 5000, 10, 600};
//		String[] records = {"05:34 5961 IN",
//							"06:00 0000 IN",
//											"06:34 0000 OUT",
//											"07:59 5961 OUT",
//							"07:59 0148 IN",
//							"18:59 0000 IN",
//											"19:09 0148 OUT",
//							"22:59 5961 IN",
//											"23:00 5961 OUT"};
		
		int[] fees = {120, 0, 60, 591};
		String[] records = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};

		int count = 0;
		
		Map<String, Integer[]> map = new HashMap<>();
		
		for(int i = 0; i < records.length; i++) {
			Integer hour = Integer.parseInt(records[i].split(" ")[0].split(":")[0]);
			Integer minute = Integer.parseInt(records[i].split(" ")[0].split(":")[1]);
			Integer inAndOutTime = hour * 60 + minute;
			Integer timeUsed = 0;
			Integer[] values = {inAndOutTime, timeUsed, 0};
			
			String carNum = records[i].split(" ")[1];
			String status = records[i].split(" ")[2];
			
			if (status.equals("IN")) {
				if (map.containsKey(carNum)) {
					map.get(carNum)[0] = inAndOutTime;
				} else {
					map.put(carNum, values);
					count++;
				}
				map.get(carNum)[2] = 1; // 주차 상태 IN
			} else if (status.equals("OUT")) {
				map.get(carNum)[1] += (inAndOutTime - map.get(carNum)[0]); // timeUsed 갱신
				map.get(carNum)[2] = 0; // 주차 상태 OUT
			}
		}
		int[] answer = new int[count];
		
		List<String> keyList = new ArrayList<>(map.keySet());
        keyList.sort((s1, s2) -> s1.compareTo(s2));
        
        count = 0;
        for (String key : keyList) {
    		if (map.get(key)[1] <= fees[0]) {
    			if (map.get(key)[2] != 0) {
    				map.get(key)[1] += 1459 - map.get(key)[0];
    				answer[count] = (map.get(key)[1] / fees[2]) * fees[3];
    			} 
    			
        	} else {
        		answer[count] = ((map.get(key)[1] - fees[0]) / fees[2]) * fees[3];
        	}
    		answer[count] += fees[1];
    		count++;
        }
		System.out.println(Arrays.toString(answer));
	}

}

//https://school.programmers.co.kr/learn/courses/30/lessons/92341