package Day04;

import java.util.ArrayList;
import java.util.HashMap;

public class Privacy {
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        ArrayList<Integer> answer = new ArrayList<Integer>();
        String[] yymmdd = today.split("[.]");
        int todayTotal = (Integer.parseInt(yymmdd[0]) * 12 * 28) + (Integer.parseInt(yymmdd[1]) * 28) + Integer.parseInt(yymmdd[2]); //오늘날짜의 총일수
        HashMap<String, Integer> termsSplit = new HashMap<String, Integer>();

        for (int i=0; i<terms.length; i++) {
            String[] temp = terms[i].split(" "); //약관종류와 유효기간을 split
            termsSplit.put(temp[0], Integer.parseInt(temp[1])); //hashmap에 약관 종류를 키값으로 집어넣음
        }

        for (int i=0; i< privacies.length; i++){
            Integer[] tempDateInteger = new Integer[3];
            String[] temp = privacies[i].split(" ");
            int num = termsSplit.get(temp[1]);
            String[] tempDate = temp[0].split("[.]"); //privacies의 날짜를 다시 split하여 저장 ["2021", "05", "02"]
            int total = (Integer.parseInt(tempDate[0]) * 12 * 28) + (Integer.parseInt(tempDate[1]) * 28) + Integer.parseInt(tempDate[2]) + (num * 28); // 총 날짜를 저장
            if(total <= todayTotal){ //총날짜보다 오늘날짜의 수가 많거나 같으면 폐기해야함
                answer.add(i+1);
            }
        }

        int[] answerTest = new int[answer.size()];
        int size = 0;
        for(int i : answer){
            answerTest[size++] = i;
        }
        System.out.println(answerTest[0] + answerTest[1]);
    }
}
