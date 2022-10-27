package programmers.lv2;

import java.util.Arrays;

public class RotateBorder {
    int[][] table;
    public void printArray() {
        for (int[] ints : table) {
            for (int anInt : ints) {
                if (anInt < 10) System.out.print(anInt + "  ");
                else System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
    public int[][] dataInit(int rows, int columns) {
        table = new int[rows][columns];
        int cnt = 1;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = cnt++;
            }
        }
        return table;
    }

    public int moveTable(int[] query) {
        int x1 = query[0] - 1;
        int y1 = query[1] - 1;
        int x2 = query[2] - 1;
        int y2 = query[3] - 1;

        int temp = table[x1][y1];
        int min = temp;

        for (int i = x1; i < x2; i++) {
            table[i][y1] = table[i + 1][y1];
            if(min > table[i][y1]) min = table[i][y1];
        }
        for (int i = y1; i < y2; i++) {
            table[x2][i] = table[x2][i + 1];
            if(min > table[x2][i]) min = table[x2][i];
        }
        for (int i = x2; i > x1; i--) {
            table[i][y2] = table[i - 1][y2];
            if(min > table[i][y2]) min = table[i][y2];
        }
        for (int i = y2; i > y1; i--) {
            table[x1][i] = table[x1][i - 1];
            if(min > table[x1][i]) min = table[x1][i];
        }
        table[x1][y1 + 1] = temp;

        return min;
    }
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        table = dataInit(rows, columns);

        int idx = 0;
        for (int[] query : queries) {
            answer[idx] = moveTable(query);
            idx++;
        }

        return answer;
    }

    public static void main(String[] args) {
        RotateBorder rb = new RotateBorder();
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        int[] result = {8, 10, 25};

//        int rows = 3;
//        int columns = 3;
//        int[][] queries = {{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}};
//        int[] result = {1, 1, 5, 3};

//        int rows = 100;
//        int columns = 97;
//        int[][] queries = {{1, 1, 100, 97}};
//        int[] result = {1};

        if (Arrays.equals(result, rb.solution(rows, columns, queries))) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
