package main.programmers.lv1;

public class NewNameRecommend {
    public static String solution(String new_id) {
        String answer = "";

        // 1단계 대문자 -> 소문자 치환
        answer = new_id.toLowerCase();
        System.out.println("1단계 = " + answer);

        // 2단계 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
        answer = answer.replaceAll("[^a-z0-9-_.]", "");
        System.out.println("2단계 = " + answer);

        // 3단계 ..이 연속되어 있으면 .으로 변경
        answer = answer.replaceAll("[.]{2,}", ".");
        System.out.println("3단계 = " + answer);

        // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if (answer.startsWith(".")) {
            answer = answer.substring(1);
        }
        if (answer.endsWith(".")) {
            answer = answer.substring(0, answer.length()-1);
        }
        System.out.println("4단계 = " + answer);

        // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if (answer.length() == 0) {
            answer = "a";
        }
        System.out.println("5단계 = " + answer);

        /* 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
         * 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다. */
        if (answer.length() > 15) {
            answer = answer.substring(0, 15);
            if (answer.endsWith(".")) {
                answer = answer.substring(0, 14);
            }
        }
        System.out.println("6단계 = " + answer);

        // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if (answer.length() < 3) {
            for (int i = answer.length(); i <= 2; i++) {
                answer = answer + answer.charAt(i-1);
            }
        }
        System.out.println("7단계 = " + answer);

        return answer;
    }

    public static void main(String[] args) {
//        String newId = "z-+.^.";
        String newId = "...!@BaT#*..y.abcdefghijklm";
//        String newId = ".abcdefghijklmn.p.";
        System.out.println("기존 id = " + newId);
        System.out.println("바뀐 id = " + solution(newId));
    }
}
