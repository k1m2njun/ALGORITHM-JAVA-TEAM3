package week04;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Programmers77485_repair {
	
	public static int[][] createMatrix(int rows, int columns) {
		int matrix[][] = new int[rows][columns];
		
		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				matrix[row][column] = row * columns + column + 1;
			}
		}
		return matrix;
	}

	public static void main(String[] args) {
		
		// 입력
		int rows = 6;
		int columns = 6;
		int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		
		int[] answer = new int[queries.length];
		
		int[][] matrix = createMatrix(rows, columns);
		
		// queries 직사각형 {시작점1, 끝점1, 시작점2, 끝점2} 
		for (int query = 0; query < queries.length; query++) {
			int x1 = queries[query][0]-1;
			int y1 = queries[query][1]-1;
			int x2 = queries[query][2]-1;
			int y2 = queries[query][3]-1;
			
			int tmp = matrix[x1][y2];
			int min = tmp;
			
			for (int i = y2; i > y1; i--) { // matrix 열
				matrix[x1][i] = matrix[x1][i-1]; 
				if (min > matrix[x1][i]) min = matrix[x1][i];
			}
			for (int i = x1; i < x2; i++) { // matrix 행
				matrix[i][y1] = matrix[i+1][y1]; 
				if (min > matrix[i][y1]) min = matrix[i][y1];
			}
			for (int i = y1; i < y2; i++) { // matrix 열
				matrix[x2][i] = matrix[x2][i+1]; 
				if (min > matrix[x2][i]) min = matrix[x2][i];
			}
			
			for (int i = x2; i > x1; i--) { // matrix 행
				matrix[i][y2] = matrix[i-1][y2]; 
				if (min > matrix[i][y2]) min = matrix[i][y2];
			}
			matrix[x1+1][y2] = tmp;
			
			answer[query] = min;
		}
		System.out.println(Arrays.toString(answer));
	}
}
//https://school.programmers.co.kr/learn/courses/30/lessons/77485