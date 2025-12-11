import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    //public static int[][] dp = new int[41][2];

    //재귀함수 돌아가는 곳
    public static int[] fibo(int a) {
        int[][] dp = new int[41][2];
        dp[0][0] = 1;
        dp[1][0] = 0;
        dp[1][1] = 1;
        for (int i = 2; i <= a; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }
        return new int[]{dp[a][0], dp[a][1]};
    }
        /*
        if (a == 0) {
            return new int[]{1, 0};
        } else if (a == 1) {
            return new int[]{0, 1};

        } else if (dp[a][0] != 0 || dp[a][1] != 0) {
            return dp[a];
        } else {
            int[] value_1 =fibo(a-1);
            int[] value_2=fibo(a-2);
            dp[a][0] = value_1[0] + value_2[0];
            dp[a][1] = value_1[1] + value_2[1];
            return dp[a];
        }*/


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            int[] res = fibo(m);
            sb.append(res[0]).append(" ").append(res[1]).append("\n");
        }
        System.out.print(sb);
    }


}