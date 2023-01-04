package programmers.lv0;

import java.util.Arrays;

public class Make2DArray {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length / n][n];
        int i = 0, j = 0;

        for (int num : num_list) {
            answer[i][j++] = num;
            if(j == n) {i++; j = 0;}
        }

        return answer;
    }
    public static void main(String[] args) {
        Make2DArray m = new Make2DArray();
        int[] num_list = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = 2;
        System.out.println(Arrays.deepToString(m.solution(num_list, n)));
    }
}
