import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 제목 : N과 M(5) [실버3]
 * 시간 : 1 ms
 * 메모리 : 1 KB
 * 링크 : https://www.acmicpc.net/problem/15651
 * */
public class Main {
    static int N, M, max;
    static boolean[] visited;
    static int[] values;
    static List<Integer> numList = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        values = new int[M];

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int n = Integer.valueOf(st.nextToken());
            numList.add(n);
            max = Math.max(max, n);
        }
        Collections.sort(numList);
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

        for (int i : numList) {
            if (!visited[i]) {
                visited[i] = true;
                values[depth] = i;
                backDfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
