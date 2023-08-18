package baekjoon.search.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Greedy_1931 {
    static List<Time> list = new ArrayList<>();
    static int N;

    static class Time {
        int start;
        int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.add(new Time(start, end));
        }

        compare_sort();

        greedy();

    } // End of main

    static void compare_sort() {

        Collections.sort(list, new Comparator<Time>() {

            @Override
            public int compare(Greedy_1931.Time o1, Greedy_1931.Time o2) {

                if(o1.end == o2.end) {
                    return o1.start - o2.start;
                }

                return o1.end - o2.end;
            }
        });
    }

    static void greedy() {
        int count = 0;
        int prev_end_time = 0;

        for(int i=0; i<N; i++) {
            Time time = list.get(i);

            if(prev_end_time <= time.start) {
                prev_end_time = time.end;
                count++;
            }


        }

        System.out.println(count);
    }
}
