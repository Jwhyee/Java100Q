package algo.programmers.lv3;

public class Network {
    /*
    *       1
    *     /
    *   2  ㅡㅡㅡ  3
    *
    *   A   B   C
    *  -----------
    *   1   1   0
    *   1   1   1
    *   0   1   1
    * */
    public static int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n];
        // 노드 간선의 수만 확인하면 되기 때문에 1차원 boolean 배열 생성

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                // 방문하지 않은 노드에 대해 dfs를 진행하고, answer 증가
                dfs(computers, visited, i);
                answer++;
            }
        }
        return answer;
    }

    public static void dfs(int[][] computers, boolean[] visited, int node) {
        visited[node] = true;
        // 전달 받은 노드에 방문 표시

        for(int i = 0; i < computers.length; i++) {
            if(computers[node][i] == 1 && !visited[i]) {
                // 아직 방문하지 않았으며, 좌표의 값이 1이면 dfs를 진행
                dfs(computers, visited, i);
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
//        int n = 3;
        int[][] computer = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
//        int[][] computer = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println(solution(n, computer));
    }
}
