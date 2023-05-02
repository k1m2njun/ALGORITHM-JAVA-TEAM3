package seonghyeon.week02.practice2559;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int days = sc.nextInt();           //온도 측정한 전체 날짜 수
        int sumDays = sc.nextInt();        //합을 구하는 연속적인 날짜 수
        int[] arr = new int[days];
        int val = 0;                       //합
        int answer = Integer.MIN_VALUE;    //출력

        sc.nextLine();

        for (int i = 0; i < days; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < days; i++) {        //전체 날짜 반복
            if (i + sumDays > days) break;      //전체 날짜 수를 벗어나면 즉시 종료
            val = arr[i];
            for (int j = i + 1; j < i + sumDays; j++) { //합을 구하는 반복문
                val += arr[j];
            }

            answer = answer > val? answer : val;   //최댓값 찾기
        }

        System.out.println(answer);
    }
}
