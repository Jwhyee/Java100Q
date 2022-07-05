package main.LikeLionCodeTest;

import java.util.*;

public class CodeTest4 {
    public static void main(String[] args) {
        List<Integer> dataInitList = new ArrayList<>();
        int numCount = 1;
        System.out.println("0을 입력하시면 입력이 종료 됩니다.");
        while (true) {
            System.out.print("숫자 " + numCount + " : ");
            try {
                int temp = new Scanner(System.in).nextInt();
                if (temp == 0) {
                    break;
                }
                dataInitList.add(temp);
                numCount++;
            } catch (InputMismatchException e) {
                System.out.println("[입력오류] : 숫자로 입력해주세요.");
            }
        }
        System.out.println("결과 : " + dataInitList);
    }
}
