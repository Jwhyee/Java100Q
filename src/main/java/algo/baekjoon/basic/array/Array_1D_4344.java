package algo.baekjoon.basic.array;

import java.io.*;
import java.util.StringTokenizer;

public class Array_1D_4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int c = Integer.parseInt(br.readLine());



        for (int i = 0; i < c; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            double sum = 0;
            double cnt = 0;
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                sum += arr[j];
            }
            double avg = sum / n;
            for (int k = 0; k < n; k++) {
                if (arr[k] > avg) {
                    cnt++;
                }
            }
            double result = cnt / n * 100;
            bw.write(String.format("%.3f", result) + "%" + "\n");
        }
        bw.flush();

        bw.close();
        br.close();
    }
}
