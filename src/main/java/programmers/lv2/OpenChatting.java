package programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class OpenChatting {
    private static final String ENTER = "_님이 들어왔습니다.";
    private static final String LEAVE = "_님이 나갔습니다.";
    public static String[] solution(String[] record) {
        HashMap<String, String> userMap = new HashMap<>();
        ArrayList<String> statusList = new ArrayList<>();
        String status = "";
        String uid = "";

        for (String info : record) {
            String[] userInfo = info.split(" ");    // 0 : Enter 1 : uid1234 2: Muzi
            status = userInfo[0];
            uid = userInfo[1];

            switch (status) {
                case "Enter" -> {
                    statusList.add(uid + ENTER);
                    userMap.put(uid, userInfo[2]);
                }
                case "Change" -> {
                    userMap.put(uid, userInfo[2]);
                }
                default -> {
                    statusList.add(uid + LEAVE);
                }
            }
        }

        String[] answer = new String[statusList.size()];

        for (int i = 0; i < statusList.size(); i++) {
            String[] memberStatus = statusList.get(i).split("_");
            answer[i] = userMap.get(memberStatus[0]) + memberStatus[1];
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(record)));
    }
}