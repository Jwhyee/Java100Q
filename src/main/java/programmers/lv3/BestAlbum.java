package programmers.lv3;

import java.util.Arrays;

public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        /*
        * 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
        * 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
        * 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
        */
        int[] answer = {};

        return answer;
    }

    public static void main(String[] args) {
        BestAlbum ba = new BestAlbum();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(ba.solution(genres, plays)));
    }
}
