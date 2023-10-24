import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Node>[] lists;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        lists = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int point = Integer.parseInt(st.nextToken());

            lists[child].add(new Node(parent, point));
            lists[parent].add(new Node(child, point));
        }

        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            max = Math.max(dfs(i), max);
        }

        System.out.println(max);
    }

    private static int dfs(int nodeNum) {
        visited[nodeNum] = true;
        int maxSum = 0;

        for (Node node : lists[nodeNum]) {
            if (!visited[node.linked]) {
                int s = dfs(node.linked) + node.point;
                maxSum = Math.max(maxSum, s);
            }
        }

        return maxSum;
    }

    private static class Node {
        int linked, point;

        public Node(int linked, int point) {
            this.linked = linked;
            this.point = point;
        }
    }
}