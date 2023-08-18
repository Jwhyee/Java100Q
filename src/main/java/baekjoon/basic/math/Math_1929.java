package baekjoon.basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 제목 : 소수 구하기(실버3)
 * 링크 : https://www.acmicpc.net/problem/1929
 * 메모리 : 28920KB
 * 시간 : 1288ms
 */
public class Math_1929 {
    public static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        for (int i = m; i <= n; i++) {
            if(i == 1 || i == 0) continue;
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }
}
