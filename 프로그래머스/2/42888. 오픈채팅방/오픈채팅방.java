import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    private static final String ENTER = "_님이 들어왔습니다.";
    private static final String LEAVE = "_님이 나갔습니다.";
    
        public String[] solution(String[] record) {
        HashMap<String, String> userMap = new HashMap<>();
        ArrayList<String> statusList = new ArrayList<>();

        // "Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"
        for (String records : record) {
            String[] parts = records.split(" ");
            String status = parts[0];
            String uid = parts[1];

            if (status.equals("Enter") || status.equals("Change")) {
                String nickname = parts[2];
                userMap.put(uid, nickname);
            }
        }

        for (String records : record) {
            String[] parts = records.split(" ");
            String status = parts[0];
            String uid = parts[1];

            if (status.equals("Enter") || status.equals("Leave")) {
                String nickname = userMap.get(uid);
                statusList.add(manageChatRoom(status, nickname));
            }
        }

        String[] answer = new String[statusList.size()];
        return statusList.toArray(answer);
    }

    private String manageChatRoom(String status, String nickname) {
        if (status.equals("Enter")) {
            return nickname + "님이 들어왔습니다.";
        }
        return nickname + "님이 나갔습니다.";
    }
}