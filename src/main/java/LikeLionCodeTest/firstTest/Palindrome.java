package LikeLionCodeTest.firstTest;

import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        int max = 0;

        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10000; j++) {
                int num = i * j;

                String numStr = String.valueOf(i * j);
                if (isPalindrome(num)) {
                    if (max < num) {
                        max = num;
                    }
                }
            }
        }
        System.out.println("max = " + max);
    }

    private static boolean isPalindrome(int num) {
        String numStr = num + "";
        int halfLen = numStr.length() / 2;
        for (int i = 0; i < halfLen; i++) {
            int backIdx = numStr.length() - 1 - i;
            if (numStr.charAt(i) != numStr.charAt(backIdx)) {
                return false;
            }
        }
        System.out.println("num = " + num);
        return true;
    }
}
