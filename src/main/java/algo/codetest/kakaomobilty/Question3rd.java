package algo.codetest.kakaomobilty;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question3rd {
    List<LocalDateTime> saveDayList;
    public int isSuccess() {
        for (int i = 0; i < saveDayList.size() - 1; i++) {
            LocalDate currentDate = LocalDate.from(saveDayList.get(i));
            LocalDate nextDate = LocalDate.from(saveDayList.get(i + 1));
            if (ChronoUnit.DAYS.between(currentDate, nextDate) != 1) {
                return 0;
            }
        }
        return 1;
    }

    public int findSavedDays() {
        int listSize = saveDayList.size() - 1, cnt = 0;
        LocalDate start = LocalDate.from(saveDayList.get(0)), end = LocalDate.from(saveDayList.get(listSize));
        LocalDate next = LocalDate.from(start.minusDays(1));
        while ((next = next.plusDays(1)).isBefore(end.plusDays(1))) {
            System.out.println(next);
            cnt++;
        }
        return cnt;
    }

    public void setSaveDayList(String[] times) {
        for (String time : times) {
            int[] timeInfo = Arrays.stream(time.split(":")).mapToInt(Integer :: parseInt).toArray();
            int lastIndex = saveDayList.size() - 1;

            // 이번에 저축을 진행한 연, 월, 일이 이전 연, 월, 일과 같은지 비교!
            LocalDateTime lastSaveDay = saveDayList.get(lastIndex);
            LocalDateTime currentSaveDay = saveDayList.get(lastIndex).plusDays(timeInfo[0]).plusHours(timeInfo[1]).plusMinutes(timeInfo[2]).plusSeconds(timeInfo[3]);
            saveDayList.add(currentSaveDay);
        }
    }
    /**
     * 처음 저축한 날 ~ 마지막 저축한 날까지 매일 1회씩 저축했다면 1일 1저축 성공
     * @param s 첫 저축 시작시간
     * @param times 다음 저축까지 걸린 기간
     * @return answer 성공여부 및 저축 기간
     * */
    public int[] solution(String s, String[] times) {
        int[] answer = {0, 0};
        saveDayList = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy:MM:dd:HH:mm:ss");
        saveDayList.add(LocalDateTime.parse(s, formatter));

        setSaveDayList(times);

        System.out.println("saveDayList = " + saveDayList);

        // 1일 1저축에 성공했는지 탐색
        int successCode = isSuccess();

        // 총 저축 기간 탐색
        int cnt = findSavedDays();
        answer[0] = successCode;
        answer[1] = cnt;
        return answer;
    }
    public static void main(String[] args) {
        Question3rd q = new Question3rd();
//        String s = "2021:04:12:16:08:35";
//        String[] times = {"01:06:30:00", "01:04:12:00"};
//        String s = "2021:04:12:16:08:35";
//        String[] times = {"01:06:30:00", "00:01:12:00"};
//        String s = "2021:04:12:16:10:42";
//        String[] times = {"01:06:30:00"};
        String s = "2021:04:12:16:08:35";
        String[] times = {"01:06:30:00", "01:01:12:00", "00:00:09:25"};
        System.out.println(Arrays.toString(q.solution(s, times)));
    }
}
