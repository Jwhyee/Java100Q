package programmers.lv1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SumMissingNumber {
    public int solution(int[] numbers) {
        int answer = 0;
        List<Integer> answerList = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        for (int i = 0; i < 10; i++) {
            if(!answerList.contains(i)) answer += i;
        }
        return answer;
    }
    public static void main(String[] args) {
        SumMissingNumber smn = new SumMissingNumber();
//        int[] numbers = {1, 2, 3, 4, 6, 7, 8, 0};
        int[] numbers = {5,8,4,0,6,7,9};
        System.out.println(smn.solution(numbers));
    }
}
