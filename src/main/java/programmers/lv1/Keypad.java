package programmers.lv1;

public class Keypad {
    /*
    *   1. 엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
        2. 왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
        3. 오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
        4. 가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
        4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
    */
    // 1   2   3
    // 4   5   6
    // 7   8   9
    // *   0   #
    public static String solution(int[] numbers, String hand) {
        String answer = "";
        int[] handPosition = {10, 10};
        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];
            if (n == 0) {
                n = 10;
            }
            if (n == 1 || n == 4 || n == 7) {
                handPosition[0] = n;
                answer += "L";
            }
            if (n == 3 || n == 6 || n == 9) {
                handPosition[1] = n;
                answer += "R";
            } else {
                for (int j = 0; j < handPosition.length; j++) {

                }
                switch (hand) {
                    case "right":
                        break;
                    case "left":
                        break;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
//        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "right";
        System.out.println(solution(numbers, hand));
    }
}
