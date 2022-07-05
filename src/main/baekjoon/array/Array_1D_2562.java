package main.baekjoon.array;

import java.util.Scanner;

public class Array_1D_2562 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int[] intArray = new int[9];
        int max = 0;
        int num = 0;

        for(int i = 0; i < 9; i++) {
            intArray[i] = sc.nextInt();
        }
        sc.close();

        for (int i = 0; i < 9; i++) {
            if (intArray[i] > max) {
                max = intArray[i];
                num = i;
            }
        }
        System.out.println(max);
        System.out.print(num + 1);
    }
}
