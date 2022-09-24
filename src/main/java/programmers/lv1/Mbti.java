package programmers.lv1;

import java.util.HashMap;
import java.util.Map;

public class Mbti {
    // https://school.programmers.co.kr/learn/courses/30/lessons/118666
    public static Map<String, Integer> resultMap = new HashMap<>();
    public static String[] result = {"RT", "CF", "JM", "AN"};

    public void chooseType(String surveyType, int selectScore){
        int currentScore = Math.abs(selectScore);
        String[] surveyArr = surveyType.split("");
        if(selectScore < 0){
            resultMap.put(surveyArr[0], resultMap.getOrDefault(surveyArr[0], 0) + currentScore);
        } else if(selectScore > 0){
            resultMap.put(surveyArr[1], resultMap.getOrDefault(surveyArr[1], 0) + currentScore);
        }
    }

    public String solution(String[] survey, int[] choices) {
        String answer = "";

        for(int i = 0; i < survey.length; i++){
            chooseType(survey[i], choices[i] - 4);
        }

        for(String resultType : result){
            String typeOne = String.valueOf(resultType.charAt(0));
            String typeTwo = String.valueOf(resultType.charAt(1));
            int scoreOne = 0;
            int scoreTwo = 0;
            // Map에서 타입들의 값을 꺼내와서 비교!
            if(resultMap.containsKey(typeOne)){
                scoreOne = resultMap.get(typeOne);
            } else if(resultMap.containsKey(typeTwo)){
                scoreTwo = resultMap.get(typeTwo);
            }
            if(scoreOne > scoreTwo){
                answer += typeOne;
            } else if(scoreOne < scoreTwo){
                answer += typeTwo;
            } else {
                int num1 = typeOne.charAt(0);
                int num2 = typeTwo.charAt(0);
                if(num1 > num2) answer += typeTwo;
                else if(num1 < num2) answer += typeOne;
            }
        }

        // List<String> resultList = new ArrayList<>(Arrays.asList(result));

        return answer;
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
