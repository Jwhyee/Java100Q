package algo.programmers.lv0;

public class CompareValues {
    public int solution(int a, int b) {
        String num = String.valueOf(a) + b;
        int numInt = Integer.parseInt(num);
        int mul = 2 * a * b;
        return Math.max(numInt, mul);
    }

    public static void main(String[] args) {
        CompareValues c = new CompareValues();
        int a = 2;
        int b = 91;
        System.out.println(c.solution(a, b));
        a = 91;
        b = 2;
        System.out.println(c.solution(a, b));
    }
}
