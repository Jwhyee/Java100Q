import java.util.*;
class Solution {
    Map<String, String> parkingMap = new HashMap<>();
    Map<String, Integer> answerMap = new HashMap<>();

    public int getTime(String inTime, String outTime) {
        String[] inTimeArr = inTime.split(":");
        String[] outTimeArr = outTime.split(":");
        int hourSum = (Integer.parseInt(outTimeArr[0]) - Integer.parseInt(inTimeArr[0])) * 60;
        int minuteSum = Integer.parseInt(outTimeArr[1]) - Integer.parseInt(inTimeArr[1]);
        int timeSum = (hourSum + minuteSum);
        return timeSum;
    }
    public int getParkingFees(int[] fees, int timeSum) {
        int defaultTime = fees[0], defaultCost = fees[1], perMinute = fees[2], perCost = fees[3];
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
    public int[] solution(int[] fees, String[] records) {
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
            int parkingFees = getParkingFees(fees, answerMap.get(carNum));
            answerMap.put(carNum, parkingFees);
        }

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
}