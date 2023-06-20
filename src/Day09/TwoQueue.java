package Day09;

import java.util.LinkedList;
import java.util.Queue;

public class TwoQueue {
    public static int solution(int[] queue1, int[] queue2) {
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();

        long sum1 = 0, sum2 = 0, total = 0;
        int result = 0;
        int temp = 0;

        //각 큐의 합을 구하기
        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            que1.add(queue1[i]);
            sum2 += queue2[i];
            que2.add(queue2[i]);
        }

        total = sum1 + sum2;

        //total합이 홀수이면 -1리턴
        if (total % 2 == 1) {
            return -1;
        }

        total = total / 2; //맞춰야될 합

        //sum1이 total과 같을때까지
        while (sum1 != total) {
            //sum1이 total보다 작다면
            if (sum1 < total) {
                temp = que2.poll(); //que2의 첫번째 값을 temp에 저장후 제거
                que1.add(temp); //que1에 넣어주고
                sum1 += temp; //sum1의 값에 더해줌
            } else {
                temp = que1.poll(); //que1의 첫번째 값을 temp에 저장후 제거
                que2.add(temp); //que2에 넣어주고
                sum1 -= temp; //sum1의 값에서 빼줌
            }
            result++; //result증가
            // 모든값이 바꼈다 제자리를 찾아왔다면 방법이 없는것이므로 -1리턴
            if (result > queue1.length * 4 - 1) {
                return -1;
            }
        }
        System.out.println(result);
        return result;
    }
    public static void main(String[] args) {
        int[] queue1 = {1, 2, 1, 2};
        int[] queue2 = {1, 10, 1, 2};
        solution(queue1, queue2);
    }
}
