package week09;

import java.util.ArrayList;
import java.util.List;

public class Programmers64061 {
	
	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        List<Integer> box = new ArrayList<>();
        
        for(int col : moves) { // 총 이동 회수만큼 반복
        	col = col - 1;
        	for(int row = 0; row < board.length; row++) { // board 행 순회
        		
    			if(board[row][col] != 0) { // 해당 위치 값이 0이 아닌 경우 로직 실행
    				if(box.size() == 0) {
    					box.add(board[row][col]);
    					board[row][col] = 0; // 꺼낸 인형 위치 0으로 초기화
            		} else {
            			if(box.get(box.size()-1) == board[row][col]) {
            				box.remove(box.size()-1);
            				answer += 2;
            			} else {
            				box.add(board[row][col]);
            			}
            			board[row][col] = 0; // 꺼낸 인형 위치 0으로 초기화
            		}
    				break;
    			}
        	}
        	
        }
        
        return answer;
    }

	public static void main(String[] args) {
		
		int[][] board = {{0,0,0,0,0},
						 {0,0,1,0,3},
						 {0,2,5,0,1},
						 {4,2,4,4,2},
						 {3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		// 4 - 3 - 1 - 1 - 3 - 2 - 0 - 4
		System.out.println(solution(board, moves));
		

	}

}

//https://school.programmers.co.kr/learn/courses/30/lessons/64061