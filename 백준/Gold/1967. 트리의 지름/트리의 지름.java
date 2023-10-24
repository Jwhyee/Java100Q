import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 문제 이름(난이도) : 트리의 지름 (SIL4)
 * 시간 : 3012 ms
 * 메모리 : 129188 KB
 * 링크 : https://www.acmicpc.net/problem/1967
 */
public class Main {
    static int N;
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

        // 최대값 탐색
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            if (lists[i].size() == 1) {
                // 방문 배열 초기화 후 최대값 탐색
                visited = new boolean[N + 1];
                max = Math.max(dfs(i), max);
            }

        }

        System.out.println(max == Integer.MIN_VALUE ? 0 : max);
    }

    private static int dfs(int nodeNum) {
        // 노드 방문 처리
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