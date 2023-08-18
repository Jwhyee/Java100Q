package baekjoon.basic.control_flow;

import java.io.*;
// public class Calculator{
public class CF_if_1330 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");

        int A = Integer.parseInt(str[0]);
        int B = Integer.parseInt(str[1]);


        bw.write((A>B) ? ">" : ((A<B) ? "<" : "==" ));
        bw.flush();
        bw.close();
        //System.out.println((A>B) ? ">" : ((A<B) ? "<" : "==" ));



    }
}
