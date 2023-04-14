package programmers.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistance {

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    int n, m;
    boolean[][] visited;

    static class Node{
        int x;
        int y;
        int cost;

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];

        return bfs(0, 0, maps);
    }

    public int bfs(int x, int y, int[][] maps) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y, 1));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.x == n - 1 && node.y == m - 1) {
                return node.cost;
            }
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.offer(new Node(nx, ny, node.cost + 1));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ShortestDistance sd = new ShortestDistance();
        int[][] maps = {{1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1},
                        {1, 1, 1, 0, 1},
                        {0, 0, 0, 0, 1}};
        System.out.println(sd.solution(maps));
    }
}
