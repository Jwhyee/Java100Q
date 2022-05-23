package baekjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math_1978 {
    public static void main(String[] args) throws IOException {
        // 소수가 몇 개인지 찾는 알고리즘
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(st.nextToken());
            boolean isPrime = true;
            if(k == 1) continue;
            for (int j = 2; j <= Math.sqrt(k); j++) {
                if (k % j == 0) isPrime = false;
            }
            if(isPrime) cnt++;
        }
        System.out.println(cnt);
    }
}
