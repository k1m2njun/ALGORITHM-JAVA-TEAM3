package week09;

import jdk.jfr.StackTrace;

import java.util.Stack;

public class Dolls {
    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(solution(board, moves));
    }
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        int doll = 0;
        basket.push(doll);

        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][move - 1] != 0) {
                    if (!basket.empty() && basket.peek() == board[j][move - 1]) {
                        basket.pop();
                        answer += 2;
                    }
                    else {
                        doll = board[j][move - 1];
                        basket.push(doll);
                    }
                    board[j][move - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
