package main.programmers.lv2;

import java.util.*;

public class ParkingFee {
    /*
    * 기본 시간(분)	기본 요금(원)	단위 시간(분)	단위 요금(원)
    *   180	           5000	        10	       600
    */
    public static int[] solution(int[] fees, String[] records) {
        // 중복 제거 라이브러리 사용
        int[] answer = {};
        Map<String, String> calculateParking = new HashMap<>();
        Map<String, Integer> answerMap = new HashMap<>();
        String[] parkingTime = new String[records.length];
        String[] parkingCarNum = new String[records.length];
        String[] parkingStatus = new String[records.length];

        for (int i = 0; i < records.length; i++) {
            StringTokenizer st = new StringTokenizer(records[i]);
            parkingTime[i] = st.nextToken().replace(":", "");
            parkingCarNum[i] = st.nextToken();
            parkingStatus[i] = st.nextToken();
        }
        for (int i = 0; i < records.length; i++) {
            if (!calculateParking.containsKey(parkingCarNum[i])) {
                calculateParking.put(parkingCarNum[i], parkingTime[i]);
            } else {
                System.out.println("차량번호 : " + parkingCarNum[i]);
                System.out.println("입차시간 : " + calculateParking.get(parkingCarNum[i]) + " / 출차시간 : " + parkingTime[i]);
                int parkingFees = 0;
                int[] hourArray = new int[2];
                hourArray[0] = Integer.parseInt(calculateParking.get(parkingCarNum[i]).substring(0, 2));
                hourArray[1] = Integer.parseInt(parkingTime[i].substring(0, 2));
                int[] minuteArray = new int[2];
                minuteArray[0] = Integer.parseInt(calculateParking.get(parkingCarNum[i]).substring(2, 4));
                minuteArray[1] = Integer.parseInt(parkingTime[i].substring(2, 4));
                parkingFees = getParkingFees(hourArray, minuteArray);
                System.out.println("주차요금 : " + parkingFees);
                if (!answerMap.containsKey(parkingCarNum[i])) {
                    answerMap.put(parkingCarNum[i], parkingFees);
                } else {
                    for (Map.Entry<String, Integer> entry : answerMap.entrySet()) {
                        int value = entry.getValue();
                        entry.setValue(value += parkingFees);
                    }
                }
                calculateParking.remove(parkingCarNum[i]);
            }
        }
        System.out.println("answerMap = " + answerMap);
        System.out.println("parkingTime = " + Arrays.toString(parkingTime));
        System.out.println("parkingCarNum = " + Arrays.toString(parkingCarNum));
        System.out.println("parkingStatus = " + Arrays.toString(parkingStatus));

        return answer;
    }

    public static int getParkingFees(int[] timeArray, int[] minuteArray) {
        int fees = 0;
        int time = ((timeArray[1] - timeArray[0]) * 60)+(Math.abs(minuteArray[1] - minuteArray[0]));
        System.out.println("주차 시간 = " + time);
        if (time <= 180) {
            return 5000;
        } else {
            System.out.println("주차 시간 -180분 = " + (time - 180));
            System.out.println("주차 시간 -180분 / 10분 = " + (time - 180) / 10);
            System.out.println("(주차 시간 -180분 / 10분) = " + Math.round((time - 180) / 10));
            System.out.println("주차 시간 -180분 / 10분 * 60 = " + ((time - 180) / 10) * 60);
            System.out.println("주차 시간 -180분 / 10분 * 60 + 5000 = " + (5000 + (((time - 180) / 10) * 60)));
            fees = (int) (5000 + (Math.round((time - 180) / 10) * 60));
            return fees;
        }
    }
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
//        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        String[] records = {"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"};
        System.out.println(Arrays.toString(solution(fees, records)));
    }
}
