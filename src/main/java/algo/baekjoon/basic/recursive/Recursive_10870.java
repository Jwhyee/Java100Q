package algo.baekjoon.basic.recursive;

import java.util.Scanner;

public class Recursive_10870 {
    public static void main(String[] args) {
        // 피보나치수 의미
        // 10이 입력된다고 가정
        // 0, 1을 더하면 결과값 = 1 | 결과값 1 + 이전 결과 값 1 = 2 | 결과값 2 + 이전 결과 값 1 = 3
        // 결과값 3 + 이전 결과 값 2 = 5 | 결과값 5 + 이전 결과값 3 = 8 | 결과값 8 + 이전 결과 값 5 = 13
        // 결과값 13 + 이전 결과 값 8 = 21 | 결과값 21 + 이전 결과 값 13 = 34...
        // 피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.close();

        int sum = fibonacci(N);
        System.out.println(sum);
    }
    public static int fibonacci(int N){
        if (N <= 0) return 0;
        if (N <= 1) return 1;

        return fibonacci(N-2) + fibonacci(N-1);
    }
}
