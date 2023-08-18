package baekjoon.search.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 이름(난이도) : 그림(실버1)
 * 시간 : 372 ms
 * 메모리: 52092 KB
 * 링크 : https://www.acmicpc.net/problem/1926
 * */
public class DFS_1926 {
    static int[][] map;
    static boolean[][] visited;
    static int h, w;
    static int count = 0, max = 0, temp = 0;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        map = new int[h][w];
        visited = new boolean[h][w];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    dfs(i, j);
                    count++;
                    max = Math.max(max, temp);
                    temp = 0;
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    public static void dfs(int y, int x) {
        visited[y][x] = true;
        temp++;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= 0 && ny < h && nx >= 0 && nx < w) {
                if (!visited[ny][nx] && map[ny][nx] != 0) {
                    dfs(ny, nx);
                }
            }
        }
    }
}