package algo.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 제목 : N과 M(3) [실버3]
 * 시간 : 384 ms
 * 메모리 : 112460 KB
 * 링크 : https://www.acmicpc.net/problem/15651
 * */
public class BOJ_15651 {
    static int N, M;
    static boolean[] visited;
    static int[] values;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        values = new int[M];
        visited = new boolean[N];

        backDfs(0);
        System.out.println(sb.toString());
    }

    private static void backDfs(int depth) {
        if (depth == M) {
            for (int value : values) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            values[depth] = i + 1;
            backDfs(depth + 1);
            visited[i] = false;
        }
    }
}
