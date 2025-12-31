import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr= new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

            int[] dp = new int[n+1];
      /*
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<i; j++) {

            }
            dp[i] = max+1;
        }
        */
//        dp식 : max(dp[n-1];,dp[n-2]..)중에 arr[n]보다 작은dp 값 ++
        dp[1] =1 ;
        for(int i=2; i<=n;i++) {
            dp[i] = 1;
//            j는 i의 이전값들
            for (int j = 1; j<i; j++) {
//                j중에 i보다 작은 값이 있다면
                if(arr[j] < arr[i]) {
//                    현재 dp[i]는 현재값 vs dp[j]+1-> dp[j]는 이전 최대값이므로 수열이 늘어나게 되면
//                                                  +1을 해줘야됨 그래서 +1
                   dp[i]= Math.max(dp[i], dp[j]+1) ;
                }
            }
        }
        int max =0;
        for(int a : dp) {
            if(max<a) {
                max = a;
            }
        }
        System.out.println(max);
    }
}

//가장긴 증가하는 부분 수열 4
//-> 별도의 배열을 하나 더 만들어서 직전의 값을 기록