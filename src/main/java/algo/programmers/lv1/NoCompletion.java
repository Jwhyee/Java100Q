package algo.programmers.lv1;

import java.util.*;

public class NoCompletion {

    /* * 문제이해 *
     * 1. 완주하지 못한 선수를 구하기
     * 2. 선수의 이름은 중복이 가능하다.
     * 2-1. 중복된 선수가 있더라도 그 중에 1명은 불합격으로 나와야한다.
     * participant : 참여한 선수 배열
     * completion : 완주한 선수 배열
     */
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> playerMap = new HashMap<>();
        for (String player : participant) {
            playerMap.put(player, playerMap.getOrDefault(player, 0) + 1);
        }
        for (String player : completion) {
            playerMap.put(player, playerMap.get(player) -1);
        }
        for (String player : playerMap.keySet()) {
            if (playerMap.get(player) != 0) {
                answer = player;
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
//        String[] participant = {"leo", "kiki", "eden"};
//        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
//        String[] completion = {"eden", "kiki"};
//        String[] completion = {"josipa", "filipa", "marina", "nikola"};
        String[] completion = {"stanko", "ana", "mislav"};
        System.out.println(solution(participant, completion));
    }
}
