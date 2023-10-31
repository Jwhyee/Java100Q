package algo.codetest.kakaomobilty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Question1st {
    public int solution(int[][] flowers) {
        List<Integer> dayList = new ArrayList<>();
        for (int i = 0; i < flowers.length; i++) {
            for (int j = flowers[i][0]; j < flowers[i][1]; j++) {
                dayList.add(j);
            }
        }
        dayList = dayList.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println("dayList = " + dayList);
        return dayList.size();
    }
    public static void main(String[] args) {
        Question1st qo = new Question1st();
        int[][] flowers = {{2, 5}, {3, 7}, {10, 11}};
//        int[][] flowers = {{3, 4}, {4, 5}, {6, 7}, {8, 10}};
        System.out.println(qo.solution(flowers));
    }
}
