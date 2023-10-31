package algo.baekjoon.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*

11 7
XXX.XXX
X.XXX.X
X..X..X
X.....X
.......
.#.....
.#...#.
.#...#.
.##.##.
.#####.
#######

9 7
XXXXXXX
X..X..X
X.XXX.X
X.....X
.......
.#...#.
.##.##.
.#####.
#######

6 8
...X....
........
.......#
.......#
.......#
...#####

5 5
..X..
.....
##.##
##.##
#####

*/
/**
 * 문제 이름(난이도) : 유성(SIL1)
 * 시간 : 1 ms
 * 메모리 : 1 KB
 * 링크 : https://www.acmicpc.net/problem/10703
 */
public class BOJ_10703 {
    static int R, S;
    static char map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int min = Integer.MAX_VALUE;
        R = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        map = new char[R][S];

        // 값 입력
        for (int i = 0; i < R; i++) {
            String temp = br.readLine();
            for (int j = 0; j < S; j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        //운석과 땅사이에 존재하는 길이 구하기
        for (int j = 0; j < S; j++) {
            int cnt = 0;
            for (int i = 0; i < R; i++) {
                if (i + 1 < S && map[i][j] == 'X' && map[i + 1][j] == '.') {
                    for (int k = i + 1; k < R - 1; k++) {
                        if (map[k][j] == '#')
                            break;
                        if (map[k][j] == 'X') {
                            cnt = 0;
                            break;
                        }
                        if (map[k][j] == '.')
                            cnt++;
                    }
                }
                if (cnt > 0 && map[i][j] == '#') {
                    min = Math.min(cnt, min);
                    cnt = 0;
                }
            }
        }

        for (int j = 0; j < S; j++) {
            for (int i = R - 1; i >= 0; i--) {
                if (map[i][j] == 'X' && map[i + min][j] == '.') {
                    char temp = map[i][j];
                    map[i][j] = map[i + min][j];
                    map[i + min][j] = temp;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < S; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
