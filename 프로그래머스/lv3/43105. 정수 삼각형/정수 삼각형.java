import java.util.*;

class Solution {
    // 7
    // 3 8
    // 8 1 0
    // 2 7 4 4
    // 4 5 2 6 5
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        
        // 줄 컨트롤
        for(int i = 0; i < triangle.length -1; i++) {
            for(int j = 0; j < triangle[i].length; j++) {
                int cur = dp[i][j];
                
                // 바로 아래 값과 오른쪽 값 확인
                int down = dp[i + 1][j];
                dp[i + 1][j] = Math.max(dp[i + 1][j], cur + triangle[i + 1][j]);
                
                int downNext = dp[i + 1][j + 1];
                dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], cur + triangle[i + 1][j + 1]);
            }
        }
        
        int answer = Integer.MIN_VALUE;
        for(int i = 0; i < dp[triangle.length - 1].length; i++) {
            answer = Math.max(dp[triangle.length - 1][i], answer);
        }
        
        return answer;
    }
}