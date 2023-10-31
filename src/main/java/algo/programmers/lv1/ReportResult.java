package algo.programmers.lv1;

import java.util.*;

public class ReportResult {
    /*
     * * 문제 핵심 *
     * k번 이상 신고된 유저를 신고한 유저들에게 메일을 보낸다.
     * 즉, 정지 처분 된 유저를 신고한 유저들이 총 몇 번의 메일을 받는지 구해야한다.

     * * 문제 이해 *
     * 1. report 배열에 중복이 있으면 안 된다 -> HashSet
     * 2. report 배열을 돌면서 아래 2가지를 찾는다.
     * 2-1. 누가 누구를 신고했는지 저장 -> Map
     * 2-2. 누가 몇 번 신고를 당했는지 저장 -> Map
     * 3. 2-1을 돌면서 id_list 순서에 맞게 메일 받는 횃수를 answer 배열에 저장

     */
    public static int[] solution(String[] id_list, String[] report, int k) {
        /* 1단계 : 풀이에 필요한 Map, Set 생성 */
        int[] answer = new int[id_list.length];
        // answer 배열의 길이를 지정

        Map<String, String> reporterInfoMap = new HashMap<>();
        // 누가 누구를 신고했는지 저장하는 reporterInfoMap

        Map<String, Integer> reportedCountMap = new HashMap<>();
        // 누가 몇 번 신고를 당했는지 저장하는 reportedCountMap

        HashSet<String> reportArrSet = new HashSet<>(Arrays.asList(report));
        // report 배열에 중복이 있으면 안 되기 때문에 HashSet 사용


        /* 2단계 : InfoMap, CountMap -> 값을 저장 */
        for (String reportInfo : reportArrSet) {    // hashSet iterator

            String reporterId = reportInfo.split(" ")[0];   // 신고를 한 유저
            String reported = reportInfo.split(" ")[1];     // 신고를 받은 유저

            reporterInfoMap.put(reporterId, (reporterInfoMap.getOrDefault(reporterId, "") + " " + reported).trim());
            // 저장되어 있던 value를 가져와 reported를 추가로 붙이고 trim을 통해 앞, 뒤 공백 제거 후 저장

            reportedCountMap.put(reported, reportedCountMap.getOrDefault(reported, 0) + 1);
            // 저장되어 있던 value를 가져와 +1을 해줌

        }
        System.out.println("reportedCountMap = " + reportedCountMap);
        // countMap.size == id_list.length로 맞춰서 해보기
        System.out.println("reporterInfoMap = " + reporterInfoMap);

        /* 3단계 : k회 이상 신고 당해 정지 처분을 받은 유저를 신고한 사람을 찾는 과정 */
        for (String reportedId : reportedCountMap.keySet()) {
            int reportedCount = reportedCountMap.get(reportedId);
            // key 값으로 value 뽑기

            if (reportedCount >= k) {
                // value 값이 k회 이상일 때

                for (int i = 0; i < id_list.length; i++) {
                    /*if (reporterInfoMap.containsKey(id_list[i]) && reporterInfoMap.get(id_list[i]).contains(reportedId)) {
                        answer[i]++;
                    }*/
                    if (reporterInfoMap.containsKey(id_list[i]) && reporterInfoMap.get(id_list[i]).contains(reportedId)) {
                        String[] arr = reporterInfoMap.get(id_list[i]).split(" ");
                        for (String s : arr) {
                            if (s.equals(reportedId)) {
                                answer[i]++;
                            }
                        }
                    }
                }
            }
        }


        return answer;
    }
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
//        String[] id_list = {"con", "ryan"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
//        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 2;
//        int k = 3;
        System.out.println(Arrays.toString(solution(id_list, report, k)));
    }
}