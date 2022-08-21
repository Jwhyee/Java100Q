package baekjoon.time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Traffic {

    public static int solution1(String[] lines) throws Exception {
        int answer = 0;

        return answer;
    }

    public static int solution2(String[] lines) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");
        int[] counts = new int[lines.length];
        int answer = 0;
        for (int i = 0; i < lines.length; i++) {
            // 이전 로그의 완료 시점
            String[] pre = lines[i].split(" ");
            Date preEndDate = format.parse(pre[1]);
            long preEnd = preEndDate.getTime();

            // 해당 로그보다 늦게 종료되는 로그 체크
            for (int j = i; j < lines.length; j++) {
                // 다음 로그의 시작시점
                String[] next = lines[j].split(" ");
                Date nextEndDate = format.parse(next[1]);
                double sec = Double.parseDouble(next[2].substring(0, next[2].length() - 1));

                /* 다음 로그의 종료 시점 - 처리 초 + 1;
                * 2016-09-15 01:00:07.000 2s
                * 01:00:05.001 ~ 01:00:07.000에서 2초동안 처리 된다.
                * 7000 - 2000 + 1 = 5001
                */
                long nextStart = (long) (nextEndDate.getTime() - sec * 1000 + 1);

                /* 이전 로그의 종료 시점부터 + 1초 범위 안에 시작 되면 + 1
                * 1부터 10의 범위를 가진다고 가정할 때 1, 2, 3, 4, 5, 6, 7, 8, 9, 10을 가진다.
                * 1 + 10 = 11 이므로 = 부호를 사용하면 안 된다.
                * */
                if (preEnd + 1000 > nextStart) {
                    counts[i] += 1;
                    answer = Math.max(answer, counts[i]);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {
        String lines[] = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};
        int expected = 1;
//        String lines[] = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"};
//        int expected = 2;
//        String lines[] = {"2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s", "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s", "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s", "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s"};
//        int expected = 7;
        System.out.println(solution1(lines));
        System.out.println(solution2(lines));
    }
}
