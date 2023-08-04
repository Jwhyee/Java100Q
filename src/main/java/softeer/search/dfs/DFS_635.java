package softeer.search.dfs;

import java.util.*;
import java.io.*;

/**
 * 문제 이름(난이도) : [21년 재직자 대회 본선] 거리 합 구하기(LV3)
 * 시간 : 1719 ms
 * 메모리 : 100.21 MB
 * 링크 : https://softeer.ai/practice/info.do?idx=1&eid=635
 * 풀이 참고 : https://velog.io/@ajongs/%EC%86%8C%ED%94%84%ED%8B%B0%EC%96%B4-%EC%9D%B8%EC%A6%9D%ED%8F%89%EA%B0%803%EC%B0%A8-%EA%B8%B0%EC%B6%9C-%ED%94%8C%EB%A0%88%EC%9D%B4%ED%8E%98%EC%96%B4-%EC%95%94%ED%98%B8
 */
public class DFS_635 {
    static int N;
    static List<Node>[] nodes;
    static long[] subtree;
    static long[] sum;
    static long[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        nodes = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N -1; i++) {
            String[] str = br.readLine().split(" ");
            int parent = Integer.parseInt(str[0]);
            int child = Integer.parseInt(str[1]);
            int cost = Integer.parseInt(str[2]);

            nodes[parent].add(new Node(child, cost));
            nodes[child].add(new Node(parent, cost));
        }

        subtree = new long[N + 1];
        sum = new long[N + 1];

        dfs1(1, 0);
        dfs2(1, 0);

        for (int i = 1; i <= N; i++) {
            System.out.println(sum[i]);
        }

    }

    private static void dfs1(int current, int parent) {
        subtree[current] = 1;

        for(Node n : nodes[current]) {
            int child = n.u;
            int cost = n.cost;

            if(child != parent) {
                dfs1(child, current);
                sum[current] += sum[child] + subtree[child] * cost;
                subtree[current] += subtree[child];
            }
        }
    }

    private static void dfs2(int current, int parent) {
        for(Node n : nodes[current]) {
            int child = n.u;
            int cost = n.cost;

            if(child != parent) {
                sum[child] = sum[current] + cost * (N - 2 * subtree[child]);
                dfs2(child, current);
            }
        }
    }

    static class Node {
        int u, cost;
        public Node (int u, int cost) {
            this.u = u;
            this.cost = cost;
        }
    }
}
