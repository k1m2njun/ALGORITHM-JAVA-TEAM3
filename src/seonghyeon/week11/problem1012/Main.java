package seonghyeon.week11.problem1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int posX[] = {0, 0, -1, 1};
	static int posY[] = {-1, 1, 0, 0};
	static int[][] map;
	static boolean visit[][];

	static int currX;
	static int currY;
	static int cnt;

	static int n;
	static int m;
	static int k;

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer;
		StringBuilder stringBuilder = new StringBuilder();

		int t = Integer.parseInt(reader.readLine());
		for (int i = 0; i < t; i++) {
			tokenizer = new StringTokenizer(reader.readLine());

			m = Integer.parseInt(tokenizer.nextToken());
			n = Integer.parseInt(tokenizer.nextToken());
			k = Integer.parseInt(tokenizer.nextToken());

			map = new int[n][m];
			visit = new boolean[n][m];

			for (int j = 0; j < k; j++) {
				tokenizer = new StringTokenizer(reader.readLine());
				int x = Integer.parseInt(tokenizer.nextToken());
				int y = Integer.parseInt(tokenizer.nextToken());
				map[y][x] = 1;
			}

			cnt = 0;
			for (int j = 0; j < n; j++) {
				for (int l = 0; l < m; l++) {
					if (map[j][l] == 1 && visit[j][l] == false) {
						cnt++;
						dfs(l, j);
					}
				}
			}
			stringBuilder.append(cnt).append("\n");
		}

		System.out.println(stringBuilder);
	}

	public static void dfs(int x, int y) {
		visit[y][x] = true;

		for (int i = 0; i < 4; i++) {
			currX = x + posX[i];
			currY = y + posY[i];

			if (checkRange() && visit[currY][currX] == false && map[currY][currX] == 1) {
				dfs(currX, currY);
			}
		}
	}

	public static boolean checkRange() {
		return (currY < n && currY >= 0 && currX < m && currX >= 0);
	}
}
