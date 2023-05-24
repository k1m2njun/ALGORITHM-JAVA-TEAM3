package seonghyeon.week05.parkingpay;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {

		int[] case1 = solution(new int[] {180, 5000, 10, 600}, new String[] {
			"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN",
			"19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"
		});

		int[] case2 = solution(new int[] {120, 0, 60, 591},
			new String[] {"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"});

		int[] case3 = solution(new int[] {1, 461, 1, 10}, new String[] {"00:00 1234 IN"});

		System.out.println("================== CASE 1 ==================");
		System.out.println(Arrays.toString(case1));
		System.out.println("================== CASE 2 ==================");
		System.out.println(Arrays.toString(case2));
		System.out.println("================== CASE 3 ==================");
		System.out.println(Arrays.toString(case3));
	}

	public static int[] solution(int[] fees, String[] records) {
		Map<String, LocalTime> parkingInfo = new HashMap<>();    // 차량번호,입차시간 저장하는 변수
		SortedMap<String, Integer> cumTime = new TreeMap<>();    // 차량번호, 주차시간(분) 저장하는 변수
		List<Integer> answer = new ArrayList<>();

		for (String record : records) {
			String status = record.split(" ")[2];        // IN/OUT
			String carNum = record.split(" ")[1];        // 차량번호
			LocalTime time = LocalTime.parse(record.split(" ")[0], DateTimeFormatter.ofPattern("HH:mm"));  // 입/출차 시간

			if (status.equals("IN")) {
				parkingInfo.put(carNum, time);            // 1. 입차 시, parkingInfo에 차량번호, 입차시간 셋팅

				if (!cumTime.containsKey(carNum)) {
					cumTime.put(carNum, 0);              // 2. cumTime에 차량번호, 주차시간(기본값 0) 셋팅
				}

				continue;
			}

			if (status.equals("OUT")) {
				int parkingMinute = (int)Duration.between(parkingInfo.get(carNum), time).toMinutes();   // 3. 주차시간(분) 계산
				cumTime.replace(carNum,
					cumTime.get(carNum) + parkingMinute);                           // 4. cumTime에 누적시간 업데이트
				parkingInfo.remove(
					carNum);                                                             // 5. 출차했으므로 parkingInfo에서 제거
			}
		}

		//parkingInfo에 남아있다는 것은 출차 내역이 없다는 것.
		Iterator<String> parkingIterator = parkingInfo.keySet().iterator();
		while (parkingIterator.hasNext()) {
			String carNum = parkingIterator.next();
			LocalTime time = LocalTime.parse("23:59", DateTimeFormatter.ofPattern("HH:mm"));

			//출차시간을 23:59로 해서 주차시간 계산
			int parkingMinute = (int)Duration.between(parkingInfo.get(carNum), time).toMinutes();

			cumTime.replace(carNum, cumTime.get(carNum) + parkingMinute);
			//
		}

		Iterator<String> timeIterator = cumTime.keySet().iterator();
		while (timeIterator.hasNext()) {
			answer.add(calc(fees, cumTime.get(timeIterator.next())));
		}

		return answer.stream().mapToInt(x -> x).toArray();
	}

	//주차 요금 계산 모듈
	public static int calc(int[] fees, int parkingMinute) {
		int minMinute = fees[0];
		int minPay = fees[1];
		int defaultMinute = fees[2];
		int defaultPay = fees[3];

		if (parkingMinute <= minMinute)
			return minPay;

		return minPay + (int)Math.ceil((double)(parkingMinute - minMinute) / defaultMinute) * defaultPay;
	}
	//
}
