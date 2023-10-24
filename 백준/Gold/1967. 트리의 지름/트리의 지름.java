import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, leafNode, result;
    static ArrayList<Node>[] lists;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        // 그래프 선언 및 초기화
        lists = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        // 부모 및 자식 노드 그래프에 추가
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int point = Integer.parseInt(st.nextToken());

            lists[child].add(new Node(parent, point));
            lists[parent].add(new Node(child, point));
        }

        visited = new boolean[N + 1];

        // 최대값 탐색
        dfs(1, 0);

        for (int i = 0; i <= N; i++) {
            visited[i] = false;
        }

        dfs(leafNode, 0);

        System.out.println(result);

        br.close();
    }

    private static void dfs(int nodeNum, int sum) {
        // 노드 방문 처리
        visited[nodeNum] = true;

        for (Node node : lists[nodeNum]) {
            // 방문하지 않은 자식 노드 탐색
            if (!visited[node.linked]) {
                dfs(node.linked, sum + node.point);
            }
        }

        if (result < sum) {
            result = sum;
            leafNode = nodeNum;
        }

    }

    private static class Node {
        int linked, point;

        public Node(int linked, int point) {
            this.linked = linked;
            this.point = point;
        }
    }
}