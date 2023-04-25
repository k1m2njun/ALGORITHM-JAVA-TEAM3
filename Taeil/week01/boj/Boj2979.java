package week01.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Boj2979 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[][] arr = new int[3][2];
        int max = 0;
        int sum = 0;

        int A = Integer.parseInt(st.nextToken()); // 분당 1대 요금
        int B = Integer.parseInt(st.nextToken()); // 분당 2대 요금
        int C = Integer.parseInt(st.nextToken()); // 분당 3대 요금

        // 데이터 정리, 이중배열로 배열 만들기
        for (int i = 0; i < 3; i++) {
            // input
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int[] tempArr = {start, end};
            arr[i] = tempArr;
            max = Math.max(max, end);
        }

//        System.out.println(Arrays.deepToString(arr)); // [[1, 6], [3, 5], [2, 8]]

        int[] maxBoard = new int[max - 1];

        for (int[] el : arr) {
            for (int i = el[0] - 1; i < el[1] - 1; i++) {
                maxBoard[i] += 1;
            }
        }
//        System.out.println(Arrays.toString(maxBoard)); // [1, 2, 3, 3, 2, 1, 1]


        for (int el : maxBoard) {
            if (el == 1) {
                sum += A * el;
            }
            else if (el == 2) {
                sum += B * el;
            }
            else if (el == 3) {
                sum += C * el;
            }
        }
        System.out.println(sum);
        bf.close();


    }
}