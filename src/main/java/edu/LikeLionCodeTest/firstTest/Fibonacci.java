package edu.LikeLionCodeTest.firstTest;

public class Fibonacci {
    static long evenSum;
    public static void main(String[] args) {
        final int MAX = 50000000;
        fibonacci(MAX);
    }

    public static int fibonacci(int N){
        int sum = 0;

        int i1 = 0;
        int i2 = 1;
        int i3 = 0;

        while ( i3 < 50000000 ) {
            sum += i3 % 2 == 0 ? i3 : 0;
            i3 = i1 + i2;

            i1 = i2;
            i2 = i3;

            System.out.println(sum);
        }

        return sum;
    }
}
