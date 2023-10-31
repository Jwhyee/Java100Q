package algo.softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Test6th {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Integer> seatList = new ArrayList<>();
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        while (st.hasMoreTokens()) {
            seatList.add(Integer.valueOf(st.nextToken()));
        }
        Collections.sort(seatList);

        int minSum = Integer.MAX_VALUE, minGap = Integer.MAX_VALUE, minIdx = 0;
        for (int i = 0; i < seatList.size() - 1; i++) {
            int seatOne = seatList.get(i);
            int seatTwo = seatList.get(i + 1);
            if (minGap > seatTwo - seatOne) {
                minGap = seatTwo - seatOne;
                minSum = seatOne + seatTwo;
                minIdx = i;
            }
        }
        System.out.println(sb.append(seatList.get(minIdx)).append(" ").append(seatList.get(minIdx + 1)));
    }
}
