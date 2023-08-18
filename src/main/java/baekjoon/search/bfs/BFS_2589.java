package baekjoon.search.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 제목 : 보물섬(골드5)
 * 링크 : https://www.acmicpc.net/problem/2589
 * 메모리 :
 * 시간 :
 */
public class BFS_2589 {
    public static int[][] map;
    public static boolean[][] visited;
    static int h, w;
    public static final int[] dx = {1, -1, 0, 0};
    public static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        h = Integer.parseInt(s.split(" ")[0]);
        w = Integer.parseInt(s.split(" ")[1]);
        int result = 0;
        init(br);
        visited = new boolean[h][w];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 1) {
                    visited = new boolean[h][w];
                    int temp = bfs(i, j);
                    result = Math.max(result, temp);
                }
            }
        }

        System.out.println(result);
    }

    public static int bfs(int x, int y) {
        Queue<Pos> q = new LinkedList<>();
        int val = 0;
        visited[x][y] = true;
        q.add(new Pos(x, y, 0));

        while (!q.isEmpty()) {
            Pos p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.x + dy[i];
                if (nx >= 0 && nx < w && ny >= 0 && ny < h) {
                    if (map[ny][nx] == 1 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        q.add(new Pos(nx, ny, p.cnt + 1));
                        val = Math.max(val, p.cnt + 1);
                    }
                }
            }
        }
        return val;
    }

    public static void init(BufferedReader br) throws IOException {
        map = new int[h][w];
        for (int i = 0; i < h; i++) {
            String s = br.readLine();
            char[] arr = s.toCharArray();
            for (int j = 0; j < w; j++) {
                int n = arr[j] == 'W' ? 0 : 1;
                map[i][j] = n;
            }
        }
    }

    public static class Pos {
        int x;
        int y;
        int cnt;

        public Pos(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
