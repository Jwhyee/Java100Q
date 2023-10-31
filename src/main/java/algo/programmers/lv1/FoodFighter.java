package algo.programmers.lv1;

public class FoodFighter {
    /**
     * @param food 적은 칼로리로 정렬된 음식
     * */
    public String solution(int[] food) {
        String answer = "";
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < food.length; i++) {
            if(i == 0) continue;
            for (int j = 0; j < food[i] / 2; j++) {
                answer += i;
                temp.append(i);
            }
        }
        answer += "0" + temp.reverse();
        return answer;
    }
    public static void main(String[] args) {
        FoodFighter ff = new FoodFighter();
        int[] food = {1, 3, 4, 6};
        String result = "1223330333221";
//        int[] food = {1, 7, 1, 2};
//        String result = "111303111";
        if (ff.solution(food).equals(result)) System.out.println("T");
    }
}
