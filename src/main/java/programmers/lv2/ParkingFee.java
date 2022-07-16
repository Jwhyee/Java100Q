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
     * 차량 번호가 작은 자동차부터 배열에 저장!
     * */
    static Map<String, String> parkingMap = new HashMap<>();
    static Map<String, Integer> answerMap = new HashMap<>();

    public static int getTime(String inTime, String outTime) {
        String[] inTimeArr = inTime.split(":");
        String[] outTimeArr = outTime.split(":");
        int hourSum = (Integer.parseInt(outTimeArr[0]) - Integer.parseInt(inTimeArr[0])) * 60;
        int minuteSum = Integer.parseInt(outTimeArr[1]) - Integer.parseInt(inTimeArr[1]);
        int timeSum = (hourSum + minuteSum);
//        System.out.println("hourSum = " + hourSum + " / " + "minuteSum = " + minuteSum + " / " + "timeSum = " + timeSum);
        return timeSum;
    }
    public static int getParkingFees(int[] fees, int timeSum) {
        int defaultTime = fees[0], defaultCost = fees[1], perMinute = fees[2], perCost = fees[3];
        System.out.println("timeSum = " + timeSum);
        if (timeSum <= defaultTime) {
            return defaultCost;
        } else {
            if ((timeSum - defaultTime) % perMinute == 0) {
                return defaultCost + (((timeSum - defaultTime) / perMinute) * perCost);
            } else {
                return defaultCost + ((((timeSum - defaultTime) / perMinute) + 1) * perCost);
            }
        }
    }
    public static int[] solution(int[] fees, String[] records) {
        for (String record : records) {
            StringTokenizer st = new StringTokenizer(record, " ");
            String parkingTime = st.nextToken();
            String carNum = st.nextToken();
            String parkingStatus = st.nextToken();
            switch (parkingStatus) {
                case "IN":
                    parkingMap.put(carNum, parkingTime);
                    break;
                case "OUT":
                    String inTime = parkingMap.get(carNum);
                    int timeSum = getTime(inTime, parkingTime);
                    answerMap.put(carNum, answerMap.getOrDefault(carNum, 0) + timeSum);
                    parkingMap.remove(carNum);
                    break;
            }
        }
        if (parkingMap.size() != 0) {
            for (String carNum : parkingMap.keySet()) {
                String parkingTime = parkingMap.get(carNum);
                int timeSum = getTime(parkingTime, "23:59");
                answerMap.put(carNum, answerMap.getOrDefault(carNum, 0) + timeSum);
            }
        }
        for (String carNum : answerMap.keySet()) {
//            System.out.println("carNum = " + carNum + " / fees = " + answerMap.get(carNum));
            int parkingFees = getParkingFees(fees, answerMap.get(carNum));
            answerMap.put(carNum, parkingFees);
        }

        System.out.println("answerMap = " + answerMap);
        List<String> keySet = new ArrayList<>(answerMap.keySet());
        Collections.sort(keySet);
        int[] answer = new int[keySet.size()];
        int i = 0;
        for (String carNum : keySet) {
            answer[i] = answerMap.get(carNum);
            i++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
//        int[] fees = {120, 0, 60, 591};
//        int[] fees = {1, 461, 1, 10};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
//        String[] records = {"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"};
//        String[] records = {"00:00 1234 IN"};
        System.out.println(Arrays.toString(solution(fees, records)));
    }
}
