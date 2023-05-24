package week05;

import java.util.Arrays;
import java.util.TreeMap;

public class ParkingFee {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT",
                "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN",
                "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        System.out.println(solution(fees, records));

    }

    public static int[] solution(int[] fees, String[] records) {
        // map을 이용한 구현
        // TreeMap => key로 sort 된 map => 사용 이유 : records length가 짧아서 사용 가능하다고 판단

        int[] answer = {};
        TreeMap<String, String> parking = new TreeMap<>(); // 차 번호, 시간
        TreeMap<String, Integer> costs = new TreeMap<>();  // 차 번호, 요금

        for (int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            if ("IN".equals(record[2])) {
                parking.put(record[1], record[0]);
            }
            else if ("OUT".equals(record[2])) {                              // parking에 무조건 데이터가 있다.
                int result = getTimeCal(parking.get(record[1]), record[0]);

                if (costs.containsKey(record[1])) {                          // cost에 차 번호가 있다면
                    costs.replace(record[1], costs.get(record[1]) + result); // 이미 있는 요금과 result를 더해준다.
                }
                else {
                    costs.put(record[1], result);

                }
                parking.remove(record[1]);  // 주차되어 있는 차 정보 없에기
            }
        }

        // 시간 23:59분 차량 강제로 보내기
        for (String key : parking.keySet()) {
            int finalTime = getTimeCal(parking.get(key), "23:59");

            if (costs.containsKey(key)) {
                costs.replace(key, costs.get(key) + finalTime);
            }
            else {
                costs.put(key, finalTime);
            }
        }

        answer = new int[costs.size()];
        int i = 0;

        // 요금 정산 => TreeMap을 쓴 이유 key가 정렬되어 있어서 반복문 돌기만 하면 된다.
        for (String key : costs.keySet()) {
            int temp = 0;
            if (costs.get(key) <= fees[0]) {
                costs.replace(key, fees[1]);
            }
            else {
                if ((costs.get(key)- fees[0]) % fees[2] > 0) { // 단위 시간으로 나눴을때, 나머지가 있다면
                    temp = fees[3]; // 단위 시간 당 금액 한번 더 더해주기 => 10분당 일 경우... 나머지 4분
                }
                costs.replace(key, ((costs.get(key) - fees[0]) / fees[2]) * fees[3] + fees[1] + temp);
            }
            answer[i++] = costs.get(key);
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

    static int getTimeCal(String startTime, String endTime) {
        String[] start = startTime.split(":");
        String[] end = endTime.split(":");
        int hour = Integer.parseInt(end[0]) - Integer.parseInt(start[0]);
        int minute = Integer.parseInt(end[1]) - Integer.parseInt(start[1]);
        return (hour * 60) + minute;
    }
}
