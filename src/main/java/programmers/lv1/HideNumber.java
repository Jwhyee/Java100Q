package programmers.lv1;

import java.util.Arrays;

public class HideNumber {
    public String solution(String phone_number) {
        String answer = "";
        StringBuffer sb = new StringBuffer(phone_number);
        String tempStr = sb.reverse().toString();
        String hideNumber = tempStr.substring(4).replaceAll(".", "*");
        String noneHide = tempStr.substring(0, 4);
        tempStr = noneHide + hideNumber;
        sb = new StringBuffer(tempStr);
        answer = sb.reverse().toString();
        return answer;
    }
    public static void main(String[] args) {
        HideNumber hn = new HideNumber();
        String phone_number = "01033334444";
        System.out.println(hn.solution(phone_number));
    }
}
