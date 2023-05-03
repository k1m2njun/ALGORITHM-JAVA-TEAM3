package seonghyeon.week02.practice1620;

import java.util.HashMap;
import java.util.Scanner;

/*
처음에 List를 사용하여 풀었는데 계속 시간초과가 나서
HashMap이 많은 양의 데이터를 검색하는데에 있어서 성능이 좋다고 하여 HashMap으로 다시 구현했습니다..ㅠ
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();           //포켓몬 갯수
        int problemCnt = sc.nextInt();    //문제 수
        HashMap<String, Integer> pocketmonMap =  new HashMap<>();    //이름과 번호를 저장 (Key = 이름 / Value = 번호)
        String[] nameList = new String[cnt + 1];                     //이름만 저장하는 배열

        sc.nextLine();

        for (int i = 1; i <= cnt; i++) {
            //HashMap과 배열에 각각 포켓몬 담기
            String pocketmon = sc.nextLine();
            pocketmonMap.put(pocketmon, i);
            nameList[i] = pocketmon;
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < problemCnt; i++) {
            String problem = sc.nextLine();
            //parseInt 가능여부에 따라 문제가 번호인지 포켓몬 이름인지 판단
            if (isNumeric(problem)) {
                //문제가 번호면 배열에서 바로 출력
                answer.append(nameList[Integer.parseInt(problem)] + "\n");
            } else {
                //문제가 이름이면 HashMap.get을 이용하여 출력 (get 메서드는 Key값으로 찾아서 Value를 리턴함)
                answer.append(pocketmonMap.get(problem) + "\n");
            }
        }

        System.out.println(answer);
    }

    public static boolean isNumeric(String str) {
        //parseInt가 된다? 숫자이기 때문에 true 리턴
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            //parseInt가 exception이 난다? 문자이기 때문에 false 리턴
            return false;
        }
    }
}
