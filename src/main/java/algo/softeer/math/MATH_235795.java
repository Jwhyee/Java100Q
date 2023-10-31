package algo.softeer.math;

import java.io.*;

/**
 * 문제 이름(난이도) : 지도 자동 구축(LV2)
 * 시간 : 74 ms
 * 메모리 : 10.22 MB
 * 링크 : https://softeer.ai/practice/info.do?idx=1&eid=413&sw_prbl_sbms_sn=235795
 */
public class MATH_235795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int mapSize = 2;
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            mapSize = (mapSize * 2) - 1;
            answer = mapSize * mapSize;
        }

        System.out.println(answer);
    }
}
