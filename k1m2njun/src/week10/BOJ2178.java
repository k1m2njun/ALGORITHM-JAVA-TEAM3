package week10;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2178 {
	static int[] x = {0, 0, -1, 1};
	static int[] y = {-1, 1, 0, 0};
	static boolean[][] visit;
	static int[][] maze;
	
	static int nowX, nowY;
	static int M, N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		maze = new int[N][M];
		visit = new boolean[N][M];
		visit[0][0] = true;
		
		String row;
	
		for(int n = 0; n < N; n++) {
			row = sc.next();
			for(int m = 0; m < M; m++) {
				maze[n][m] = row.charAt(m) - '0';
			}
		}
		
		bfs(0, 0);
		System.out.println(maze[N-1][M-1]);
	}
	
	public static void bfs(int X, int Y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {X, Y});
		
		while(!queue.isEmpty()) {
			int now[] = queue.poll();
			nowX = now[0];
			nowY = now[1];
			
			for(int i = 0; i < 4; i++) {
				int nextX = nowX + x[i];
				int nextY = nowY + y[i];
				
				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;
				if (visit[nextX][nextY] || maze[nextX][nextY] == 0) continue;
				
				queue.add(new int[] {nextX, nextY});
				maze[nextX][nextY] = maze[nowX][nowY] + 1;
				visit[nextX][nextY] = true;
			}
		}
	}

}

//https://www.acmicpc.net/problem/2178