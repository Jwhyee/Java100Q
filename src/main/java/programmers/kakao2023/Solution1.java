package programmers.kakao2023;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Solution1 {
    public static Map<String, Integer> termsMap = new HashMap<>();
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    public boolean isPassedDay(String today, LocalDate accessDay, String sort) {
        LocalDate parseToday = LocalDate.parse(today, formatter);
        return parseToday.isAfter(accessDay.plusMonths(termsMap.get(sort))) || parseToday.isEqual(accessDay.plusMonths(termsMap.get(sort)));
    }
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answerList = new ArrayList<>();
        for (String term : terms) {
            String termSort = term.split(" ")[0];
            int termMonth = Integer.parseInt(term.split(" ")[1]);
            termsMap.put(termSort, termMonth);
        }
        for (int i = 0; i < privacies.length; i++) {
            LocalDate accessDay = LocalDate.parse(privacies[i].split(" ")[0], formatter);
            System.out.println(accessDay);
            String termSort = privacies[i].split(" ")[1];
            if (isPassedDay(today, accessDay, termSort)) {
                answerList.add(i + 1);
            }
        }
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        String today = "2022.05.19";
//        String today = "2020.01.01";
        String[] terms = {"A 6", "B 12", "C 3"};
//        String[] terms = {"Z 3", "D 5"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
//        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2019.12.28 Z"};
        System.out.println(Arrays.toString(s.solution(today, terms, privacies)));;
    }
}
