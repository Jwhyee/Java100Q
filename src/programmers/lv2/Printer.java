package programmers.lv2;

import java.util.*;

public class Printer {
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        int max = 0;
        Queue<Integer> printerQueue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            int num = priorities[i];
            printerQueue.add(num);
            if (max < num) {
                max = num;
            }
        }
        for (int i = 0; i < priorities.length; i++) {

        }
        System.out.println("max = " + max);
        System.out.println(printerQueue);

        return answer;
    }
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
//        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 2;
//        int location = 0;
        System.out.println(solution(priorities, location));
    }
}
