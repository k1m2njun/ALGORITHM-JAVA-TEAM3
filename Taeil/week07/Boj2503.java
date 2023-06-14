package week07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2503 {
    static int N, count = 0;
    static boolean num[] = new boolean[988];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            combi(number, strike, ball);
        }

        for (int i = 123; i < 988; i++) {
            if (!num[i]) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void combi(int number, int strike, int ball) {
        int a = number/100;
        int b = number%100/10;
        int c = number%100%10;

        for (int i = 123; i < 988; i++) {
            if (num[i]) continue;

            int a2 = i / 100;
            int b2 = i % 100 / 10;
            int c2 = i % 100 % 10;
            int strike2 = 0;
            int ball2 = 0;

            if (a2 == 0 || b2 == 0 || c2 == 0 || a2 == b2 || b2 == c2 || a2 == c2) {
                num[i] = true;
                continue;
            }

            if (a == a2) strike2++;
            if (b == b2) strike2++;
            if (c == c2) strike2++;
            if (a == b2 || a == c2) ball2++;
            if (b == a2 || b == c2) ball2++;
            if (c == b2 || c == a2) ball2++;
            if (strike != strike2 || ball != ball2) num[i] = true;

        }
    }
}