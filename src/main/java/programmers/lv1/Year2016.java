package programmers.lv1;

import java.time.LocalDate;

public class Year2016 {
    public String solution(int a, int b) {
        LocalDate ld = LocalDate.of(2016, a, b);
        return ld.getDayOfWeek().toString().substring(0, 3);
    }
    public static void main(String[] args) {
        Year2016 y = new Year2016();
        System.out.println(y.solution(5, 24));
    }
}
