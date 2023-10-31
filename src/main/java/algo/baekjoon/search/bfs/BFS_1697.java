package algo.baekjoon.search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_1697 {
    static int N, K;
    static int[] map = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int result = bfs(N);
        System.out.println(result);
    }

    private static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        int nx = 0;
        map[start] = 1;

        while (!queue.isEmpty()) {
            // 큐를 돌면서 가장 가까운 경로 탐색
            nx = queue.poll();
            if (nx == K) {
                return map[nx] - 1;
            }
            if (nx - 1 >= 0 && map[nx - 1] == 0) {
                map[nx - 1] = map[nx] + 1;
                queue.offer(nx - 1);
            }
            if (nx + 1 <= 100000 && map[nx + 1] == 0) {
                map[nx + 1] = map[nx] + 1;
                queue.offer(nx + 1);
            }
            if (nx * 2 <= 100000 && map[nx * 2] == 0) {
                map[nx * 2] = map[nx] + 1;
                queue.offer(nx * 2);
            }

        }

        return -1;
    }


}
