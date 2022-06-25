package programmers.lv1;

public class EvenOdd {
    public static String solution(int num) {
        String answer = "";
        if(num%2 == 0){
            answer = "Even";
        } else answer = "Odd";

        return answer;
    }
    public static void main(String[] args) {
        int n = 3;
        System.out.println(solution(n));
    }
}
