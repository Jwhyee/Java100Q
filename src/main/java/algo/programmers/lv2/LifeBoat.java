package algo.programmers.lv2;

import java.util.Arrays;

public class LifeBoat {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int min = 0;

        for (int max = people.length - 1; min <= max; max--){
            if (people[min] + people[max] <= limit) min++;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        LifeBoat c = new LifeBoat();
        int[] p = {70, 50, 80, 50};
        int l = 100;
        System.out.println(c.solution(p, l));
        p = new int[]{70, 80, 50};
        System.out.println(c.solution(p, l));
        p = new int[]{70, 20, 50};
        System.out.println(c.solution(p, l));
    }
}
