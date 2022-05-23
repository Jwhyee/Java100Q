package baekjoon.string;

import java.io.*;

public class String_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int[] arr = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
            sum += arr[i];
        }
        System.out.print(sum);

        bw.flush();
        bw.close();
        br.close();
    }
}
