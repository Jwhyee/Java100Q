package main.baekjoon.sort;

import java.io.*;

public class Sort_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] count = new int[10001];
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            count[input]++;
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 10000; i++) {
            for (int j = 0; j < count[i]; j++) {
                sb.append(i + "\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
