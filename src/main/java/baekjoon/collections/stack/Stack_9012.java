package baekjoon.collections.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack_9012 {
    public static void main(String[] args) throws IOException {
        // 입력을 받기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문제에서 주어지는 T
        int T = Integer.parseInt(br.readLine());
        // VPS를 판별하기 위한 Stack
        Stack<Character> characterStack = new Stack<>();

        for (int i = 0; i < T; i++) {
            // 입력으로 주어지는 문자열
            String data = br.readLine();

            for (int j = 0; j < data.length(); j++) {
                // 매번 charAt이 귀찮아서 char 타입 변수 생성
                char dataChar = data.charAt(j);

                // '('가 들어온다면 Stack에 push
                if (dataChar == '(') {
                    characterStack.push(dataChar);
                }
                // '('가 아닌 다른 것이 들어올 때
                else {
                    // 만약 Stack의 사이즈가 0이면 해당 데이터를 넣고 break
                    if (characterStack.size() == 0) {
                        characterStack.push(dataChar);
                        break;
                    }
                    // 사이즈가 0이 아니라면 pop
                    else {
                        characterStack.pop();
                    }
                }
            }
            // 만약 push, pop을 통해 Stack이 비었다면 "YES"
            if (characterStack.isEmpty()) {
                System.out.println("YES");
            }
            // 비어있지 않다면 "NO" -> size가 0일 때 다른 것이 들어간 것 포함!
            else {
                System.out.println("NO");
            }
            // 다음 루프를 위해 Stack을 비워줌
            characterStack.clear();
        }
    }
}
