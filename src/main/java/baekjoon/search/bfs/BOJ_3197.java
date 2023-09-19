package baekjoon.search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3197 {
    static int W, H;
    static int[][] map;
    static boolean[][] visited;
    static Node[] swarovski = new Node[2];
    static Queue<Node> wq = new LinkedList<>();
    static Queue<Node> wqTemp = new LinkedList<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static boolean flag = false;
    static Node start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new boolean[H][W];

        for (int y = 0, idx = 0; y < H; y++) {
            char[] charArray = br.readLine().toCharArray();
            for (int x = 0; x < W; x++) {
                if (charArray[x] == '.') {
                    map[y][x] = 0;
                    wq.add(new Node(x, y));
                } else if (charArray[x] == 'X') {
                    map[y][x] = -1;
                } else {
                    map[y][x] = 1;
                    swarovski[idx++] = new Node(x, y);
                }
            }
        }

        start = swarovski[0];
        end = swarovski[1];

        int cnt = 0;
        while (true) {
            visited = new boolean[H][W];
            moveSwarovski();
            if (flag) {
                break;
            }
            meltIce();
            cnt++;
        }
        System.out.println(cnt);
    }

    private static void moveSwarovski() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            visited[cur.y][cur.x] = true;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx == end.x && ny == end.y) {
                    flag = true;
                    break;
                }

                if (nx >= 0 && ny >= 0 && nx < W && ny < H) {
                    if (!visited[ny][nx] && map[ny][nx] == 0) {
                        queue.add(new Node(nx, ny));
                    }
                }
            }
        }
    }

    private static void meltIce() {
        wqTemp.clear();
        while (!wq.isEmpty()) {
            Node cur = wq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < W && ny < H) {
                    if (!visited[ny][nx] && map[ny][nx] == -1) {
                        map[ny][nx] = 0;
                        wqTemp.add(new Node(nx, ny));
                    }
                }
            }
        }
        wq.addAll(wqTemp);
        wqTemp.clear();
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
