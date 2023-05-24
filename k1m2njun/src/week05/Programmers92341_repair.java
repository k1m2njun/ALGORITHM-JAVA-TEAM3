package week05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Programmers92341_repair {
	
	static class Car {
		String carNum;
		String status = "OUT";
		int ioTime;
		int timeUsed = 0;
		int fee;
		
		public Car(String carNum) {
			this.carNum = carNum;
		}
		
		public void setStatus() {
			status = (status == "OUT") ? "IN" : "OUT";
		}
		
		public void setTimeUsed(String time) {
			int hour = Integer.parseInt(time.split(":")[0]);
			int minute = Integer.parseInt(time.split(":")[1]);
			Integer inAndOutTime = hour * 60 + minute;
			
			if (this.status == "OUT") {
				ioTime = inAndOutTime;
			} else {
				timeUsed += (inAndOutTime - ioTime);
			}
			setStatus();
		}
		
		public void setFee(int[] fees) {
			
			int standardTime = fees[0];
			int standardFee = fees[1]; 
			int unitTime = fees[2];
			int unitFee = fees[3];
			
			fee = standardFee;
			
			if (status != "OUT") {
				fee += ((timeUsed + 1439 - ioTime - standardTime) / unitTime) * unitFee;
				if((timeUsed + 1439 - ioTime - standardTime) % unitTime != 0) {
					fee += unitFee;
				}
			} else {
				if (timeUsed <= standardTime) {
					
				} else {
					fee += ((timeUsed - standardTime) / unitTime) * unitFee;
					if((timeUsed - standardTime) % unitTime != 0) {
						fee += unitFee;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		
		int[] fees = {180, 5000, 10, 600};
		String[] records = {"05:34 5961 IN",
							"06:00 0000 IN",
											"06:34 0000 OUT",
											"07:59 5961 OUT",
							"07:59 0148 IN",
							"18:59 0000 IN",
											"19:09 0148 OUT",
							"22:59 5961 IN",
											"23:00 5961 OUT"};
		
//		int[] fees = {120, 0, 60, 591};
//		String[] records = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
		
//		solution(fees, records);
		System.out.println(Arrays.toString(solution(fees, records)));
	}
	
	public static int[] solution(int[] fees, String[] records) {
		String time;
		String carNum;
		int i = 0;
		Map<String, Car> carMap = new HashMap<>();
		
		for(String what : records) {
			time = what.split(" ")[0];
			carNum = what.split(" ")[1];
			if(!carMap.containsKey(carNum)) {
				Car car = new Car(carNum);
				carMap.put(carNum, car);
				i++;
			}
			carMap.get(carNum).setTimeUsed(time);
		}
		
		List<String> keyList = new ArrayList<>(carMap.keySet());
        keyList.sort((s1, s2) -> s1.compareTo(s2));
        
        int[] answer = new int[i];
        int count = 0;
        for (String key : keyList) {
        	carMap.get(key).setFee(fees);
        	answer[count] = carMap.get(key).fee;
        	count++;
        }
		
		return answer;
	}
}

//https://school.programmers.co.kr/learn/courses/30/lessons/92341