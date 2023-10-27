import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, HP, POTION, max;
    static boolean[] visited;
    static List<Node> milkList;
    static Node homeNode;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        HP = Integer.parseInt(st.nextToken());
        POTION = Integer.parseInt(st.nextToken());

        milkList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 1) {
                    homeNode = new Node(j, i);
                } else if (n == 2) {
                    milkList.add(new Node(j, i));
                }
            }
        }
        visited = new boolean[milkList.size()];

        backTracking(0, homeNode.x, homeNode.y, 0, HP);

        System.out.println(max);
    }

    private static void backTracking(int depth, int prevX, int prevY,
                                     int cnt, int curHp) {
        int distance = getDistance(homeNode.x, prevX, homeNode.y, prevY);
        if (distance <= curHp) {
            max = Math.max(max, cnt);
//            return;
        }

        for (int i = 0; i < milkList.size(); i++) {
            Node node = milkList.get(i);
            distance = getDistance(prevX, node.x, prevY, node.y);
            if (distance <= curHp && !visited[i]) {
                int temp = curHp;
                visited[i] = true;
                curHp = (curHp - distance) + POTION;
                backTracking(depth + 1, node.x, node.y, cnt + 1, curHp);
                curHp = temp;
                visited[i] = false;
            }
        }
    }

    private static int getDistance(int x1, int x2, int y1, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}