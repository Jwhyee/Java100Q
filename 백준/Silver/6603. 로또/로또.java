import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static boolean[] visited;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        while (true) {
            String s = br.readLine();
            if(s.equals("0")) break;

            st = new StringTokenizer(s);
            n = Integer.parseInt(st.nextToken());

            arr = new int[n];
            visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            backTracking(0, 0);

            bw.append("\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }
    private static void backTracking(int depth, int cnt) throws IOException {
        if (cnt == 6) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    bw.append(arr[i] + " ");
                }
            }
            bw.append("\n");
        }

        for (int i = depth; i < n; i++) {
            visited[i] = true;

            backTracking(i + 1, cnt + 1);

            visited[i] = false;
        }
    }
}
