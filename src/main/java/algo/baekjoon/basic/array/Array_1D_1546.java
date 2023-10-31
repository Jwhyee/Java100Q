package algo.baekjoon.basic.array;

import java.util.Scanner;

public class Array_1D_1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] score = new double[n];
        double[] new_score = new double[n];

        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
        }

        double max = 0;
        for (int i = 0; i < n; i++) {
            if (score[i] > max) {
                max = score[i];
            }
        }


        double sum = 0;
        for (int i = 0; i < n; i++) {
            new_score[i] = (score[i]/max)*100;
            sum += new_score[i];
        }
        System.out.println(sum/n);
    }
}
