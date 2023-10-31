package algo.baekjoon.search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 : 토마토(골드5)
 * 시간 : 776 ms
 * 메모리 : 128804 KB
 * 링크 : https://www.acmicpc.net/problem/7569
 * */
public class BFS_7569 {
    // 가로, 세로, 높이
    static int M, N, H;

    // 토마토 배열, 방문 배열
    static int[][][] tomato;
    static boolean[][][] visited;

    // 방향 배열
    static int[] dx = {0, 1, 0, -1, 0, 0};
    static int[] dy = {1, 0, -1, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomato = new int[H][N][M];
        visited = new boolean[H][N][M];

        // 저장될 때부터 모든 토마토가 익어있는지 확인할 변수
        int zeroCnt = 0;

        // 토마토 상태 저장
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    // 현재 토마토의 상태
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());

                    // 익지 않은 토마토가 있다면 제로 카운트 증가
                    if (tomato[i][j][k] == 0) {
                        zeroCnt++;
                    }

                    // 만약 익은 토마토라면 큐에 추가
                    if (tomato[i][j][k] == 1) {
                        queue.offer(new Node(i, j, k, 0));
                    }
                }
            }
        }

        int cnt = 0;

        // 출력 조건에 따라 0출력
        if (zeroCnt == 0) {
            System.out.println(cnt);
        }
        // 0이 아닐 경우 bfs를 통해 토마토가 익는 날짜 구하기
        else {
            bfs();
            showMatrix();
            // 며칠이 걸렸는지 확인하고, 0이 존재하면 -1 출력
            int max = findMax();
            System.out.println(max);
        }
    }

    private static int findMax() {
        int max = 0;
        for (int[][] ints : tomato) {
            for (int[] anInt : ints) {
                for (int i : anInt) {
                    max = Math.max(max, i);
                    if (i == 0) {
                        return -1;
                    }
                }
            }
        }
        return max;
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            visited[cur.z][cur.y][cur.x] = true;

            for (int i = 0; i < 6; i++) {
                int nz = cur.z + dz[i];
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                int day = cur.day + 1;

                if (nz >= 0 && nz < H && ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    if (!visited[nz][ny][nx] && tomato[nz][ny][nx] == 0) {
                        tomato[nz][ny][nx] = day;
                        queue.offer(new Node(nz, ny, nx, day));
                    }
                }
            }
        }
    }

    static class Node {
        int z, y, x, day;

        public Node(int z, int y, int x, int day) {
            this.z = z;
            this.y = y;
            this.x = x;
            this.day = day;
        }
    }

    private static void showMatrix() {
        for (int i = 0; i < H; i++) {
            for (int[] row : tomato[i]) {
                for (int value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        }
        System.out.println();
    }
}
