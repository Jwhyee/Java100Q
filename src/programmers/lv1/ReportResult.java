package programmers.lv1;

import java.util.Arrays;
import java.util.StringTokenizer;

public class ReportResult {
    public static int[] solution(String[] id_list, String[] report, int k) {
        /*
        이용자의 ID가 담긴 문자열 배열 id_list,
        각 이용자가 신고한 이용자의 ID 정보가 담긴 문자열 배열 report,
        정지 기준이 되는 신고 횟수 k가 매개변수로 주어질 때,
        각 유저별로 처리 결과 메일을 받은 횟수를 배열에 담아 return 하도록 solution 함수를 완성해주세요.
        */
        int[] answer = new int[k];
        String[] doReport = new String[report.length];
        String[] getReport = new String[report.length];
        int[] reportCount = new int[id_list.length];

        for (int i = 0; i < report.length; i++) {
            StringTokenizer st = new StringTokenizer(report[i], " ");
            doReport[i] = st.nextToken();
            getReport[i] = st.nextToken();
            for (int j = 0; j < id_list.length; j++) {
                if (id_list[j].equals(getReport[i])) {
                    reportCount[j]++;
                }
            }
        }
        System.out.println(Arrays.toString(reportCount));

        return answer;
    }
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        System.out.println(Arrays.toString(solution(id_list, report, k)));
    }
}
