package baekjoon.basic.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_1543 {
    public static int countTarget(String str, String target) {
        int cnt = 0;
        str = str.replaceAll(target, "0");
        for (int i = 0; i < str.length(); i ++) {
            if (str.charAt(i) == '0') {
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String testCase = br.readLine();
        String target = br.readLine();
        br.close();
        System.out.println(countTarget(testCase, target));
    }
}

