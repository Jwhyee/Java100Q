package algo.programmers.lv2;

import java.util.Stack;

/* https://school.programmers.co.kr/learn/courses/30/lessons/12973 */
public class RemoveCouple {

    public int solution(String s){
        // 연속된 문자열을 확인하기 위한 Stack
        Stack<Character> charStack = new Stack<>();

        // 전체 문자열을 돌면서 각 문자열 stack에 저장
        for (int i = 0; i < s.length(); i++) {
            // 바로 s.charAt(i)를 넣어도 되지만, 변수명을 줄여서 사용하기 위해 선언
            char c = s.charAt(i);

            // stack이 비어있지 않은 상태에서 top의 값이 현재 문자열의 문자와 동일하다면 꺼내기
            if (!charStack.empty() && charStack.peek() == c) {
                charStack.pop();
            } else {
                // 이 외 상황에서는 stack에 문자 넣기
                charStack.push(c);
            }
        }
        // 스택이 비어있다면 정상적으로 완료한 것이기 때문에 1반환
        return charStack.empty() ? 1 : 0;
    }
    public static void main(String[] args) {
        RemoveCouple m = new RemoveCouple();
        String s = "cdcd";
        System.out.println(m.solution(s));
    }
}
