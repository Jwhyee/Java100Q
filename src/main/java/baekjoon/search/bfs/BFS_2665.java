package baekjoon.search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 백준 : 미로만들기(골드3)
 * 시간 : 100 ms
 * 메모리 : 13496 KB
 * 링크 : https://www.acmicpc.net/problem/2665
 * */
public class BFS_2665 {
    static int N;
    static int[][] map;
    static int[][] dist;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = charArray[j] - '0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs();

        System.out.println(dist[N - 1][N - 1]);
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));
        dist[0][0] = 0;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (dist[ny][nx] > dist[cur.y][cur.x]) {
                        if (map[ny][nx] == 1) {
                            dist[ny][nx] = dist[cur.y][cur.x];
                        } else {
                            dist[ny][nx] = dist[cur.y][cur.x] + 1;
                        }
                        queue.offer(new Node(nx, ny));
                    }
                }
            }
        }
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
