package programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SumTwoNumber {
    public int[] solution(int[] numbers) {
        Set<Integer> numberSet = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i != j) {
                    System.out.println("numbers[i] = " + numbers[i] + "| numbers[j] = " + numbers[j] + " = " + (numbers[j] + numbers[i]));
                    numberSet.add(numbers[j] + numbers[i]);
                }
            }
        }
        List<Integer> numberList = new ArrayList<>(numberSet);
        Collections.sort(numberList);
        int[] answer = new int[numberList.size()];
        int idx = 0;
        for (Integer num : numberList) {
            answer[idx] = num;
            idx++;
        }
        return answer;
    }

    public static void main(String[] args) {
//        int[] numbers = {2, 1, 3, 4, 1};
        int[] numbers = {5,0,2,7};
        SumTwoNumber stn = new SumTwoNumber();
        System.out.println(Arrays.toString(stn.solution(numbers)));
    }
}
