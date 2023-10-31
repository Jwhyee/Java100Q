import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final int[] dx = {1, -1, 0, 0}, dy= {0, 0, 1, -1};
    private static int n, m;
    private static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bfr.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        int sx = 0, sy = 0;
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(bfr.readLine());
            for (int j = 0; j < m; ++j) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) {
                    sx = i;
                    sy = j;
                } else if (board[i][j] == 1) {
                    board[i][j] = -1;
                }
            }
        }

        BFS(sx, sy);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j)
                sb.append(board[i][j]).append(' ');
            sb.append('\n');
        }

        System.out.print(sb);
    }
    private static void BFS(int sx, int sy) {
        board[sx][sy] = 0;
        boolean[][] visited = new boolean[n][m];
        visited[sx][sy] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(sx, sy));
        while (!queue.isEmpty()) {
            Node p = queue.poll();
            for (int d = 0; d < 4; ++d) {
                int nx = p.x + dx[d];
                int ny = p.y + dy[d];
                if (0 <= nx && nx < n && 0 <= ny && ny < m && board[nx][ny] != 0 && !visited[nx][ny]) {
                    board[nx][ny] = board[p.x][p.y] + 1;
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny));
                }
            }
        }
    }
    private static class Node {
        public int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}