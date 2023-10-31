package algo.baekjoon.basic.math;

import java.io.*;
import java.util.StringTokenizer;

public class CumulativeSum_11659 {
    public static void main(String[] args) throws IOException {
        /*
        * 첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다.
        * 둘째 줄에는 N개의 수가 주어진다. 수는 1,000보다 작거나 같은 자연수이다.
        * 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.
        * 5 3
        * 5 4 3 2 1
        * 1 3
        * 2 4
        * 5 5
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 수의 개수
        int M = Integer.parseInt(st.nextToken());   // 구해야하는 횟수
        long[] arr = new long[N + 1];
        long[] sum = new long[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(st.nextToken());

            if (i == 1) {   // 누적 합
                sum[i] = arr[i];
            } else {
                sum[i] = sum[i - 1] + arr[i];
            }
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (start == 1) {
                bw.write(sum[end] + "\n");
            } else {
                bw.write(sum[end] - sum[start - 1] + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
