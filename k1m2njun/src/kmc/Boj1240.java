package kmc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1240 {
	
	static int[][] distance;
	static int[][] node;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 첫 줄 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 연결관계, 거리 표현을 위한 인접 행렬
		node = new int[N + 1][N + 1];
		distance = new int[N + 1][N + 1];

		for (int i = 0; i < N - 1; i++) {
			// 두 번째 줄부터 N-1개의 줄까지 '두 노드와 그 사이의 거리 입력'
			st = new StringTokenizer(br.readLine());
			int fromNode = Integer.parseInt(st.nextToken());
			int toNode = Integer.parseInt(st.nextToken());
			int distanceBetweenAandB = Integer.parseInt(st.nextToken());
			
			// 방향 그래프
			node[fromNode][toNode] = 1;
			node[toNode][fromNode] = 1;
			distance[fromNode][toNode] = distanceBetweenAandB;
			distance[toNode][fromNode] = distanceBetweenAandB;
		}

		// 알고싶은 두 노드 간의 거리 구하기
		for (int i = 0; i < M; i++) {
			// 거리를 알고 싶은 '두 노드 입력'
			st = new StringTokenizer(br.readLine());
			int fromNode = Integer.parseInt(st.nextToken());
			int toNode = Integer.parseInt(st.nextToken());
			
			bfs(fromNode, toNode, N); // (1, 2), (3, 2)
		}
	}

	public static void bfs(int fromNode, int toNode, int numberOfNodes) {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[numberOfNodes + 1];

		visited[fromNode] = true; // 최초 노드 방문 처리
		queue.add(fromNode); // 최초 노드 queue에 추가
		int[] ans = new int[numberOfNodes + 1];

		while (!queue.isEmpty()) { // queue가 비어있지 않으면
			int cur = queue.poll(); // 가장 먼저 들어온 노드를 뽑음

			for (int i = 1; i <= numberOfNodes; i++) { // 1, 2, 3, 4, 5

				if (node[cur][i] == 1 && !visited[i]) { // 만약 연결되어 있고 방문하지 않은 노드이면
					ans[i] += distance[cur][i] + ans[cur]; // 거리를 갱신해준다.

					if (i == toNode) { // 만약 마지막 노드이면 종료
						System.out.println(ans[toNode]);
						return;
					}

					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
}