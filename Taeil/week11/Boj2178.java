package week11;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj2178 {
    static int n;
    static int m;
    static int[][] arr;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt( );
        m = sc.nextInt();

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String input = sc.next();

            for (int j = 0; j < m; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        // System.out.println(Arrays.deepToString(arr)); //[[1, 0, 1, 1, 1, 1], [1, 0, 1, 0, 1, 0], [1, 0, 1, 0, 1, 1], [1, 1, 1, 0, 1, 1]]

        // 0, 0 => n-1, m-1
        visited[0][0] = true; // 첫 방문
        bfs(0, 0);
        System.out.println(arr[n-1][m-1]);

    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int now[] = q.poll();
            int nx = now[0];
            int ny = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nx + dx[i];
                int nextY = ny + dy[i];

                // 범위 처리
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                    if (arr[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                        q.add(new int[] {nextX, nextY});
                        visited[nextX][nextY] = true;
                        arr[nextX][nextY] = arr[nx][ny] + 1;
                    }
                }
            }
         }
    }
}
