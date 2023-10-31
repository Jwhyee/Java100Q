package algo.programmers.lv1;

public class InnerProduct {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for (int n = 0; n < a.length; n++) {
            answer += (a[n] * b[n]);
        }
        System.out.println("answer = " + answer);
        return answer;
    }
    public static void main(String[] args) {
        InnerProduct ip = new InnerProduct();
        int[] a = {1, 2, 3, 4};
        int[] b = {-3, -1, 0, 2};
        System.out.println(ip.solution(a, b));
    }
}
