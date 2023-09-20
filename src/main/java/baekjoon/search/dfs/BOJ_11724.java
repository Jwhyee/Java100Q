package baekjoon.search.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 제목 : 연결 요소의 개수 [실버2]
 * 시간 : 480 ms
 * 메모리 : 118780 KB
 * */
public class BOJ_11724 {
    static int N, M;
    static int[][] adjacencyArr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjacencyArr = new int[N + 1][N + 1];


        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjacencyArr[from][to] = 1;
            adjacencyArr[to][from] = 1;
        }

        for (int i = 0; i < N + 1; i++) {
            adjacencyArr[i][i] += 1;
        }

        int cnt = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (!visited[i]){
                    if(adjacencyArr[i][j] > 0) {
                        dfs(i);
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }

    private static void dfs(int cur) {
        visited[cur] = true;

        for (int i = 1; i < N + 1; i++) {
            if (adjacencyArr[cur][i] > 0 && !visited[i]) {
                dfs(i);
            }
        }
    }
}
