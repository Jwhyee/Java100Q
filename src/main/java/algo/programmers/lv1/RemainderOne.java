package algo.programmers.lv1;

public class RemainderOne {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 1) {
                answer = i;
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int n = 12;
        RemainderOne ro = new RemainderOne();
        System.out.println(ro.solution(n));
    }
}
