package algo.baekjoon.search.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class DFS_1260 {
    public static boolean[] visited;
    public static int[][] graph;
    public static int N, M, V;
    public static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        // 첫 줄 입력 받는 과정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        // 받은 정보를 토대로 그래프 초기화하는 과정
        visited = new boolean[N + 1];
        graph = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // 인접 행렬 생성
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        // V(시작할 정점)부터 탐색
        dfs(V);
    }

    public static void dfs(int point) {
        // 현재 노드 방문 처리 및 출력
        visited[point] = true;
        System.out.print(point + " ");

        // 현재 정점이 그래프 크기(끝 지점)와 같다면 종료
        if (point == graph.length) {
            return;
        }

        for (int i = 1; i < graph.length; i++) {
            // 인접 행렬이 존재하고, 방문하지 않은 곳이라면 DFS 진행
            if (graph[point][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }

    }

    // 스택
	/*private static void dfs(int point) {
        // 그래프의 끝 지점
		int n = graph.length - 1;

        // 스택에 시작 지점을 넣고, 방문 처리
		stack.push(point);
		visited[point] = true;
		System.out.print(point + " ");

        // 스택이 비어있을 때까지 반복
		while (!stack.isEmpty()) {
			int peek = stack.peek();
			boolean flag = false;

            // 현재 노드와 인접하고, 방문하지 않은 노드 탐색
			for (int i = 1; i <= n; i++) {
				if (graph[peek][i] == 1 && !visited[i]) {
                    // 스택에 추가 후 방문 처리
					stack.push(i);
					System.out.print(i + " ");

					visited[i] = true;
					flag = true;
					break;
				}
			}
			if (!flag) {
				stack.pop();
			}
		}

	}*/
}
