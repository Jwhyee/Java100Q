package algo.programmers.lv1;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MockTest {

    private final int[] PERSON_A_ARR = {1, 2, 3, 4, 5};
    private final int[] PERSON_B_ARR = {2, 1, 2, 3, 2, 4, 2, 5};
    private final int[] PERSON_C_ARR = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};


    public int[] solution(int[] answers) {
        int[] score = {0, 0, 0};
        int answer;

        for (int i = 0; i < answers.length; i++) {
            answer = answers[i];

            if (answer == PERSON_A_ARR[i%5]) {
                score[0]++;
            }
            if (answer == PERSON_B_ARR[i%8]) {
                score[1]++;
            }
            if (answer == PERSON_C_ARR[i%10]) {
                score[2]++;
            }

        }

        int maxAnswer = Math.max(score[0], Math.max(score[1], score[2]));
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {
            if (score[i] == maxAnswer) {
                answerList.add(i + 1);
            }
        }

        return answerList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    @Test
    void solutionTest1() {
        int[] result = solution(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(result));
        assertTrue(Arrays.equals(result, new int[]{1}));
    }

    @Test
    void solutionTest2() {
        int[] result = solution(new int[]{1, 3, 2, 4, 2});
        System.out.println(Arrays.toString(result));
        assertTrue(Arrays.equals(result, new int[]{1, 2, 3}));
    }

    @Test
    void solutionTest3() {
        int[] result = solution(new int[]{1, 3, 2, 4, 2, 4, 2});
        System.out.println(Arrays.toString(result));
        assertTrue(Arrays.equals(result, new int[]{2}));
    }
}
