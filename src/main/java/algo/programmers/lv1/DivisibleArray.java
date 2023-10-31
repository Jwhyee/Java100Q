package algo.programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DivisibleArray {
    /**
     * @param arr 자연수를 담은 배열
     * @param divisor 나뉨수
     * @return 나누어 떨어지는 수 반환
    * */
    public int[] solution(int[] arr, int divisor) {
        List<Integer> answerList = new ArrayList<>();
        for (int j : arr) {
            if (j % divisor == 0) answerList.add(j);
        }
        if(answerList.size() == 0) answerList.add(-1);

        Collections.sort(answerList);
        return answerList.stream()
                .distinct()
                .mapToInt(i -> i)
                .toArray();
    }

    public static void main(String[] args) {
        DivisibleArray da = new DivisibleArray();
        int[] arr = {5, 9, 7, 10};
        int divisor = 5;
//        int[] arr = {2, 36, 1, 3};
//        int divisor = 1;
//        int[] arr = {3,2,6};
//        int divisor = 10;
        System.out.println(Arrays.toString(da.solution(arr, divisor)));
    }
}
