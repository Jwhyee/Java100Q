package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 문제 이름(난이도) : 단지 번호 붙이기(실버1)
 * 시간 : 136 ms
 * 메모리: 14224 KB
 * 링크 : https://www.acmicpc.net/problem/2667
 * */
public class DFS_2667 {
    static int[][] map;
    static boolean[][] visited;
    static int size;
    static int count = 0;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        size = Integer.parseInt(br.readLine());
        map = new int[size][size];
        visited = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < size; j++) {
                map[i][j] = arr[j] - '0';
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    dfs(i, j);
                    if (count != 0) {
                        list.add(count);
                    }
                    count = 0;
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
        visited[y][x] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny >= 0 && ny < size && nx >= 0 && nx < size) {
                if (!visited[ny][nx] && map[ny][nx] == 1) {
                    dfs(ny, nx);
                }
            }
        }
    }
}