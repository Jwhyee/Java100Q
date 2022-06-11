import java.util.Scanner;

public class TestCode {
    public static void main(String[] args) {
        // 7번 문제
        /*System.out.println(57+12.8);
        System.out.println('2' + 3);
        System.out.println(10/3.0);
        System.out.println(10==9);*/

        // 8번 문제
        //byte var = 0; int num = 0; double real = 0;
        //real = num;
        //real = var;
        //num = (int) var;
        //var = num;
        //num = (int)0.1;

        // 9번 문제
        /*final double PI = 3.14;
        int x = 50;
        double y = 15;*/
        //y = ++x + PI;
        //x = y + PI;
        //PI = y;
        //y = PI++;

        // 10번 문제
        /*int a = 5, b;
        a++;
        b = a;
        a = ++b;
        System.out.println("a = " + a + ", b = " + b);*/

        // 11번 문제
        /*double radius = 2.0;
        double ballVolume = (4 / 3) * radius * radius * radius * 3.1;

        System.out.println(ballVolume);*/

        // 12번 문제
        /*for (int i = 1; i < 10; i++) {
            if (i % 3 != 0) {
                continue;
            }
            else
                System.out.print(i + " ");
        }*/

        // 13번 문제
        /*int[] num = {1, 2, 3, 4, 5};
        int s = 0;

        for (int k : num) {
            s += k;
        }
        System.out.println(s);*/

        // 14번 문제
        //int numbers[3] = {1, 3, 7};
        //int numbers[] = {1, 3, 7};
        //int numbers[] = new int[3];
        //int[] numbers = new int[5];

        // 15번 문제
        /*int[][] x = {{1, 2, 3, 4}, {3, 4, 5, 6}, {6, 7, 8, 9}};
        int[][] y = x;
        System.out.println(y[2][1]);*/

        // 18번 문제
        /*Scanner sc = new Scanner(System.in);
        System.out.println("정수를 입력하세요.");
        int time = sc.nextInt();
        int second = time % 60;
        int minute = (time / 60) % 60;
        int hour = (time / 60) / 60;
        System.out.println(time + "초 : " + hour + "시간 " + minute + "분 " + second + "초입니다.");*/

        // 19번
        /*int lineCtrl, numCtrl;
        for (lineCtrl = 1; lineCtrl <= 3; lineCtrl++) {
            for (numCtrl = 1; numCtrl <= lineCtrl; numCtrl++) {
                System.out.print(numCtrl);
            }
            System.out.println();
        }*/

        // 20번
        /*Scanner sin = new Scanner(System.in);
        System.out.print("임의의 정수를 입력하세요. : ");
        int repeat = sin.nextInt();

        for (int i = repeat; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }*/

        // 21번
        /*Scanner in = new Scanner(System.in);
        int intArray[] = new int[5];
        int max = 0;

        for (int i = 0; i < 5; i++) {
            intArray[i] = in.nextInt();
            if(intArray[i] > max)
                max = intArray[i];
        }
        System.out.println("max = " + max);*/

        // 22번
        /*Scanner in = new Scanner(System.in);
        double dArray[] = new double[10];
        double sum = 0;
        int i = 0;
        while (i < dArray.length && (dArray[i] = in.nextDouble()) != -1) {
            sum += dArray[i];
            i++;
        }
        System.out.println("배열 원소의 평균 : " + sum/i);*/

        // 23번
        /*int intArray[][] = {{90, 90, 110, 110}, {120, 110, 100, 110}};
        int yearSum[] = new int[intArray.length];
        int quarterSum[] = new int[intArray[0].length];

        for (int i = 0; i < intArray.length; i++) {
            for (int j = 0; j < intArray[0].length; j++) {
                yearSum[i] += intArray[i][j];
                quarterSum[j] += intArray[i][j];
            }
        }
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(i + 1 + "차 년도 : " + yearSum[i]);
        }
        for (int i = 0; i < intArray[0].length; i++) {
            System.out.print((i + 1) + "분기 합 : " + quarterSum[i] + ", ");
        }*/
    }
}
