package programmers.lv2;

import java.util.Arrays;

public class EmoticonSale {
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        return answer;
    }

    public static void main(String[] args) {
        EmoticonSale s = new EmoticonSale();
        int[][] users = {{40, 10000}, {25, 10000}};
        int[] emoticons = {7000, 9000};
        System.out.println("emoticons = " + Arrays.toString(s.solution(users, emoticons)));

//        int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
//        int[] emoticons = {1300, 1500, 1600, 4900};
//        System.out.println("emoticons = " + Arrays.toString(s.solution(users, emoticons)));
    }
}
