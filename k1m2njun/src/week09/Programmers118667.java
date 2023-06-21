package week09;

import java.util.LinkedList;
import java.util.Queue;

public class Programmers118667 {
	
	public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        Queue<Integer> queue1st = new LinkedList<>();
        Queue<Integer> queue2nd = new LinkedList<>();
        
        long sum1 = 0;
        long sum2 = 0;
        
        for(int i = 0; i < queue1.length; i++) {
        	queue1st.add(queue1[i]);
        	queue2nd.add(queue2[i]);
        	sum1 += queue1[i];
        	sum2 += queue2[i];
        }
        
        long sum = sum1 + sum2;
        
        // 총 합이 홀수인 경우
        if(sum%2 != 0) return -1;
        
        // 어느 요소라도 합의 절반보다 큰 경우
        long half = sum / 2;
        for(int i = 0; i < queue1.length; i++) {
        	if(queue1[i] > half || queue2[i] > half) return -1;
        }
        
        int max_cnt = queue1st.size() * 4;
        
        while(max_cnt > 0) {
        	
        	if(sum1 == sum2) {
        		return answer;
        	} else if(sum1 > half) {
            	sum1 -= queue1st.peek();
            	sum2 += queue1st.peek();
            	queue2nd.add(queue1st.poll());
            	max_cnt--;
            } else if(sum2 > half) {
            	sum2 -= queue2nd.peek();
            	sum1 += queue2nd.peek();
            	queue1st.add(queue2nd.poll());
            	max_cnt--;
            }
        	answer++;
        }
        return -1;
    }

	public static void main(String[] args) {
		
		int[] queue1 = {1, 10, 1, 2};
		int[] queue2 = {1, 2, 1, 2};

		System.out.println(solution(queue1, queue2));

	}

}

//https://school.programmers.co.kr/learn/courses/30/lessons/118667