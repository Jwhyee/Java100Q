package programmers.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class SearchRank {
    static class Member{
        public String language;
        public String devSort;
        public String career;
        public String soulFood;
        public int score;

        public Member(String language, String devSort, String career, String soulFood, int score) {
            this.language = language;
            this.devSort = devSort;
            this.career = career;
            this.soulFood = soulFood;
            this.score = score;
        }
    }

    List<Member> memberList = new ArrayList<>();

    public void initData(String[] sArr) {
        Member member = new Member(sArr[0], sArr[1], sArr[2], sArr[3], Integer.parseInt(sArr[4]));
        memberList.add(member);
    }

    public int findCountByQuery(String[] qArr) {
        String q_language = qArr[0], q_devSort = qArr[1], q_career = qArr[2], q_soulFood = qArr[3];
        int q_score = Integer.parseInt(qArr[4]);

        int cnt = 0;

        for (Member m : memberList) {

            Member m2 = new Member(q_language, q_devSort, q_career, q_soulFood, q_score);
            System.out.println(m.equals(m2));

            if (q_language.equals("-") || m.language.equals(q_language)) {
                if (q_devSort.equals("-") || m.devSort.equals(q_devSort)) {
                    if (q_career.equals("-") || m.career.equals(q_career)) {
                        if (q_soulFood.equals("-") || m.soulFood.equals(q_soulFood)) {
                            if (m.score >= q_score) {
                                cnt++;
                            }
                        }
                    }
                }
            }
        }


        return cnt;
    }

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        // List에 데이터 삽입
        for (String s : info) {
            initData(s.split(" "));
        }

        // 쿼리에 따른 검색
        int i = 0;
        for (String q : query) {
            answer[i++] = findCountByQuery(q.replaceAll(" and ", " ").split(" "));
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        SearchRank s = new SearchRank();
        System.out.println(Arrays.toString(s.solution(info, query)));
    }
}
