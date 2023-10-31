package edu.LikeLionCodeTest.firstTest;

public class PrimeFactor {
    public static void main(String[] args) {
        long NUM = 1600851475143L;
        for (int i = 2; i < Math.sqrt(NUM); i++) {
            while (NUM % i == 0) {
                NUM /= i;
            }
        }
        if (NUM != 1) {
            System.out.println("NUM = " + NUM);
        }
    }
}
