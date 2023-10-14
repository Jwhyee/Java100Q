import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st;

        for(String operation : operations) {
            st = new StringTokenizer(operation);
            String cmd = st.nextToken();
            int n = Integer.parseInt(st.nextToken());

            if(cmd.equals("I")) {
                min.offer(n);
                max.offer(n);
            } else if (cmd.equals("D")) {
                if (n == 1) {
                    // 최대값 삭제
                    min.remove(max.poll());
                } else {
                    // 최소값 삭제
                    min.poll();
                }
            }
        }

        if (min.size() == 0) {
            return new int[]{0, 0};
        } else {
            return new int[]{max.poll(), min.poll()};
        }
    }
}