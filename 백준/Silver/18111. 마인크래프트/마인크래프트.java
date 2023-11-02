import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int cur = map[i][j] = Integer.parseInt(st.nextToken());
                if(min > cur) min = cur;
                if(max < cur) max = cur;
            }
        }

        int time = Integer.MAX_VALUE, floor = Integer.MIN_VALUE;

        for (int i = min; i <= max; i++) {
            int cnt = 0, block = B;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (i < map[j][k]) {
                        cnt += (map[j][k] - i) * 2;
                        block += (map[j][k] - i);
                    } else {
                        cnt += (i - map[j][k]);
                        block -= (i - map[j][k]);
                    }
                }
            }

            if(block < 0) break;
            if (time >= cnt) {
                time = cnt;
                floor = i;
            }
        }
        System.out.println(time + " " + floor);
    }
}