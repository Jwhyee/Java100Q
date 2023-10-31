package algo.baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649 {

    static int N, M;
    static boolean[] visited;
    static int[] values;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 총 N개의 수가 존재
        visited = new boolean[N];

        // 한 줄에 M개의 수를 출력
        values = new int[M];

        backDfs(0);
    }

    private static void backDfs(int depth) {
        // 최대 깊이(출력할 숫자의 수)까지 도달하면 값 출력
        if (depth == M) {
            for (int value : values) {
                if (value != 0) {
                    System.out.print(value + " ");
                }
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                // 같은 수를 출력하지 않기 위해 현재 수에 대해 방문 처리
                visited[i] = true;

                // 현재 깊이에 대한 값을 i + 1해줌 (1부터 출력이기 때문)
                values[depth] = i + 1;

                // 다음 깊이로 이동
                backDfs(depth + 1);

                // 현재 수에 대한 방문 처리 해제
                visited[i] = false;
            }
        }

    }
}
