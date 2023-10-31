package algo.baekjoon.tree;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Tree_1991 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Node> nodeMap = new LinkedHashMap<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            Node parentNode = nodeMap.getOrDefault(parent, new Node(parent));

            String left = st.nextToken();
            Node leftNode = null;
            if (!left.equals(".")) {
                leftNode = nodeMap.getOrDefault(left, new Node(left));
            }

            String right = st.nextToken();
            Node rightNode = null;
            if (!right.equals(".")) {
                rightNode = nodeMap.getOrDefault(right, new Node(right));
            }
            parentNode.leftNode = leftNode;
            parentNode.rightNode = rightNode;

            nodeMap.put(parent, parentNode);
            nodeMap.put(left, leftNode);
            nodeMap.put(right, rightNode);
        }


        preOrder(nodeMap.get("A"));
        bw.append("\n");
        inOrder(nodeMap.get("A"));
        bw.append("\n");
        postOrder(nodeMap.get("A"));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void preOrder(Node node) throws IOException {
        if (node == null) {
            return;
        }
        bw.append(node.alphabet);
        preOrder(node.leftNode);
        preOrder(node.rightNode);
    }

    private static void inOrder(Node node) throws IOException {
        if (node == null) {
            return;
        }
        inOrder(node.leftNode);
        bw.append(node.alphabet);
        inOrder(node.rightNode);
    }

    private static void postOrder(Node node) throws IOException {
        if (node == null) {
            return;
        }
        postOrder(node.leftNode);
        postOrder(node.rightNode);
        bw.append(node.alphabet);
    }

    static class Node {
        String alphabet;
        Node leftNode;
        Node rightNode;

        public Node(String alphabet, Node leftNode, Node rightNode) {
            this.alphabet = alphabet;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

        public Node(String alphabet) {
            this.alphabet = alphabet;
        }

    }
}
