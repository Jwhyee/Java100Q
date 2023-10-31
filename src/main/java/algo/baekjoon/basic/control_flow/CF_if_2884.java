package algo.baekjoon.basic.control_flow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class CF_if_2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] str = bf.readLine().split(" ");
        int H = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        LocalDateTime date = LocalDateTime.of(2022, 1, 20, H, M);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("H m");
        System.out.println(date.minusMinutes(45).format(dateTimeFormatter));
    }
}
