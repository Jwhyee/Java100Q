package algo.programmers.lv1;

import java.util.Arrays;

public class SameWord {
    public static int[] solution(String s) {
        int[] answer = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            String tempString = s.substring(0, i + 1);
            if (s.contains(String.valueOf(s.charAt(i)))) {
                for (int j = tempString.length(); true; j--) {
                    if (tempString.charAt(j) == s.charAt(i)) {
                        answer[i] = j;
                        break;
                    }
                }
            } else {
                answer[i] = -1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "banana";
//        String s = "foobar";
        System.out.println(Arrays.toString(solution(s)));
    }
}
