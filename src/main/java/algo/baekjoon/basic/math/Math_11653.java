package algo.baekjoon.basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 제목 : 소인수분해(브론즈1)
 * 링크 : https://www.acmicpc.net/problem/11653
 * 메모리 : 14296KB
 * 시간 : 128ms
 */
public class Math_11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for (int i = 2; i <= Math.sqrt(num); i++) {
            while (num % i == 0) {
                System.out.println(i);
                num /= i;
            }
        }
        if (num != 1) {
            System.out.println(num);
        }
    }
}
