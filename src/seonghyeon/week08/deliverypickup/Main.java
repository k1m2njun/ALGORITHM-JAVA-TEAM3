package seonghyeon.week08.deliverypickup;

public class Main {
	public static void main(String[] args) {
		System.out.println(solution(4, 5, new int[] {1, 0, 3, 1, 2}, new int[] {0, 3, 0, 4, 0}));
		System.out.println(solution(2, 7, new int[] {1, 0, 2, 0, 1, 0, 2}, new int[] {0, 2, 0, 1, 0, 2, 0}));
	}

	public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
		int deliver = 0;
		int pickup = 0;
		long answer = 0;

		for (int i = n - 1; i >= 0; i--) {
			if (deliveries[i] == 0 && pickups[i] == 0)
				continue;

			int cnt = 0;
			while (deliver < deliveries[i] || pickup < pickups[i]) {
				cnt++;
				deliver += cap;
				pickup += cap;
			}

			deliver -= deliveries[i];
			pickup -= pickups[i];
			answer += (i + 1) * cnt * 2;
		}

		return answer;
	}
}
