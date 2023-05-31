package week06.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11047 {
    // 그리디

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins =  new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {;
            coins[i] = Integer.parseInt(br.readLine());
        }
        // 배열 거꾸로 돌기
        for (int i = n - 1; i >= 0; i--) {
            if (coins[i] <= k) {
                count += k / coins[i];
                k = k % coins[i];
            }
        }
        System.out.println(count);
        br.close();
    }
}
