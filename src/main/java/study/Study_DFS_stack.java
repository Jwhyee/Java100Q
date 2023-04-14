package study;

import java.util.Stack;

public class Study_DFS_stack {

    static int n = 3;
    static int[][] computers = {
            {1, 1, 0},
            {1, 1, 1},
            {0, 1, 1}
    };

    // 방문처리에 사용 할 배열선언
    static boolean[] visited = new boolean[n];

    // DFS 사용 할 스택
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {

        int answer = 0;

        // 시작 노드를 스택에 넣어줍니다.
        stack.push(computers[0][0]);
        // 시작 노드 방문처리
        visited[1] = true;

        // 스택이 비어있지 않으면 계속 반복
        while(!stack.isEmpty()) {

            // 스택에서 하나를 꺼냅니다.
            int nodeIndex = stack.pop();

            answer++;

            // 꺼낸 노드와 인접한 노드 찾기
            for (int linkedNode : computers[nodeIndex]) {
                // 인접한 노드를 방문하지 않았을 경우에 스택에 넣고 방문처리
                if(!visited[linkedNode]) {
                    stack.push(linkedNode);
                    visited[linkedNode] = true;
                }
            }
        }
        System.out.println("answer = " + answer);
    }
}
/*

import java.util.Arrays;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(computers, visited, i);
                answer++;
            }
        }
        return answer;
    }

    public void dfs(int[][] computers, boolean[] visited, int node) {
        visited[node] = true;
        for(int i = 0; i < computers.length; i++) {
            if(computers[node][i] == 1 && !visited[i]) {
                dfs(computers, visited, i);
            }
        }
    }
}

* */