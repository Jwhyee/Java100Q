package LikeLionCodeTest.firstTest;

public class Fibonacci {
    static long evenSum;
    public static void main(String[] args) {
        final int MAX = 50000000;
        fibonacci(MAX);
        System.out.println("evenSum = " + evenSum);
    }

    public static int fibonacci(int N){
        if (N <= 0) return 0;
        if (N <= 1) return 1;
        if(N % 2 == 0) evenSum += N;
        return fibonacci(N-2) + fibonacci(N-1);
    }
}
