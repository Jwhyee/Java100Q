package algo.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 제목 : N과 M(10) [실버2]
 * 시간 : 76 ms
 * 메모리 : 11568 KB
 * 링크 : https://www.acmicpc.net/problem/15664
 * */
public class BOJ_15664 {
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
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.valueOf(st.nextToken());
            numArr[i] = n;
            max = Math.max(max, n);
        }

        Arrays.sort(numArr);


        br.close();

        backDfs(0, 0);

        System.out.println(sb.toString());
    }

    private static void backDfs(int at, int depth) {
        if (depth == M) {
            for (int value : values) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
            return;
        }

        int before = 0;
        for (int i = at; i < N; i++) {
            if (visited[i]) {
                continue;
            }

            if (before != numArr[i]) {
                visited[i] = true;
                values[depth] = numArr[i];
                before = numArr[i];
                backDfs( i + 1, depth + 1);
                visited[i] = false;
            }
        }

    }
}
