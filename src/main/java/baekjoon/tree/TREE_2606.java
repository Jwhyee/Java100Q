package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TREE_2606 {
    static int sum = 0;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computers = Integer.parseInt(br.readLine());
        Node[] arr = new Node[computers + 1];
        visited = new boolean[computers + 1];
        Arrays.fill(arr, null);
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int root = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            Node rootNode = new Node(root);
            if (arr[root] != null) {
                rootNode = arr[root];
            }
            Node childNode = new Node(child);
            if (arr[child] != null) {
                childNode = arr[child];
            }
            rootNode.addNode(childNode);
            arr[root] = rootNode;
            arr[child] = childNode;
        }

        preOrder(arr[1]);
        System.out.println(sum - 1);
    }

    public static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        // 방문하지 않은 노드일 경우
        if (!visited[node.id]) {
            visited[node.id] = true;
            sum++;
        } else {
            return;
        }

        preOrder(node.leftNode);
        preOrder(node.rightNode);

    }

    public static class Node {
        int id;
        int count;
        Node leftNode;
        Node rightNode;

        public Node(int id) {
            this.id = id;
            this.count = 0;
            this.leftNode = null;
            this.rightNode = null;
        }

        public void addNode(Node node) {
            if (leftNode == null) {
                this.leftNode = node;
            } else if (rightNode == null) {
                this.rightNode = node;
            } else {
                return;
            }
            count++;
        }
    }
}
