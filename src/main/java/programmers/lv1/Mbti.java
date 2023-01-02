package programmers.lv1;

import java.util.HashMap;
import java.util.Map;

public class Mbti {
    /* 성격 유형
     * 1번 지표 : R / T
     * 2번 지표 : C / F
     * 3번 지표 : J / M
     * 4번 지표 : A / N
    */

    // 점수를 얻은 유형을 저장하기 위한 Map
    Map<Character, Integer> scoreMap = new HashMap<>();

    // 각 지표를 사전 순으로 정리해놓은 mbti 배열
    String[] mbti = {"RT", "CF", "JM", "AN"};

    /** 선택한 번호를 통해 점수를 계산하기 위한 메소드
     * @param choice 사용자의 지표 선택지
     * @return 선택지의 4를 뺀 절대값 반환
     */
    public int getScore(int choice) {
        // 들어온 값이 몇이든 4를 뺀 절대값을 해주면 1 ~ 3사이의 점수 획득
        return Math.abs(choice - 4);
    }

    /** scoreMap에 선택된 지표의 점수를 넣기 위한 메소드
     * @param c 제시된 성격 유형의 배열 예)R, T
     * @param choice 사용자의 선택지 번호
     */
    public void putScoreMap(char[] c, int choice) {
        // 사용자가 4번을 선택하면 점수를 받지 않기 때문에 4가 아닐 때만 진행!
        if (choice != 4) {
            // 선택한 번호를 토대로 얻은 점수
            int score = getScore(choice);

            // 선택한 번호를 통해 앞 유형인지, 뒷 유형인지 정하기 위한 idx
            int idx = (choice < 4) ? 0 : 1;

            // 위에서 선택된 idx를 통해 값을 넣어주고, 이미 있다면 누적합을 위해 getOrDefault 사용
            scoreMap.put(c[idx], scoreMap.getOrDefault(c[idx], 0) + score);
        }
    }

    /** 최종적인 성격 유형을 정해주는 메소드
     * @return 최종 성격 유형 반환
     */
    public String getMbti() {
        // 문자를 붙이기 위한 StringBuilder
        StringBuilder sb = new StringBuilder();

        // 주어진 지표 중 어떤 유형인지 선택하기 위한 for-each
        for (String s : mbti) {

            // 첫 지표 예시) "RT" -> typeOne = R, typeTwo = T
            char typeOne = s.charAt(0);
            char typeTwo = s.charAt(1);

            // scoreMap에 저장된 각 유형의 점수를 꺼냄, 없다면 0으로 지정
            int typeOneScore = scoreMap.getOrDefault(typeOne, 0);
            int typeTwoScore = scoreMap.getOrDefault(typeTwo, 0);

            // 각 지표에 대한 점수를 비교해서 성격 유형 지정
            if(typeOneScore > typeTwoScore) sb.append(typeOne);
            else if(typeOneScore < typeTwoScore) sb.append(typeTwo);
            else sb.append(typeOne);
        }

        // 최종적으로 만들어진 성격 유형 결과 반환
        return sb.toString();
    }

    /** 주어진 지표와 선택지를 통해 MBTI를 구하는 메소드
     * @param survey 주어진 지표
     * @param choices 주어진 지표의 사용자 선택지
     * @return 최종 성격 유형 반환
     * */
    public String solution(String[] survey, int[] choices) {

        // choices 배열을 조정하기 위한 i
        int i = 0;

        // for-each를 통해 scoreMap에 각 유형에 대한 점수를 저장
        for (String s : survey) putScoreMap(s.toCharArray(), choices[i++]);

        // 최종적으로 만들어진 성격 유형 반환
        return getMbti();
    }

    public static void main(String[] args) {
        Mbti m = new Mbti();
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
//        String[] survey = {"TR", "RT", "TR"};
        int[] choice = {5, 3, 2, 7, 5};
//        int[] choice = {7, 1, 3};

        System.out.println(m.solution(survey, choice));
    }
}