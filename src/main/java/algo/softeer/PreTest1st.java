package algo.softeer;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
6
0 1 1 0 0 0
0 1 1 0 1 1
0 0 0 0 1 1
0 0 0 0 1 1
1 1 0 0 1 0
1 1 1 0 0 0
*/
class PreTest1st {
    static int lines, count, areaCount;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] area;
    static boolean[][] visited;
    final static int[] dx = {1, 0, -1, 0, -1, 1, -1, 1};
    final static int[] dy = {0, 1, 0, -1, -1, 1, 1, -1};

    public static void print(){
        for(int i = 0; i < area.length; i++){
            for(int j = 0; j < area[i].length; j++){
                System.out.print(area[i][j]);
            }
            System.out.println();
        }
    }

    public static void bfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < lines && ny >= 0 && ny < lines) {
                if (area[nx][ny] == 1 && !visited[nx][ny]) {
                    count++;
                    bfs(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        lines = Integer.parseInt(br.readLine());
        area = new int[lines][lines];
        visited = new boolean[lines][lines];
        List<Integer> answerList = new ArrayList<>();
        for(int h = 0; h < lines; h++){
            String[] info = br.readLine().split(" ");
            for (int w = 0; w < area[h].length; w++) {
                area[h][w] = Integer.parseInt(info[w]);
            }
        }
        areaCount = 0;
        for (int i = 0; i < lines; i++) {
            count = 0;
            for (int j = 0; j < lines; j++) {
                if (area[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                    count++;
                    areaCount++;
                }
            }
            if(count != 0) answerList.add(count);
        }
        System.out.println(areaCount);
        Collections.sort(answerList);
        System.out.println(answerList.toString().replace("[","").replace("]","").replace(",", ""));
    }
}