package baekjoon.search.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 : 영역 구하기(실버1)
 * 시간 : 100 ms
 * 메모리 : 13204 KB
 * 링크 : https://www.acmicpc.net/problem/2583
 * */
public class DFS_2583 {

    static int M, N, K, emptyCnt, areaCnt = 0;
    static int[][] paper;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0}, dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        List<Integer> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        paper = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            // y좌표 조정
            for (int j = sy; j < ey; j++) {
                // x좌표 조정
                for (int k = sx; k < ex; k++) {
                    paper[j][k] += 1;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && paper[i][j] == 0) {
                    emptyCnt = 0;
                    dfs(i, j);
                    areaCnt++;
                    result.add(emptyCnt);
                }
            }
        }

        sb.append(areaCnt).append("\n");

        Collections.sort(result);

        for (Integer i : result) {
            sb.append(i).append(" ");
        }
        bw.append(sb.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;
        emptyCnt++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (!visited[ny][nx] && paper[ny][nx] == 0) {
                    dfs(ny, nx);
                }
            }
        }
    }
}
