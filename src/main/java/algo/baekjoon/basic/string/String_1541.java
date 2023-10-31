package algo.baekjoon.basic.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class String_1541 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");

        int answer = Integer.MAX_VALUE;

        while (st.hasMoreTokens()) {
            int temp = 0;

            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");

            while (st2.hasMoreTokens()) {
                temp += Integer.parseInt(st2.nextToken());
            }

            if (answer == Integer.MAX_VALUE) {
                answer = temp;
            } else {
                answer -= temp;
            }
        }
        System.out.println(answer);
    }
}
