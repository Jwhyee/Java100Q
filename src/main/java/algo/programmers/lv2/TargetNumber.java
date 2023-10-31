package algo.programmers.lv2;

public class TargetNumber {
    int answer = 0, max;
    int[] graph;

    public int solution(int[] numbers, int target) {
        graph = numbers;
        max = target;
        dfs(0, 0);
        return answer;
    }

    public void dfs(int point, int sum) {
        if (point == graph.length) {
            if (max == sum) {
                answer++;
            }
        } else {
            dfs(point + 1, sum + graph[point]);
            dfs(point + 1, sum - graph[point]);
        }
    }

    public static void main(String[] args) {
        TargetNumber tn = new TargetNumber();
//        int[] numbers = {1, 1, 1, 1, 1};
//        int target = 3;
        int[] numbers = {4, 1, 2, 1};
        int target = 4;
        System.out.println(tn.solution(numbers, target));
    }
}
