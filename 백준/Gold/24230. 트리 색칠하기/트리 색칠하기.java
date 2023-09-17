import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제 이름(난이도) : 트리 색칠하기(GOL4)
 * 시간 : 1 ms
 * 메모리 : 1 KB
 * 링크 : https://www.acmicpc.net/problem/24230
 */
public class Main {
    static int N;
    static int[] target;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        target = new int[N + 1];
        list = new ArrayList[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            target[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int top = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            list[top].add(child);
            list[child].add(top);
        }

        System.out.println(dfs(1, 0));
    }

    private static int dfs(int now, int parent) {
        int allSum = target[now] == target[parent] ? 0 : 1;
        for (int next : list[now]) {
            if (next == parent) continue;
            allSum += dfs(next, now);
        }
        return allSum;
    }
}
