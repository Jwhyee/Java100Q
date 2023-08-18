package baekjoon.search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 : 바이러스(SIL3)
 * 시간 : 80 ms
 * 메모리 : 11804 KB
 * 링크 : https://www.acmicpc.net/problem/2606
 * */
public class BFS_2606 {
    static int N;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 정점
        N = Integer.parseInt(br.readLine());

        // 간선
        int M = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int nextId = Integer.parseInt(st.nextToken());
            map[id][nextId] = map[nextId][id] = 1;
        }

        int result = bfs();
        br.close();
        System.out.println(result);
    }

    static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        int cnt = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 1; i <= N; i++) {
                if (map[cur][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
