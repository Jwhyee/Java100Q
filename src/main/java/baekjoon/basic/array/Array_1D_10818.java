package baekjoon.basic.array;

import java.io.IOException;
import java.util.Scanner;

public class Array_1D_10818 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        int MAX = arr[0];
        int MIN = arr[0];

        for (int i = 0; i < n; i++) {

            if (MAX < arr[i]) {
                MAX = arr[i];
            } else if (MIN > arr[i]) {
                MIN = arr[i];
            }
        }
        System.out.println(MIN + " " + MAX);
    }
}
