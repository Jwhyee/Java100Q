package main.baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class String_2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String[] arr = new String[2];
        int[] result = new int[2];
        for (int i = 0; i < 2; i++) {
            arr[i] = st.nextToken();
            result[i] = Integer.parseInt(new StringBuilder().append(arr[i]).reverse().toString());
        }
        System.out.println(result[0] > result[1] ? result[0] : result[1]);

        br.close();

    }
}
