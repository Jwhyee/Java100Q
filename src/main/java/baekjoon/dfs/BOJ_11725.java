package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 제목 : 트리의 부모 찾기 [실버2]
 * 시간 : 652 ms
 * 메모리 : 73144 KB
 * */
public class BOJ_11725 {
    static int N;
    static ArrayList<Integer>[] matrix;
    static boolean[] visited;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        // 지도 초기화
        matrix = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            matrix[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            matrix[from].add(to);
            matrix[to].add(from);
        }

        visited = new boolean[N + 1];
        parent = new int[N + 1];
        dfs(1);

        for (int i = 2; i <= N; i++) {
            bw.append(parent[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();


    }

    private static void dfs(int cur) {
        Stack<Integer> stack = new Stack<>();
        stack.push(cur);

        while (!stack.isEmpty()) {
            Integer current = stack.pop();

            visited[current] = true;

            for (Integer next : matrix[current]) {
                if (!visited[next]) {
                    stack.push(next);
                } else {
                    continue;
                }
                parent[next] = current;
            }
        }
    }
}
