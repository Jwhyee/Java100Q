package LikeLionCodeTest;

import java.util.*;

public class CodeTest5 {

    private static final List<Integer> dataList = new ArrayList<>();
    private static final List<Integer> resultList = new ArrayList<>();

    public static boolean isDataAdd(int temp) {
        if (!isDuplicate(temp)) {
            dataList.add(temp);
            return true;
        }
        System.out.println("[입력오류] : 이미 입력된 숫자 입니다.");
        return false;
    }

    public static boolean isDuplicate(int temp) {
        return dataList.contains(temp);
    }

    public static void addPrimeNumber(int temp) {
        if (temp != 1 && isPrimeNumber(temp)) {
            resultList.add(temp);
        }
    }

    public static boolean isPrimeNumber(int temp) {
        for (int j = 2; j <= Math.sqrt(temp); j++) {
            if (temp % j == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("[안내] 0을 입력하시면 입력이 종료 됩니다.");
        int numCount = 1;
        while (true) {
            System.out.print("숫자 " + numCount + " : ");
            try {
                int temp = new Scanner(System.in).nextInt();
                if (temp == 0) {
                    break;
                }
                if (isDataAdd(temp)) {
                    addPrimeNumber(temp);
                    numCount++;
                }

            } catch (InputMismatchException e) {
                System.out.println("[입력오류] : 숫자로 입력해주세요.");
            }
        }

        if (resultList.size() != 0) {
            Collections.sort(resultList);
            System.out.println("결과 : " + resultList);
        } else {
            System.out.println("결과 : 소수없음");
        }
    }
}
