import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[][] points = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            points[i] = new int[]{s, e};
        }

        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));

        int range = 0, answer = 0;

        for (int[] point : points) {
            if (point[0] > range) {
                range = point[0];
            }
            if (point[1] > range) {
                while (point[1] > range) {
                    range += L;
                    answer++;
                }
            }
        }

        System.out.println(answer);
        br.close();
    }
}
