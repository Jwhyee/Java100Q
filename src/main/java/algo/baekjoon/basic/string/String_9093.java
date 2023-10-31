package algo.baekjoon.basic.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
2
I am happy today
We want to win the first prize
*/
public class String_9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer ="";
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String testCase = br.readLine();
            StringTokenizer st = new StringTokenizer(testCase);

            int wordCount = countChar(testCase, ' ');
            for (int j = 0; j < wordCount + 1; j++) {
                answer += reverseWord(st.nextToken()) + " ";
            }
            System.out.print(answer.trim() + "\n");
            answer = "";
        }
    }
    public static int countChar(String str, char ch) {
        return str.length() - str.replace(String.valueOf(ch), "").length();
    }
    public static String reverseWord(String word) {
        String newWord = "";
        for (int i = word.length()-1; i >= 0 ; i--) {
            newWord += word.charAt(i);
        }
        return newWord;
    }
}