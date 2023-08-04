package softeer.security;

import java.io.*;
import java.util.*;

/**
 * 문제 이름(난이도) : 플레이페어 암호(LV3)
 * 시간 : 75 ms
 * 메모리 : 10.29 MB
 * 링크 : https://softeer.ai/practice/info.do?idx=1&eid=804&sw_prbl_sbms_sn=235969
 */
public class SEC_804 {
    static char[][] cipher = new char[5][5];
    static Map<Character, Point> pointMap = new HashMap<>();
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String msg = br.readLine();
        String key = br.readLine();

        makePlayfairCipher(key);
        createMap();
        String fair = makeMessageFair(msg);
        String answer = makeSecurityFair(fair);
        System.out.println(answer);
        br.close();
    }

    private static void makePlayfairCipher(String key) {
        List<Character> builder = new LinkedList<>();
        char[] keyArray = key.toCharArray();
        for (char c : keyArray) {
            if (!builder.contains(c)) {
                builder.add(c);
            }
        }

        char charCtr = 'A';
        while (builder.size() != 25) {
            if (!builder.contains(charCtr) && charCtr != 'J') {
                builder.add(charCtr);
            }
            charCtr++;
        }

        for (int i = 0; i < cipher.length; i++) {
            for (int j = 0; j < cipher.length; j++) {
                cipher[i][j] = builder.get((i * cipher.length) + j);
            }
        }
    }

    private static void createMap() {
        for (int i = 0; i < cipher.length; i++) {
            for (int j = 0; j < cipher.length; j++) {
                pointMap.put(cipher[i][j], new Point(i, j));
            }
        }
    }

    private static String makeMessageFair(String msg) {
        sb = new StringBuilder();
        for (int i = 0; i < msg.length(); i += 2) {
            char c1 = msg.charAt(i);
            char c2 = i + 1 >= msg.length() ? ' ' : msg.charAt(i + 1);
            if (c1 == c2 || c2 == ' ') {
                i--;
                if (c1 == 'X') {
                    c2 = 'Q';
                } else {
                    c2 = 'X';
                }
            }
            sb.append(c1).append(c2);
        }

        return sb.toString().trim();
    }

    private static String makeSecurityFair(String fair) {
        sb = new StringBuilder();
        for (int i = 0; i < fair.length(); i += 2) {
            char c1 = fair.charAt(i);
            Point p1 = pointMap.get(c1);
            char c2 = fair.charAt(i + 1);
            Point p2 = pointMap.get(c2);
            switch (findCase(p1, p2)) {
                case 1 : {
                    int nx = (p1.x + 1) % 5;
                    sb.append(cipher[p1.y][nx]);
                    nx = (p2.x + 1) % 5;
                    sb.append(cipher[p2.y][nx]);
                    break;
                }
                case 2 : {
                    int ny = (p1.y + 1) % 5;
                    sb.append(cipher[ny][p1.x]);
                    ny = (p2.y + 1) % 5;
                    sb.append(cipher[ny][p2.x]);
                    break;
                }
                default: {
                    sb.append(cipher[p1.y][p2.x]);
                    sb.append(cipher[p2.y][p1.x]);
                }
            }
        }
        return sb.toString();
    }

    private static int findCase(Point p1, Point p2) {
        if (p1.y == p2.y) {
            return 1;
        } else if (p1.x == p2.x) {
            return 2;
        }
        return 3;
    }

    static class Point {
        int x;
        int y;

        public Point(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }

    public static void showMatrix() {
        Arrays.stream(cipher)
                .map(Arrays::toString)
                .forEach(System.out::println);
        System.out.println("----------------");
    }
}
