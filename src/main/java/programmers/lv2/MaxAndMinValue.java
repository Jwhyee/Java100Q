package programmers.lv2;

import java.util.Arrays;

public class MaxAndMinValue {
    public String solution(String s) {
        // 문자열을 붙이기 위한 StringBuilder
        StringBuilder sb = new StringBuilder();

        // stream을 이용해 배열의 최소, 최대값 검색
        // s가 둘 이상의 정수가 붙어 있기 때문에 isPresent()의 과정없이 바로 getAsInt() 진행
        int maxValue = Arrays.stream(s.split(" ")).mapToInt(Integer :: parseInt).max().getAsInt();
        int minValue = Arrays.stream(s.split(" ")).mapToInt(Integer :: parseInt).min().getAsInt();

        // 최소값 최대값을 이어서 반환
        sb.append(minValue).append(" ").append(maxValue);
        return sb.toString();
    }
    public static void main(String[] args) {
        MaxAndMinValue m = new MaxAndMinValue();
        String s = "-1 -2 -3 -4";
        System.out.println(m.solution(s));
    }
}
