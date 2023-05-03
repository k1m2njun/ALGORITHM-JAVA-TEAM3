package seonghyeon.week02.practice1620;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//시간초과가 나는 정답 ㅠ
public class practice1620 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();
        int problemCnt = sc.nextInt();
        List<String> pocketmonList = new ArrayList<>();

        pocketmonList.add(sc.nextLine());

        for (int i = 0; i < cnt; i++) {
            pocketmonList.add(sc.nextLine());
        }

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < problemCnt; i++) {
            String problem = sc.nextLine();

            if (isNumeric(problem)) {
                answer.append(pocketmonList.get(Integer.parseInt(problem)) + "\n");
            } else {
                answer.append(pocketmonList.indexOf(problem) + "\n");
            }
        }

        sc.close();
        System.out.println(answer);

    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
