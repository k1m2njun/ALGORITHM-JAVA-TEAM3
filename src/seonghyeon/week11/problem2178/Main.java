package seonghyeon.week11.problem2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int n;
	static int m;
	static boolean[][] visit;
	static int[] posX = new int[] {-1, 1, 0, 0};
	static int[] posY = new int[] {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
		n = Integer.parseInt(tokenizer.nextToken());
		m = Integer.parseInt(tokenizer.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String value = reader.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = value.charAt(j) - '0';
			}
		}

		visit = new boolean[n][m];
		visit[0][0] = true;
		bfs(0, 0);

		System.out.println(map[n - 1][m - 1]);
	}

	public static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});

		while (!queue.isEmpty()) {
			int curr[] = queue.poll();
			int currX = curr[0];
			int currY = curr[1];

			for (int i = 0; i < 4; i++) {
				int nextX = currX + posX[i];
				int nextY = currY + posY[i];

				if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)
					continue;

				if (visit[nextX][nextY] || map[nextX][nextY] == 0)
					continue;

				queue.add(new int[] {nextX, nextY});
				map[nextX][nextY] = map[currX][currY] + 1;
				visit[nextX][nextY] = true;
			}
		}
	}
}
