package programmers.lv2;

import java.util.*;

public class OpenChatting {
    public static String[] solution(String[] record) {
        Map<String, String> userMap = new HashMap<>();
        List<String> statusList = new ArrayList<>();

        for (String info : record) {
            String[] userInfo = info.split(" ");    // 0 : Enter 1 : uid1234 2: Muzi
            if (userInfo[0].equals("Enter")) {
                statusList.add(userInfo[1] + "님 Enter");
                userMap.put(userInfo[1], userInfo[2]);
            } else if (userInfo[0].equals("Change")) {
                userMap.put(userInfo[1], userInfo[2]);
            } else {
                statusList.add(userInfo[1] + "님 Leave");
            }
        }

        String[] answer = new String[statusList.size()];

        for (int i = 0; i < statusList.size(); i++) {
            if (statusList.get(i).contains("Enter")) {
                answer[i] = userMap.get(statusList.get(i).replaceAll("님 Enter", "")) + "님이 들어왔습니다.";
            } else {
                answer[i] = userMap.get(statusList.get(i).replaceAll("님 Leave", "")) + "님이 나갔습니다.";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(record)));
    }
}