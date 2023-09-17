package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 제목 : N과 M(7) [실버3]
 * 시간 : 620 ms
 * 메모리 : 220924 KB
 * 링크 : https://www.acmicpc.net/problem/15656
 * */
public class BOJ_15656 {
    static int N, M, max;
    static boolean[] visited;
    static int[] values, numArr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        values = new int[M];
        numArr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.valueOf(st.nextToken());
            numArr[i] = n;
            max = Math.max(max, n);
        }
        Arrays.sort(numArr);

        visited = new boolean[max + 1];

        br.close();

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
            values[depth] = numArr[i];
            backDfs(depth + 1);
            visited[i] = false;
        }

    }
}
