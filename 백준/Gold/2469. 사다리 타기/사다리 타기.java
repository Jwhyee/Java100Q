import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int K, N, line = -1;
    static char[] player, result;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 플레이어 수
        K = Integer.parseInt(br.readLine());
        // 사다리 라인
        N = Integer.parseInt(br.readLine());

        player = new char[K];

        // 플레이어
        for (int i = 0; i < K; i++) {
            player[i] = (char) (65 + i);
        }

        result = br.readLine().toCharArray();

        // 지도 초기화
        map = new char[N][K - 1];
        for (int i = 0; i < N; i++) {
            char[] charArray = br.readLine().toCharArray();

            if (charArray[0] == '?') {
                line = i;
                continue;
            }

            map[i] = charArray;
        }

        for (int i = 0; i < line; i++) {
            changePlayer(i, player);
        }

        for (int i = N - 1; i > line; i--) {
            changePlayer(i, result);
        }

        String answer = "";
        boolean isFail = false;
        for (int i = 0; i < K - 1; i++) {
            if (player[i] == result[i]) {
                bw.append("*");
            } else if (player[i] == result[i + 1]) {
                bw.append("-");
                char p = player[i];
                player[i] = player[i + 1];
                player[i + 1] = p;
            } else {
                isFail = true;
                break;
            }
        }

        if (isFail) {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            for (int i = 0; i < K - 1; i++) {
                bw.append("x");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void changePlayer(int i, char[] arr) {
        for (int j = 0; j < K - 1; j++) {
            if (map[i][j] == '-') {
                char p = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = p;
            }
        }
    }
}