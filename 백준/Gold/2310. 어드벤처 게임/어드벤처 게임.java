import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 제목 : 어드벤처 게임 [골드4]
 * 시간 : ? ms
 * 메모리 : ? KB
 * 링크 : https://www.acmicpc.net/problem/2310
 * */
public class Main {

    static int[] costs;
    static Room[] rooms;
    static int N, curCost = 0;
    static boolean flag;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        while (true) {
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            curCost = 0;
            costs = new int[N];
            rooms = new Room[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                String type = st.nextToken();

                int fee = Integer.parseInt(st.nextToken());
                if (type.equals("T")) fee = -fee;

                List<Integer> roomList = new ArrayList<>();

                while (st.hasMoreTokens()) {
                    int room = Integer.parseInt(st.nextToken());
                    if (room == 0) break;
                    roomList.add(room);
                }

                rooms[i] = new Room(type, fee, roomList);


            }

            flag = false;

            dfs(0, 0);

            if (flag) {
                bw.append("Yes\n");
            } else {
                bw.append("No\n");
            }

        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int cur, int money) {
        if (money < 0) return;
        if (cur + 1 == N) {
            flag = true;
            return;
        }


        Room curRoom = rooms[cur];

        for (int i : curRoom.roomList) {
            Room nr = rooms[i - 1];
            if (nr.visited) continue;

            if (nr.type.equals("L")) {
                if (nr.fee > money) {
                    money = nr.fee;
                }
            } else if (nr.type.equals("T")) {
                if (nr.fee <= money) money += nr.fee;
                else return;
            }

            nr.visited = true;
            dfs(i - 1, money);
            nr.visited = false;
        }
    }

    private static class Room {
        String type;
        int fee;
        List<Integer> roomList;
        boolean visited;

        public Room(String type, int fee, List<Integer> roomList) {
            this.type = type;
            this.fee = fee;
            this.roomList = roomList;
            this.visited = false;
        }
    }
}
