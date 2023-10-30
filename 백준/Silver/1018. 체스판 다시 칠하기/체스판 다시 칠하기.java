import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] map;
    static int min = 64;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        map = new boolean[H][W];

        for (int i = 0; i < H; i++) {
            char[] charArray = br.readLine().toCharArray();
            for (int j = 0; j < W; j++) {
                char c = charArray[j];
                map[i][j] = (c == 'W');
            }
        }

        for (int i = 0; i < H - 7; i++) {
            for (int j = 0; j < W - 7; j++) {
                find(j, i);
            }
        }

        System.out.println(min);
    }

    private static void find(int x, int y) {
        int ex = x + 8, ey = y + 8, cnt = 0;

        boolean curColor = map[y][x];

        for (int i = y; i < ey; i++) {
            for (int j = x; j < ex; j++) {
                if (map[i][j] != curColor) {
                    cnt++;
                }
                curColor = (!curColor);
            }
            curColor = !curColor;
        }
        cnt = Math.min(cnt, 64 - cnt);
        min = Math.min(min, cnt);
    }
}