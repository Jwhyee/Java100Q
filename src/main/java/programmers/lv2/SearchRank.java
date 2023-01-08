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

    // Member가 저장될 ArrayList
    List<Member> memberRepository = new ArrayList<>();

    /** List에 Member 데이터를 넣기 위한 메소드
     * @param sArr info[i]를 공백 기준으로 자른 문자열 배열
    */
    public void initData(String[] sArr) {
        // 생성자를 통한 Memeber 객체 생성
        Member member = new Member(sArr[0], sArr[1], sArr[2], sArr[3], Integer.parseInt(sArr[4]));

        // List에 저장
        memberRepository.add(member);
    }

    /** query에 맞는 Member를 찾는 메소드
     * @param qArr query[i]를 and와 공백을 기준으로 자른 문자열
     * @return query에 맞는 Member 수 반환
     */
    public int findCountByQuery(String[] qArr) {
        // 배열의 각 데이터를 변수에 저장
        String q_language = qArr[0], q_devSort = qArr[1], q_career = qArr[2], q_soulFood = qArr[3];
        int q_score = Integer.parseInt(qArr[4]);

        // query와 일치한 수를 나타내는 cnt 변수
        int cnt = 0;

        // List를 돌면서 조건에 부합한지 확인
        for (Member m : memberRepository) {

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
        // answer의 크기는 query의 크기와 동일함
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
