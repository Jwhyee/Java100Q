import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static int[] dp;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 회사 직원 수
        N = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 최초의 칭찬 횟수
        M = Integer.parseInt(st.nextToken());

        // 직원 그래프 초기화
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            // 직속 상사 번호
            int boss = Integer.parseInt(st.nextToken());
            if (boss == -1) {
                continue;
            }
            graph[boss].add(i);
        }

        // 칭찬 누적 배열
        dp = new int[N + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int employee = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            dp[employee] += cnt;
        }

        visited = new boolean[N + 1];
        dfs(1);

        for (int i = 1; i <= N; i++) {
            bw.append(dp[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    private static void dfs(int employee) {
        for (Integer i : graph[employee]) {
            dp[i] += dp[employee];
            dfs(i);
        }
    }
}
