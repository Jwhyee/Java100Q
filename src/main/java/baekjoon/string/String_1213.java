package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class String_1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Test case 입력 받기

        StringBuilder sb = new StringBuilder();
        // String으로 붙여주기 위해 StringBuilder 사용

        String[] testCaseArr = br.readLine().split("");
        int caseLength = testCaseArr.length;
        Arrays.sort(testCaseArr);
        // 한 글자씩 배열에 저장 후 정렬

        Stack<String> stack = new Stack<>();
        // 주어진 문장의 반씩 스택에 넣기 위해 사용

        case1 : if (caseLength % 2 == 0) {  // 주어진 Case가 짝수일 경우
            for (int i = 0; i < caseLength; i += 2) {
                if (testCaseArr[i].equals(testCaseArr[i + 1])) {
                    sb.append(testCaseArr[i]);      // 문자열의 절반만 append 해준다.
                    stack.push(testCaseArr[i]);     // 해당 문자를 stack에 넣어 거꾸로 뽑을 수 있게 해준다.
                } else {
                    System.out.println("I'm Sorry Hansoo");
                    break case1;
                }
            }
            while (!stack.empty()) {
                sb.append(stack.pop()); // 아까 저장해둔 문자를 pop해서 붙여준다.
            }
            System.out.println(sb.toString());
        } else {
            String temp = "tmp";
            for (int i = 0; i < caseLength - 1; i += 2) {
                if (testCaseArr[i].equals(testCaseArr[i + 1])) {
                    sb.append(testCaseArr[i]);      // 문자열의 절반만 append 해준다.
                    stack.push(testCaseArr[i]);     // 해당 문자를 stack에 넣어 거꾸로 뽑을 수 있게 해준다.
                } else if (temp.equals("tmp")) {
                    temp = testCaseArr[i];
                    i--;
                } else {
                    System.out.println("I'm Sorry Hansoo");
                    break case1;
                }
            }
            if (temp.equals("tmp")) {
                temp = testCaseArr[caseLength - 1];
            }
            sb.append(temp);
            while (!stack.empty()) {
                sb.append(stack.pop()); // 아까 저장해둔 문자를 pop해서 붙여준다.
            }
            System.out.println(sb.toString());
        }
    }
}
