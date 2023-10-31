package algo.baekjoon.basic.control_flow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_for_if_10871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String answer = "";
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            System.out.println("temp = " + temp);
            if (temp < X) {
                answer += temp;
            }
        }
        br.close();
        System.out.print(answer);
    }
}

//10 5
//1 10 4 9 2 3 8 5 7 6