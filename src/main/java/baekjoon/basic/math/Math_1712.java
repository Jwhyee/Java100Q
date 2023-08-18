package baekjoon.basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math_1712 {
    public static void main(String[] args) throws IOException {
        /*
        https://st-lab.tistory.com/71
        순익 분기점
        입력값 : 1000 70 170
        기대값 : 11
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        // 불변 비용
        int b = Integer.parseInt(st.nextToken());
        // 가변 비용
        int c = Integer.parseInt(st.nextToken());
        // 생산 수량
        if (c <= b) {
            System.out.println(-1);
        } else {
            System.out.println(a/(c-b) + 1);
        }



    }
}
