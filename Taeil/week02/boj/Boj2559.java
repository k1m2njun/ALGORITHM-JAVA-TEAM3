package week02.boj;

import java.io.*;
import java.util.StringTokenizer;

public class Boj2559 {
    // 배열 최소 2개 필요
    // 1. 수열 배열 || 2. sum 배열 => 길이는 어떻게...? => 굳이 필요 없다. 최대값만 구하면 됌
    // 누적 합 => 투포인터
    // 최대값 찾기

    static int N, K;
    static int[] sequence;
    static int max;

    public static void solution() {
        int temp = 0;
        int start = 0;
        int end = K;

        // 최소 K개 합
        for (int i = 0; i < K; i++) {
            temp += sequence[i];
        }

        max = temp;

        // 투포인터
        while (end <= N - 1) {
            temp -= sequence[start++];
            temp += sequence[end++];
            max = Math.max(max, temp);
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        sequence = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
        // System.out.println(Arrays.toString(sequence)); // [3, -2, -4, -9, 0, 3, 7, 13, 8, -3]

        solution();
        System.out.println(max);

        br.close();
    }
}