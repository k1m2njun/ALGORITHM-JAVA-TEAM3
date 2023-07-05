package week10;

import java.util.Scanner;

public class BOJ1012 {
	static int[] x = {0, 0, -1, 1};
	static int[] y = {-1, 1, 0, 0};
	static boolean[][] visit;
	static int[][] arr;
	
	static int nowX, nowY;
	static int M, N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 테스트 케이스 개수
		
		for(int t = 0; t < T; t++) {
			M = sc.nextInt(); // 배추밭 가로
			N = sc.nextInt(); // 배추밭 세로
			int K = sc.nextInt(); // 배추가 심어진 위치 개수
			
			arr = new int[N][M];
			visit = new boolean[N][M];
			
			for(int k = 0; k < K; k++) { // 배추 심기
				int X = sc.nextInt();
				int Y = sc.nextInt();
				arr[Y][X] = 1;
			}
			
			int count = 0;
			for(int n = 0; n < N; n++) {
				for(int m = 0; m < M; m++) {
					if(arr[n][m] == 1 && visit[n][m] == false) {
						count ++;
						DFS(m, n);
					}
				}
			}
			System.out.println(count);
		}
	}
	
	public static void DFS(int X, int Y) {
		visit[Y][X] = true;
		
		for(int i = 0; i < 4; i++) {
			nowX = X + x[i];
			nowY = Y + y[i];
			
			if(Range_check() 
					&& visit[nowY][nowX] == false 
					&& arr[nowY][nowX] == 1) {
				DFS(nowX, nowY);
			}
		}
	}
	
	static boolean Range_check() {
		return (nowY < N && nowY >= 0 && nowX < M && nowX >= 0);
	}

}

//https://www.acmicpc.net/problem/1012