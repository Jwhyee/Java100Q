package algo.programmers.lv2;

public class MakeJadenCase {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] sArr = s.toLowerCase().split("");
        boolean flag = true;

        for (String str : sArr) {
            if (flag) {
                sb.append(str.toUpperCase());
            } else {
                sb.append(str);
            }
            flag = str.equals(" ");
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        MakeJadenCase m = new MakeJadenCase();
        String s = "3people   unFollowed  Me";
        System.out.println("m = " + m.solution(s));
    }
}
