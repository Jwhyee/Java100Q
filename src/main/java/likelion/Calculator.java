package likelion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    public static void main(String[] args) {
        System.out.println(calc("10 + 2 + 2"));
    }
    public static int calc(String s) {
        List<Integer> numList = new ArrayList<>();
        List<String> calcList = new ArrayList<>();
        String[] sSplit = s.split(" ");

        System.out.println(Arrays.toString(sSplit));
        int rs = 0;
        for (int i = 0; i < sSplit.length; i++) {
            if (i % 2 == 0) {
                numList.add(Integer.valueOf(sSplit[i]));
            } else {
                calcList.add(sSplit[i]);
            }
        }
        for (int i = 0; i < calcList.size(); i++) {
            switch (calcList.get(i)) {
                case "+":
                    rs = rs + (numList.get(i) + numList.get(i + 1));
                    numList.remove(i + 1);
                    break;
                case "-":
                    rs = rs + (numList.get(i) - numList.get(i + 1));
                    break;
                case "*":
                    rs = rs + (numList.get(i) * numList.get(i + 1));
                    break;
                case "/":
                    rs = rs + (numList.get(i) / numList.get(i + 1));
                    break;
            }
        }
        return rs;
    }
}
