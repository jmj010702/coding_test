import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public int solution(int[][] triangle) {
      
        int[][] dp = new int[triangle.length][];
        for (int i = 0; i < triangle.length; i++) {
            dp[i] = new int[triangle[i].length];
        }
        
                dp[0][0] = triangle[0][0];
        dp[1][0] = triangle[0][0] + triangle[1][0];
        dp[1][1] = triangle[0][0] + triangle[1][1];

     for (int i = 2; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j ==0) dp[i][j] = dp[i - 1][j] + triangle[i][j];
                else if (j == triangle[i-1].length) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
                }
            }
        }
        int answer =0;
        for(int i = 0; i<dp[dp.length-1].length; i++) {
            if (answer < dp[dp.length-1][i]) {
                answer = dp[dp.length-1][i];
            }
        }

        return answer;
    }
}