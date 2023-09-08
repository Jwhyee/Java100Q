package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
4 5 1
1 2
1 3
1 4
2 4
3 4
*/

public class BOJ_1260 {
    static int N, M, V;
    static int[][] treeArr;
    static boolean[] visited;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        treeArr = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            treeArr[from][to] = 1;
            treeArr[to][from] = 1;
        }

        visited = new boolean[N + 1];
        dfs(V);
        bw.append("\n");

        visited = new boolean[N + 1];
        bfs(V);
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int current) throws IOException {
        visited[current] = true;
        bw.append(current + " ");

        for (int i = 1; i < treeArr.length; i++) {
            if (!visited[i] && treeArr[current][i] == 1) {
                dfs(i);
            }
        }
    }

    private static void bfs(int start) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (!visited[cur]) {
                visited[cur] = true;
                bw.append(cur + " ");

                for (int i = 1; i < treeArr.length; i++) {
                    if (!visited[i] && treeArr[cur][i] == 1) {
                        queue.add(i);
                    }
                }
            }
        }

    }
}
