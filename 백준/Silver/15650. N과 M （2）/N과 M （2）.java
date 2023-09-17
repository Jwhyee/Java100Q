import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 제목 : N과 M(2) [실버3]
 * 시간 : 1 ms
 * 메모리 : 1 KB
 * 링크 : https://www.acmicpc.net/problem/15650
 * */
public class Main {
    static int N, M;
    static boolean[] visited;
    static int[] values;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        values = new int[M];
        visited = new boolean[N + 1];

        backDfs(0);

        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean backDfs(int depth) throws IOException {

        // 현재 깊이가 출력해야하는 개수와 동일하다면 출력
        if (depth == M) {
            for (int value : values) {
                bw.append(value + " ");
            }
            bw.append("\n");
            return false;
        }


        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                values[depth] = i + 1;
                backDfs(depth + 1);
                for (int j = i + 1; j <= N; j++) {
                    visited[j] = false;
                }
            }
        }

        return true;
    }
}
