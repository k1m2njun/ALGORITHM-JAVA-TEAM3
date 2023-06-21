package seonghyeon.week09.crane;

import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		int answer = solution(
			new int[][] {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}},
			new int[] {1, 5, 3, 5, 1, 2, 1, 4});

		System.out.println(answer);

		answer = solution(
			new int[][] {{3, 3, 3, 3, 3}, {3, 3, 3, 3, 3}, {3, 3, 3, 3, 3}, {3, 3, 3, 3, 3}, {3, 3, 3, 3, 3}},
			new int[] {1, 5, 3, 5, 1, 2, 1, 4});

		System.out.println(answer);
	}

	public static int solution(int[][] board, int[] moves) {
		Stack<Integer> result = new Stack<>();
		result.push(0);
		int answer = 0;

		for (int move : moves) {
			int number = getNumber(board, move);

			if (number == 0)
				continue;

			if (!result.peek().equals(number)) {
				result.push(number);
				continue;
			}

			result.pop();
			answer += 2;
		}

		return answer;
	}

	public static int getNumber(int[][] board, int move) {
		for (int i = 0; i < board.length; i++) {
			int doll = board[i][move - 1];

			if (doll == 0)
				continue;

			board[i][move - 1] = 0;

			return doll;
		}

		return 0;
	}
}
