package algo.programmers.lv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CloseCharacter {
    public static int[] solution(String s) {
        int[] answer = new int[s.length()];
        answer[0] = -1;
        for (int i = 1; i < s.length(); i++) {
            int n = s.lastIndexOf(s.substring(i, i + 1), i - 1);
            if (n != -1) {
                answer[i] = i - n;
            } else {
                answer[i] = n;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("banana")));
        System.out.println(Arrays.toString(solution("foobar")));
    }
}
