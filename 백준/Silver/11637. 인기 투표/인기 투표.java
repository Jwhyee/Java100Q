import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int T, N;
    static int[] values;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            values = new int[N];
            int totalVotes = 0, max = -1, winner = -1;
            for (int i = 0; i < N; i++) {
                int votes = Integer.parseInt(br.readLine());
                totalVotes += votes;
                values[i] = votes;
                if (votes >= max) {
                    max = votes;
                    winner = i + 1;
                }
            }
            if (isDuplicateWinner(max)) {
                bw.append("no winner\n");
            } else {
                if (max > (totalVotes / 2)) {
                    bw.append("majority winner ");
                } else {
                    bw.append("minority winner ");
                }
                bw.append(winner + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isDuplicateWinner(int max) {
        int cnt = 0;
        for (int value : values) {
            if (value == max) {
                cnt++;
            }
        }
        return cnt != 1;
    }
}
