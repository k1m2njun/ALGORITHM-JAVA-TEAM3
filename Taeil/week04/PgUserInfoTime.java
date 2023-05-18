package week04;

import java.util.ArrayList;
import java.util.HashMap;

public class PgUserInfoTime {
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        System.out.println(solution(today, terms, privacies));

    }

    // 모든 달은 28일까지 있다고 가정 - "까지"니까 마지막 1을 빼줘야 한다.
    // 어떻게 년월을 체크할 것인가? - split
    // 어떻게 데이터 셋? - HashMap
    // getData year, month, day 따로 구하는 것 필요

    public static int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int days = getDay(today);

        // terms
        for (String term : terms) {
            map.put(term.split(" ")[0], Integer.parseInt(term.split(" ")[1]));
        }

        // privacies
        for (int i = 0; i < privacies.length; i++) {
            int day = getDay(privacies[i].split(" ")[0]);
            int privacy = day + (map.get(privacies[i].split(" ")[1]) * 28);
            if (days >= privacy) {
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(el -> el).toArray();
    }

    static int getDay(String data) {
        String[] today = data.split("\\.");
        int year = Integer.parseInt(today[0]);
        int month = Integer.parseInt(today[1]);
        int day = Integer.parseInt(today[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }
}
