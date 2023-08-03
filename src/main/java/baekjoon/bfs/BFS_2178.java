package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_2178 {

    // H : 배열의 높이, W : 배열의 길이
    static int H, W, result;

    // 주어진 길을 저장할 배열
    static int[][] map;

    // 방문했는지 확인하는 배열
    static boolean[][] visited;

    // 방향(direction)을 조절하는 배열
    // (x, y) 기준이며, 배열 기준 위쪽은 -1, 아래는 1임
    // 우(0, 1) -> 상(-1, 0) -> 좌(0, -1) -> 하(1, 0)
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 처음으로 입력 받은 4 6을 나눠 높이(H)와 길이(W)에 저장
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        // 지도 및 방문 배열 크기 지정
        map = new int[H][W];
        visited = new boolean[H][W];

        // 문제에 주어진대로 지도 그리기
        for (int i = 0; i < H; i++) {
            String s = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        // 0, 0을 기준으로 탐색 시작
        bfs(0, 0);
        System.out.println("result = " + result);
    }

    public static void bfs(int y, int x) {
        // 첫 좌표는 방문 완료
        visited[y][x] = true;

        // 방문할 노드들을 보관하는 큐
        Queue<Node> queue = new LinkedList<>();

        // 첫 시작점은 미리 큐에 추가
        queue.add(new Node(x, y, 1));

        // 큐가 비어있지 않다면 계속 진행
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            visited[now.y][now.x] = true;
            result = now.cost;
            for (int i = 0; i < 4; i++) {
                // 다음(next) 좌표 선정
                // 현재 좌표 + 방향을 선택해 다음 좌표를 선정함
                // 예) i가 0일 경우 : 현재 좌표에서 오른쪽 좌표 탐색
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                // 만약 다음 x 좌표가 0이상이고, W(지도 길이)보다 작고,
                // 만약 다음 y 좌표가 0이상이고, H(지도 높이)보다 작고,
                if (nx >= 0 && nx < W && ny >= 0 && ny < H) {

                    // 만약 다음 좌표를 방문하지 않았고, 길이라면
                    if (!visited[ny][nx] && map[ny][nx] == 1) {
                        // 큐에 추가
                        queue.add(new Node(nx, ny, now.cost + 1));
                    }

                }
            }
            showMatrix();
        }
    }

    // 탐색할 좌표를 보관할 노드
    static class Node {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public static void showMatrix() {
        Arrays.stream(visited)
                .map(Arrays::toString)
                .forEach(System.out::println);
        System.out.println("----------------");
    }
}