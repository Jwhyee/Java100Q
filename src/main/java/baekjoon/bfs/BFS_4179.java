package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS_4179 {
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int R, C;
    static int[] jPos;
    static List<FireNode> fireList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        R = Integer.parseInt(arr[0]);
        C = Integer.parseInt(arr[0]);

        map = new char[R][C];
        visited = new boolean[R][C];
        jPos = new int[2];

        for (int i = 0; i < R; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (charArray[j] == 'J') {
                    jPos[0] = i;
                    jPos[1] = j;
                }
                if (charArray[j] == 'F') {
                    fireList.add(new FireNode(j, i));
                }
                map[i][j] = charArray[j];
            }
        }

        int result = bfs(jPos[0], jPos[1]);

        if (result == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(result);
        }
    }

    private static int bfs(int y, int x) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y, 1));

        while (!queue.isEmpty()) {
            Node currentPos = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = currentPos.x + dx[i];
                int ny = currentPos.y + dy[i];

                if (nx >= 0 && nx < C && ny >= 0 && ny < R) {
                    if ((map[ny][nx] == '.' && (nx == C - 1 || ny == R - 1))) {
                        return currentPos.cost + 1;
                    } else if (map[ny][nx] == '.') {
                        map[currentPos.y][currentPos.x] = '.';
                        queue.offer(new Node(nx, ny, currentPos.cost + 1));
                    }
                }
            }
            fireBfs();
        }

        return -1;
    }

    private static void fireBfs() {
        for (FireNode fireNode : fireList) {
            for (int i = 0; i < 4; i++) {
                int nx = fireNode.x + dx[i];
                int ny = fireNode.y + dy[i];

                if (nx >= 0 && nx < C && ny >= 0 && ny < R) {
                    if (map[ny][nx] == '.') {
                        map[ny][nx] = 'F';
                    }
                }
            }
        }
    }

    static class Node {
        int x, y, cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    static class FireNode {
        int x, y;

        public FireNode(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
