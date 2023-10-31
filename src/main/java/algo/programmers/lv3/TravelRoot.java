package algo.programmers.lv3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TravelRoot {
    List<String> root;
    String[][] tickets;
    boolean[] visited;
    StringBuilder sb;
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        root = new ArrayList<>();
        visited = new boolean[tickets.length];
        sb = new StringBuilder();

        backTracking(0, "ICN", "ICN");
        Collections.sort(root);
        System.out.println("root = " + root);
        return root.get(0).split(" ");
    }

    public void backTracking(int depth, String start, String path) {
        if (depth == tickets.length) {
            root.add(path);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(start) && !visited[i]) {
                visited[i] = true;
                backTracking(i + 1, tickets[i][1], path + " " + tickets[i][1]);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        TravelRoot t = new TravelRoot();
        String[] answer = {"ICN", "JFK", "HND", "IAD"};
        String[] solution = t.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
        if (Arrays.equals(solution, answer)) {
            System.out.println("case1 : " + true);
        }

        String[] answer1 = {"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"};
        String[] solution1 = t.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}});
        if (Arrays.equals(solution1, answer1)) {
            System.out.println("case 2 : " + true);
        }

    }
}
