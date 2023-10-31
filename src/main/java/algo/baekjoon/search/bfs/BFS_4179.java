package algo.baekjoon.search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_4179 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int R, C;
    static int[] jPos;
    static Queue<Node> fireQueue = new LinkedList<>();
    static Queue<Node> jihoonQueue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        R = Integer.parseInt(arr[0]);
        C = Integer.parseInt(arr[0]);

        map = new int[R][C];
        visited = new boolean[R][C];
        jPos = new int[2];

        for (int i = 0; i < R; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = 0;
                if(charArray[j] == '#') {
                    map[i][j] = -1;
                } else if(charArray[j] == 'J') {
                    map[i][j] = 0;
                    jihoonQueue.offer(new Node(j, i, 0));
                } else if (charArray[j] == 'F') {
                    map[i][j] = -2;
                    fireQueue.offer(new Node(j, i, 0));
                }
            }
        }

        int result = bfs();

        if (result == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(result);
        }
    }

    private static int bfs() {
        while (!jihoonQueue.isEmpty()) {
            Node cur = jihoonQueue.poll();

            // 지훈이가 한 칸 이동
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < C && ny >= 0 && ny < R) {
                    if ((map[ny][nx] == 0 && (nx == C - 1 || ny == R - 1))) {
                        // 한 칸이동 시간 + 탈출 시간
                        return (cur.cost + 1) + 1;
                    } else if (map[ny][nx] == 0) {
                        jihoonQueue.offer(new Node(nx, ny, cur.cost + 1));
                    }
                }
            }

            // 불이 한 칸씩 퍼짐
            int fireQueueSize = fireQueue.size();
            while (fireQueueSize-- > 0) {
                Node fireNode = fireQueue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = fireNode.x + dx[i];
                    int ny = fireNode.y + dy[i];

                    if (nx >= 0 && nx < C && ny >= 0 && ny < R) {
                        if (map[ny][nx] == 0) {
                            map[ny][nx] = -2;
                            fireQueue.offer(new Node(nx, ny, 0));
                        }
                    }
                }
            }
            showMatrix();
        }

        return -1;
    }

    public static void showMatrix() {
        Arrays.stream(map)
                .map(Arrays::toString)
                .forEach(System.out::println);
        System.out.println("----------------");
    }

    static class Node {
        int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
