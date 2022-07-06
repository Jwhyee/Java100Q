package baekjoon.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Map_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; // TestCase 분리를 위한 StringTokenizer
        int T = Integer.parseInt(br.readLine());    // 가장 첫 줄에 오는 TestCase 총 개수
        for (int i = 0; i < T; i++) {
            Map<String, Integer> partCountMap = new HashMap<>(); // 부위와 횟수를 저장하는 Map
            int N = Integer.parseInt(br.readLine());
            // TestCase 루프
            for (int j = 0; j < N; j++) {
                // StringTokenizer를 사용해서 옷과 부위를 분해
                st = new StringTokenizer(br.readLine());
                String wear = st.nextToken();
                String part = st.nextToken();

                // 부위와 횟수를 partCountMap에 저장한다.
                // getOrDefault를 사용해서 해당 Key값이 존재하면 그 값을 반환, 없다면 default인 0값을 추가 -> 덮어쓰기
                // 값을 불러온 상태이기 때문에 최신화를 위해 +1을 해줌
                partCountMap.put(part, partCountMap.getOrDefault(part, 0) + 1);
            }
            // 경우의 수를 저장하는 cases -> 1로 초기화(값을 곱할 때 사용하기 때문 + 알몸일 경우를 기준)
            int cases = 1;

            // iterator로 valueSet -> 경우의 수 곱하기
            for (Integer value : partCountMap.values()) {
                // cases에 value + 1을 누적곱 해준다.
                // +1 -> 아무것도 입지 않고 해당 부위에만 1번씩 입을 경우
                cases *= (value + 1);
            }
            // 알몸일 경우를 제외해서 cases를 출력
            System.out.println(cases - 1);
        }
    }
}
