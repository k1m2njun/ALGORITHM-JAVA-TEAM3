package week08;

public class Programmers150369 {
	
	public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int delivery = 0;
        int pickup = 0;
        
        // cap < deliveries, pickups X
        
        // 먼 집부터 방문
        for (int i = n - 1; i >= 0; i--) {
        	delivery += deliveries[i];
        	pickup += pickups[i];
        	
        	while(delivery > 0 || pickup > 0) {
        		delivery -= cap;
        		pickup -= cap;
        		answer += (i+1) * 2;
        	}
        }
        
        
        
        return answer;
    }
	
	public static int hashFunc(int key) {
		return (key % 5);
	}

	public static void main(String[] args) {
		
		int cap = 2;
		int n = 7;
		int[] deliveries = {1, 0, 2, 0, 1, 0, 2};
		int[] pickups = {0, 2, 0, 1, 0, 2, 0};
		
		System.out.println(solution(cap, n, deliveries, pickups));
		

	}

}

//https://school.programmers.co.kr/learn/courses/30/lessons/150369