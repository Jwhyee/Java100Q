package algo.baekjoon.basic.array;

import java.util.Scanner;

public class Array_1D_2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        // a, b, c에 대한 값 입력 받기

        int cnt = 0;
        // 0~9까지 수가 몇개 있는지 카운트하는 변수

        int multiple = a * b * c;
        String str = Integer.toString(multiple);
        // 입력 받은 a, b, c를 곱한 뒤 문자열로 변경

        int[] num = new int[10];
        for (int i = 0; i < 10; i++) {
            num[i] = num[i] + i;
        }
        // num 배열 각 방에 0~9까지 입력

        for (int i = 0; i < 10; i++) {
            // Outer Loop에서는 0~9를 출력하여 Inner Loop와 비교
            for (int j = 0; j < str.length(); j++) {
                // Inner Loop에서는 문자열의 길이만큼 반복하여 문자열에 0~9까지가 몇 개씩 존재하는지 판별
                if (Integer.parseInt(String.valueOf(str.charAt(j))) == num[i]) {
                    // charAt[j]를 사용하여 num[i]번째와 같은게 몇개 있는지 검색
                    cnt++;
                    // 존재하면 cnt ++
                }
            }
            System.out.println(cnt);
            cnt = 0;
        }
    }
}
