package softeer.search.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제 이름(난이도) : 장애물 인식 프로그램(LV2)
 * 시간 : 81 ms
 * 메모리 : 10.68 MB
 * 링크 : https://softeer.ai/practice/info.do?idx=1&eid=409&sw_prbl_sbms_sn=232807
 */
public class DFS_409 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, cnt;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            char[] split = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = split[j] - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    cnt = 0;
                    dfs(i, j);
                    list.add(cnt);
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    public static void dfs(int y, int x) {
        cnt++;
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (!visited[ny][nx] && map[ny][nx] == 1) {
                    dfs(ny, nx);
                }
            }
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void showMatrix() {
        Arrays.stream(visited)
                .map(Arrays::toString)
                .forEach(System.out::println);
        System.out.println("----------------");
    }
}
