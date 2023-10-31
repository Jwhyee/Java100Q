package algo.baekjoon.basic.recursive;

import java.util.Scanner;

public class Recursive_10872 {
    public static void main(String[] args) {
        // 팩토리얼의 의미
        // 10! = 10*9*8*7*6*5*4*3*2*1 을 의미한다.

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.close();

        int sum = factorial(N);
        System.out.println(sum);
    }
    public static int factorial(int N){
        if (N <= 1) return 1;
        return N * factorial(N - 1);
    }
}
