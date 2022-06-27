package programmers.lv2;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.StringTokenizer;

public class ParkingFee {
    /*
    * 기본 시간(분)	기본 요금(원)	단위 시간(분)	단위 요금(원)
    *   180	           5000	        10	       600
    */
    public static int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        String[] parkingTime = new String[records.length];
        String[] parkingCarNum = new String[records.length];
        String[] parkingStatus = new String[records.length];

        for (int i = 0; i < records.length; i++) {
            StringTokenizer st = new StringTokenizer(records[i]);
            parkingTime[i] = st.nextToken();
            parkingCarNum[i] = st.nextToken();
            parkingStatus[i] = st.nextToken();
        }

        System.out.println("parkingTime = " + Arrays.toString(parkingTime));
        System.out.println("parkingCarNum = " + Arrays.toString(parkingCarNum));
        System.out.println("parkingStatus = " + Arrays.toString(parkingStatus));

        return answer;
    }
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(Arrays.toString(solution(fees, records)));
    }
}
