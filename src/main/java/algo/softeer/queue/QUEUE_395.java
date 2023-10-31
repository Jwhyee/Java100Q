package algo.softeer.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 문제 이름(난이도) : 금고털이(LV2)
 * 시간 : 645 ms
 * 메모리 : 84.06 MB
 * 링크 : https://softeer.ai/practice/info.do?idx=1&eid=395&sw_prbl_sbms_sn=231986
 */
public class QUEUE_395 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int W = Integer.parseInt(split[0]);
        int N = Integer.parseInt(split[1]);
        PriorityQueue<Jewelry> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            String[] info = br.readLine().split(" ");
            int m = Integer.parseInt(info[0]);
            int p = Integer.parseInt(info[1]);
            queue.offer(new Jewelry(m, p));
        }

        int result = 0;
        while (!queue.isEmpty()) {
            Jewelry j = queue.poll();
            if (W < j.m) {
                result += (W * j.p);
                break;
            } else {
                result += (j.m * j.p);
                W = W - j.m;
            }
        }
        System.out.println(result);
    }

    static class Jewelry implements Comparable<Jewelry>{
        int m;
        int p;

        public Jewelry(int m, int p) {
            this.m = m;
            this.p = p;
        }

        @Override
        public int compareTo(Jewelry j) {
            return this.p < j.p ? 1 : -1;
        }
    }

}
