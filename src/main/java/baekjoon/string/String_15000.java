package baekjoon.string;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class String_15000 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String msg = sc.next();
        System.out.println(msg.toUpperCase(Locale.ROOT));
    }
}
