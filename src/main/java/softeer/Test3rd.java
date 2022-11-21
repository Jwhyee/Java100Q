package softeer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Test3rd {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> jumpList = new ArrayList<>();
        String input = br.readLine();
        int size = Integer.parseInt(input.split(" ")[0]);
        int jumpCnt = Integer.parseInt(input.split(" ")[1]);
        System.out.println("input = " + input);
        for (int i = 0; i < jumpCnt; i++) {
            input = br.readLine();
            int startPoint = Integer.parseInt(input.split(" ")[0]);
            int endPoint = Integer.parseInt(input.split(" ")[1]);
            if (startPoint == size - 1 && startPoint > endPoint) {
                System.out.println(-1);
                System.exit(0);
            }
            if (startPoint < endPoint) {
                jumpList.add(startPoint);
                jumpList.add(endPoint);
            }
        }
    }
}
