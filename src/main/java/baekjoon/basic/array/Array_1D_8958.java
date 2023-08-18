package baekjoon.basic.array;

import java.util.Scanner;

public class Array_1D_8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] arr = new String[num];
        for (int i = 0; i < num; i++) {
            arr[i] = sc.next();
        }
        for (int i = 0; i < num; i++) {
            int sum = 0, score = 1;
            for (int j = 0; j < arr[i].length(); j++) {
                if (arr[i].charAt(j) == 'O') {
                    sum += score;
                    score++;
                } else {
                    score = 1;
                }
            }
            System.out.println(sum);
        }
    }
}
