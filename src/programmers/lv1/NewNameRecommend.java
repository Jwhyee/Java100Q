package programmers.lv1;

public class NewNameRecommend {
    public static String solution(String new_id) {
        String answer = "";
        // 1단계 대문자 -> 소문자 치환
        new_id.toLowerCase();
        System.out.println("1단계 = " + new_id);
        // 2단계 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
        for (int i = 0; i < new_id.length(); i++) {
            if (String.valueOf(new_id.charAt(i)).matches("[a-z0-9-_.]")) {
                answer += new_id.charAt(i);
            }
        }
        System.out.println("2단계 = " + answer);
        // 3단계 ..이 연속되어 있으면 .으로 변경
        answer.replaceAll("..", "");
        System.out.println("3단계 = " + answer);

        // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.

        // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if (new_id.length() == 0) {
            new_id.replaceAll("", "a");
        }

        /* 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
         * 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다. */



        // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.

        return answer;
    }

    public static void main(String[] args) {
        String newId = "...!@BaT#*..y.abcdefghijklm";
        System.out.println("기존 id = " + newId);
        System.out.println("바뀐 id = " + solution(newId));
    }
}
