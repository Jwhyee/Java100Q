package algo.programmers.lv3;

import java.util.*;

/* 문제
 * 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
 * 베스트 앨범 : 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 출시
 */
/* 조건
 * 1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 * 2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 * 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 * 4. 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
 */
/* 풀이 순서
 * 1. 장르 별로 총 얼마나 재생되었는지 구하기
 * 2. 가장 많이 재생된 장르 중에서 재생 수가 가장 높은 노래 2개 구하기
 * 3. answer 배열에 넣기
 * */
public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        System.out.println("genres = " + Arrays.toString(genres));
        System.out.println("plays = " + Arrays.toString(plays));
        Map<String, Integer> playCountMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            // 장르별 총 재생 수
            playCountMap.put(genres[i], playCountMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        System.out.println("playCountMap = " + playCountMap);

        // countMap의 keySet으로 된 List를 만들어 재생 횟수가 가장 높은 순서대로 정렬
        List<String> genresList = new ArrayList<>(playCountMap.keySet());
        genresList.sort((o1, o2) -> playCountMap.get(o2) - playCountMap.get(o1));
        System.out.println("genresList = " + genresList);

        //
        List<Integer> countList = new ArrayList<>();
        for (int i = 0; i < genresList.size(); i++) {
            String genre = genresList.get(i);
            int max = 0;
            int firstIdx = -1;

            // 해당 장르의 음악 중에서 play 횟수가 첫번째로 큰 인덱스틀 찾기
            for(int j = 0; j < genres.length; j++) {
                if(genre.equals(genres[j]) && max < plays[j]) {
                    max = plays[j];
                    firstIdx = j;
                }
            }

            // 두번째로 큰 인덱스 찾기
            max = 0;
            int secondIdx = -1;
            for(int j = 0; j < genres.length; j++) {
                if(genre.equals(genres[j]) && max < plays[j] && j != firstIdx) {
                    max = plays[j];
                    secondIdx = j;
                }
            }

            countList.add(firstIdx);

            // 두번째 인덱스가 존재하면 list에 추가
            if(secondIdx >= 0) countList.add(secondIdx);
        }
        System.out.println("countList = " + countList);

        int[] answer = new int[countList.size()];
        for(int i = 0; i < countList.size(); i++) {
            answer[i] = countList.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        BestAlbum ba = new BestAlbum();
        // 테스트 케이스
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(ba.solution(genres, plays)));
    }
}
