package edu.LikeLionCodeTest.firstTest;

public class MultipleThreeFive {
    public static void main(String[] args) {
        long sum = 0;
        for (int i = 1; i <= 100000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        System.out.println("sum = " + sum);
    }
}
