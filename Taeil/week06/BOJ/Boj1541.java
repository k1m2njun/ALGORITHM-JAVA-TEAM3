package week06.BOJ;

import java.io.*;

// 그리디
// 부호 섞여 있는 경우
// 덧셈 부분 먼저 계산 30 - 80 - (20 + 40) - (10 + 30) - (50 + 80 + 90)
// 아닌 경우 그냥 계산
public class Boj1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("-");
        int sum = Integer.MAX_VALUE;

        for (int i = 0; i < str.length; i++) {
            int temp = 0;
            String[] elArr = str[i].split("\\+");

            for (int j = 0; j < elArr.length; j++) {
                temp += Integer.parseInt(elArr[j]);
            }

            if (sum == Integer.MAX_VALUE) { // str[0] 합한 값 넣기
                sum = temp;
            }
            else { // 이후 값들 전부 빼주기
                sum -= temp;
            }
        }

        System.out.println(sum);
        br.close();
    }
}
