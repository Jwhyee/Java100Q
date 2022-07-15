package programmers.lv2;

import java.util.*;

public class ParkingFee {
    /*
    * 기본 시간(분)	기본 요금(원)	단위 시간(분)	단위 요금(원)
    *   180	           5000	        10	       600
    */
    /* 문제 이해 *
    * 주차요금 공식 = 기본요금 + [(누적주차시간 - 180분) / 단위시간(분)] * 단위요금
    * 차량의 누적 주차 시간을 구해서 주차 요금 계산
    * 만약 출차 내역이 없다면 23:59에 출차된 것으로 간주!
    * */
    public static int[] solution(int[] fees, String[] records) {
        // 중복 제거 라이브러리 사용
        int[] answer = {};

        return answer;
    }

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
//        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        String[] records = {"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"};
        System.out.println(Arrays.toString(solution(fees, records)));
    }
}
