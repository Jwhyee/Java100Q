package study.sort;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr) {
        sort(arr, 0, arr.length);
    }

    private static void sort(int[] arr, int low, int high) {
        System.out.println(Arrays.toString(arr));
        if (high - low < 2) {
            return;
        }

        int mid = (low + high) / 2;
        sort(arr, 0, mid);
        System.out.println(Arrays.toString(arr));
        sort(arr, mid, high);
        System.out.println(Arrays.toString(arr) + "right");
        merge(arr, low, mid, high);
        System.out.println(Arrays.toString(arr));
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        System.out.println(Arrays.toString(arr));
        int[] temp = new int[high - low];
        int t = 0, l = low, h = mid;

        while (l < mid && h < high) {
            if (arr[l] < arr[h]) {
                temp[t++] = arr[l++];
                System.out.println(Arrays.toString(arr));
            } else {
                temp[t++] = arr[h++];
                System.out.println(Arrays.toString(arr));
            }
        }

        while (l < mid) {
            temp[t++] = arr[l++];
            System.out.println(Arrays.toString(arr));
        }

        while (h < high) {
            temp[t++] = arr[h++];
            System.out.println(Arrays.toString(arr));
        }

        for (int i = low; i < high; i++) {
            arr[i] = temp[i - low];
            System.out.println(Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] a = {0, 4, 2, 7, 6, 1, 3, 5};
        mergeSort(a);
        System.out.println("a = " + Arrays.toString(a));
    }
}
