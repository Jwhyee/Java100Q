package algo.baekjoon.search.bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제 이름(난이도) : 블랙잭(브론즈3)
 * 시간 : 132 ms
 * 메모리: 14424 KB
 * 링크 : https://www.acmicpc.net/problem/2798
 * */
public class BF_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] cards = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = 0;

        for (int i = 0; i < N; i++) {
            int c1 = cards[i];
            for (int j = i + 1; j < N; j++) {
                int c2 = cards[j];
                for (int k = j + 1; k < N; k++) {
                    int c3 = cards[k];
                    int result = c1 + c2 + c3;
                    if (result <= M) {
                        sum = Math.max(sum, result);
                    }
                }
            }
        }

        System.out.println("sum = " + sum);
    }
}
