package programmers.lv1;

public class KnightWeapon {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int cnt = 0;
            System.out.println("i = " + i);
            System.out.println("sqrt = " + (int) Math.sqrt(i));
            for (int j = 1; j <= (int) Math.sqrt(i); j++) {
                if (i == 1) {
                    cnt++;
                    continue;
                }
                if (i % j == 0) {
                    System.out.println("j = " + j);
                    if (j * j == i) cnt++;
                    else cnt+=2;
                }
            }
            System.out.println("cnt = " + cnt);
            if (cnt > limit) answer+=power;
            else answer+=cnt;
            System.out.println("answer = " + answer);
            System.out.println("=====================");
        }
        return answer;
    }
    public static void main(String[] args) {
        KnightWeapon kw = new KnightWeapon();
        int number = 5;
        int limit = 3;
        int power = 2;
//        int number = 10;
//        int power = 2;
//        int limit = 3;
        if (kw.solution(number, limit, power) == 10) {
            System.out.println("T");
        } else System.out.println("F");
    }
}
