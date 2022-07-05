package main.programmers.lv1;

public class FailureRate {
    public static int[] solution(int N, int[] stages) {
        /*
            실패율 = 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
            N = 전체 스테이지의 개수
            stages = 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호
        */

        int[] answer = new int[N];
        // 정답을 저장하는 배열
        int[] check = new int[N];
        // 몇 명이 해당 스테이지에 멈춰있는지를 저장하는 배열
        double[] failure = new double[N];
        // 실패율을 저장하는 배열

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < stages.length; j++) {
                if (i + 1 == stages[j]) {
                    check[i]++;
                }
            }
        }

        int totalPlayer = stages.length;
        for (int i = 0; i < check.length; i++) {
            int failPlayer = check[i];
            if (totalPlayer == 0) {
                failure[i] = 0;
            } else {
                failure[i] = (double) failPlayer / totalPlayer;
            }
            totalPlayer -= check[i];
        }

        double max = 0;
        int target = 1;
        for (int i = 0; i < failure.length; i++) {
            max = failure[0];
            target = 1;
            for (int j = 0; j < failure.length; j++) {
                if (failure[j] > max) {
                    max = failure[j];
                    target = j + 1;
                }
            }
            failure[target - 1] = -1;
            answer[i] = target;
        }

        return answer;
    }
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
    }
}
