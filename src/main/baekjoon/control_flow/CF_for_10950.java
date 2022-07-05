package main.baekjoon.control_flow;

import java.io.IOException;
import java.util.Scanner;

public class CF_for_10950 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int a, b;

        for (int i = 0; i < T; i++) {
            a = sc.nextInt();
            b = sc.nextInt();

            System.out.println(a+b);
        }

    }
}
