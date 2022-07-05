package main.baekjoon.control_flow;

import java.io.IOException;
import java.util.Scanner;

public class CF_for_10871 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] intArray = new int[n];

        for (int i = 0; i < n; i++) {
            intArray[i] = sc.nextInt();
        }
        sc.close();

        for (int i = 0; i < n; i++) {
            if (intArray[i] < 5) {
                System.out.print(intArray[i] + " ");
            }
        }
    }
}
