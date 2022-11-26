package codetest.kakaomobilty;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Question2nd {
    /**
     * 물품을 구매한 고객들에게 10% 할인 쿠폰 지급
     * - 하루 최대 1장씩 받을 수 있음
     * - 고객 1명당 최대 k장 받을 수 있음
     * @param id_list 고객ID 배열
     * @param k 최대로 받을 수 있는 쿠폰 수
     * */
    public int solution(String[] id_list, int k) {
        int answer = 0;
        Map<String, Integer> couponMap = new HashMap<>();
        for (int day = 0; day < id_list.length; day++) {
            List<String> buyerList = Arrays.stream(id_list[day].split(" ")).distinct().collect(Collectors.toList());
            for (String id : buyerList) {
                if(!couponMap.containsKey(id)) couponMap.put(id, 1);
                else{
                    int couponCount = couponMap.get(id);
                    if(couponCount < k) couponMap.put(id, couponMap.getOrDefault(id, 0) + 1);
                }
            }
        }
        for (Integer coupon : couponMap.values()) {
            answer += coupon;
        }
        return answer;
    }
    public static void main(String[] args) {
        Question2nd qt = new Question2nd();
        String[] id_list = {"A B C D", "A D", "A B D", "B D"};
        int k = 2;
//        String[] id_list = {"JAY", "JAY ELLE JAY MAY", "MAY ELLE MAY", "ELLE MAY", "ELLE ELLE ELLE", "MAY"};
//        int k = 3;
        System.out.println(qt.solution(id_list, k));
    }
}
