package main.baekjoon.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dp_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();
        int[] dp = new int[N];
        for (int i = 1; i <= N; i++) {
            if (dp[i] == 1) {
                break;
            }

        }
    }
}
