package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 제목 : 유기농 배추 [실버2]
 * 시간 : 112ms
 * 메모리 : 13600KB
* */
public class BOJ_1012 {
    static int T, H, W, K, cnt;
    static StringTokenizer st;
    static BufferedReader br;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[H][W];
            visited = new boolean[H][W];
            initMap();
            cnt = 0;
            for (int j = 0; j < H; j++) {
                for (int k = 0; k < W; k++) {
                    if (map[j][k] == 1 && !visited[j][k]) {
                        dfs(j, k);
                        cnt++;
                    }
                }
            }
            bw.append(cnt + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < W && ny >= 0 && ny < H) {
                if (!visited[ny][nx] && map[ny][nx] == 1) {
                    dfs(ny, nx);
                }
            }
        }
    }

    private static void initMap() throws IOException {
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[y][x] = 1;
        }
    }
}
