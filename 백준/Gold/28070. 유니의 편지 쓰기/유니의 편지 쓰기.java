import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 문제 이름(난이도) : 유니의 편지 쓰기 (GOL5)
 * 시간 : 444 ms
 * 메모리 : 69200 KB
 * 링크 : https://www.acmicpc.net/problem/28070
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dp = new int[120002];
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = parsing(st.nextToken());
            dp[s]++;

            int e = parsing(st.nextToken());
            dp[e + 1]--;
        }

        int max = 0, y = 0, m = 0;
        
        for (int i = 24000; i < 120001; i++) {
            dp[i] += dp[i - 1];
            if (dp[i] > max) {
                max = dp[i];
                y = i / 12;
                m = i % 12;
            }
        }

        if (m == 0) {
            y--;
            m = 12;
        }

        StringBuilder sb = new StringBuilder();
        if (m < 10) {
            sb.append(y).append('-').append(0).append(m);
        } else {
            sb.append(y).append('-').append(m);
        }

        bw.append(sb.toString());
        st = null;
        bw.flush();
        bw.close();
        br.close();
    }

    private static int parsing(String s) {
        StringTokenizer st = new StringTokenizer(s, "-");
        int y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = null;

        return (y * 12) + m;
    }
}
