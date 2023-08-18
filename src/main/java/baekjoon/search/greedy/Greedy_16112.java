package baekjoon.search.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Greedy_16112 {
    static long[] expArr;
    static int n, k;
    static ArrayList<Integer> activeStones;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        expArr = new long[n];
        activeStones = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            expArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(expArr);

        long result = 0;
        int activeStoneCnt = 1;

        for (int i = 1; i < n; i++) {
            if (activeStoneCnt < k) {
                result += expArr[i] * activeStoneCnt;
                activeStoneCnt++;
            } else {
                result += expArr[i] * activeStoneCnt;
            }
        }

        System.out.println(result);
    }
}
