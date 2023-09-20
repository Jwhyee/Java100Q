import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int W, H, cnt;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new int[H][W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            int n = Integer.parseInt(st.nextToken());
            for (int j = H - n; j < H; j++) {
                map[j][i] = 1;
            }
        }

        int lastEmptyIdx = -1;
        for (int i = 0; i < H; i++) {
            int combo = 0;
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 0) {
                    if (combo == 0) {
                        lastEmptyIdx = j;
                    }
                    combo++;
                } else if (map[i][j] == 1) {
                    if (combo != 0) {
                        fillArray(i, j, lastEmptyIdx);
                    }
                    combo = 0;
                }
            }
        }

        System.out.println(cnt);
    }

    private static void fillArray(int y, int endX, int startX) {
        if (startX > 0 && map[y][startX - 1] == 1 && map[y][endX] == 1) {
            for (int i = startX; i < endX; i++) {
                cnt++;
            }
        }
    }

}
