package algo.programmers.lv1;

public class SumBetween {
    /**
     * @param a 시작하는 수
     * @param b 끝자리 수
    */
    public long solution(int a, int b) {
        long answer = 0;
        int temp = 0;
        if (a > b) {
            temp = a;
            a = b;
            b = temp;
        }
        for (int i = a; i <= b; i++) {
            answer += i;
        }
        return answer;
    }
    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        SumBetween sb = new SumBetween();
        System.out.println(sb.solution(a, b));
    }
}
