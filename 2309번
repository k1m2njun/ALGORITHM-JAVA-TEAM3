/*
순열 : 9P7 / 조합 : 9C2 / 재귀함수
 */
import java.util.Arrays;
import java.util.Scanner;

public class SevenChild {

    static int[] child = new int[9]; // 입력받을 아홉 난쟁이
    static int[] seven = new int[7]; // 임시로 저장할 일곱 난쟁이
    static int[] sevenChild = new int[7]; // 진짜 일곱 난쟁이

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            child[i] = sc.nextInt();
        }
        Arrays.sort(child); // 입력받은 아홉 난쟁이 오름차순 정렬
        combination(0, 0, 0); // 조합

        for (int c : sevenChild) { // 진짜 일곱 난쟁이 출력
            System.out.println(c);
        }

    }

    private static void combination(int cnt, int start, int sum) {
        if (cnt == 7) {
            if (sum == 100) { // 합이 100일 때 답에 해당 일곱 난쟁이를 저장
                for (int i = 0; i < 7; i++) {
                    sevenChild[i] = seven[i];
                }
            }
            return;
        }

        for (int i = start; i < 9; i++) {
            seven[cnt] = child[i];
            combination(cnt + 1, i + 1, sum + child[i]);
        }
    }
}
