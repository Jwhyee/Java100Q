package algo.programmers.lv1;

import java.util.Arrays;
import java.util.Collections;

public class DescSort {
    public long solution(long n) {
        long answer = 0;
        String number = String.valueOf(n);
        String[] numberArr = number.split("");
        Arrays.sort(numberArr, Collections.reverseOrder());
        answer = Long.parseLong(String.join("", numberArr));
        return answer;
    }
    public static void main(String[] args) {
        DescSort ds = new DescSort();
        System.out.println(ds.solution(118372));
    }
}
