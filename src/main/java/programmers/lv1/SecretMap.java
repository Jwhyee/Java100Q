package programmers.lv1;

import java.util.Arrays;

public class SecretMap {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] map1 = new String[n];
        String[] map2 = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = "";
            map1[i] = String.format("%0"+n+"d", Long.parseLong(Integer.toBinaryString(arr1[i])));
            map2[i] = String.format("%0"+n+"d", Long.parseLong(Integer.toBinaryString(arr2[i])));
        }
        System.out.println(Arrays.toString(map1));
        System.out.println(Arrays.toString(map2));
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < n; j++) {
                if (map1[i].charAt(j) == '0' && map2[i].charAt(j) == '0') {
                    answer[i] += " ";
                } else {
                    answer[i] += "#";
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        System.out.println(Arrays.toString(solution(n, arr1, arr2)));
    }
}
