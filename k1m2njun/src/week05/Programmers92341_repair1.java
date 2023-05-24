package week05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Programmers92341_repair1 {
	
	public static void main(String[] args) {
		
		int[] fees = {180, 5000, 10, 600};
		String[] records = {"05:34 5961 IN", "06:34 5961 OUT",
							"07:34 5961 IN", "08:34 5961 OUT",
							"09:34 5961 IN", "10:34 5961 OUT",
							"11:34 5961 IN", "12:34 5961 OUT"};
		
//		int[] fees = {120, 0, 60, 591};
//		String[] records = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
		
//		solution(fees, records);
		System.out.println(Arrays.toString(solution(fees, records)));
	}
	
	public static int[] solution(int[] fees, String[] records) {
		
		Map<String, Integer> timeCar = new HashMap<>();
		Map<String, String> ioCar = new HashMap<>();
		Map<String, Integer> feeCar = new HashMap<>();
		
		for(int i = 0; i < records.length; i++) {
			int minuite = calMinuites(records[i].split(" ")[0]); 
			String carNum = records[i].split(" ")[1];
			String ioStatus = records[i].split(" ")[2];
			
			ioCar.put(carNum, ioStatus);
			int current = timeCar.getOrDefault(carNum, 0);
			
			if(ioStatus.equals("IN")) {
				timeCar.put(carNum, minuite);
				
			} else {
				feeCar.put(carNum, minuite - current + feeCar.getOrDefault(carNum, 0)); // <--- 이게 킥이었음.
			}
			
		}
		
		int stdTime = fees[0];
		int stdFee = fees[1];
		int unitTime = fees[2];
		int unitFee = fees[3];
		
		List<String> keyList = new ArrayList<>(timeCar.keySet());
        keyList.sort((s1, s2) -> s1.compareTo(s2));
        
        int[] answer = new int[timeCar.size()];
        int i = 0;
        for (String key : keyList) {
        	if(ioCar.get(key).equals("IN")) {
        		feeCar.put(key, feeCar.getOrDefault(key, 0) + 1439 - timeCar.getOrDefault(key, 0));
        	}
        	
        	if(feeCar.get(key) <= stdTime) {
        		answer[i] = stdFee;
        	} else {
        		answer[i] = stdFee + (((feeCar.get(key) - stdTime + unitTime - 1) / unitTime) * unitFee);
        	}
        	i++;
        }
		return answer;
	}
	
	public static int calMinuites(String time) {
		return Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);
	}
}

//https://school.programmers.co.kr/learn/courses/30/lessons/92341