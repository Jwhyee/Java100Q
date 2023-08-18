package baekjoon.basic.control_flow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CF_if_9498 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int score = Integer.parseInt(str);

        System.out.println((score >= 90) ? "A" : ((score >= 80) ? "B" : (score >= 70) ? "C" : (score >= 60) ? "D" : "F"));
    }
}
