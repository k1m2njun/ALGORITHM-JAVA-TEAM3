package week02.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj1620 {
    // HashMap <String, String>
    // HashMap 포켓몬 도감 세팅
    // 포켓몬 도감에서 찾을 포켓몬 찾기
    // 숫자 확인 판단여부..?

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // HashMap <String, String>
        HashMap<String, String> poketmons = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // HashMap 포켓몬 도감 세팅
        // $$ i = 1 부터 시작
        for (int i = 1; i < N + 1; i++) {
            String poketmonName = br.readLine();
            String num = Integer.toString(i);

            poketmons.put(num, poketmonName); // {[1, a], [2, b], [3, c] }
            poketmons.put(poketmonName, num); // {[a, 1], [b, 2]}
        }

        // 포켓몬 도감에서 찾을 포켓몬 찾기
        for (int i = 0; i < M; i++) {
            sb.append(poketmons.get(br.readLine()));
            sb.append('\n');
        }
        System.out.println(sb);

        br.close();

    }

//    // 숫자 판단 여부 메서드
//    public static boolean isNum(String str) {
//
//    }
}
