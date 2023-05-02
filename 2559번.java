import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 누적합, 구간합 : https://jih3508.tistory.com/50

public class Main {
    public static void main(String[] args) throws IOException {
        int sum = 0; 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //날짜수
        int K = Integer.parseInt(st.nextToken()); //연속적인 날짜 수

        st=new StringTokenizer(br.readLine());
        int[] arr = new int[N]; // 온도 저장
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 온도 입력 받아서 저장
        }
        for(int i = 0; i < K; i++) {
            sum += arr[i]; // 0~K 온도 더하기
        }
        int max = sum; 
        for(int i = K; i < N; i++) {
            sum += arr[i]; //i번째 숫자 더하기
            sum -= arr[i-K]; //i-K번째 숫자 빼기
            max = Math.max(max, sum); 
        }
        System.out.println(max); //최대값 출력
    }
}
