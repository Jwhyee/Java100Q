package LikeLionCodeTest.firstTest;

import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10000; i++) {
            System.out.println("i = " + i);
            for (int j = 0; j < 10000; j++) {
                int num = i * j;
                String numStr = String.valueOf(i * j);
                if (numStr.charAt(0) == numStr.charAt(3) && numStr.charAt(1) == numStr.charAt(2)) {
                    if (max < num) {
                        max = num;
                    }
                }
            }
        }
        System.out.println("max = " + max);
    }
}
