import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] dp = new int[k + 1];
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int min = 987654321;
        Arrays.sort(arr);
        Arrays.fill(dp, min);
        dp[0] = 0;
        for(int i=1; i<=k; i++) {
            for(int j =0; j<n; j++) {
//                if(i-arr[j]>=0 && dp[i -arr[j]] <min && dp[i -arr[j]] <0 ) {
                  if(i-arr[j] >=0) {
             dp[i] = Math.min(dp[i], dp[i -arr[j]] +1);
                }
            }
        }
        if(dp[k] == min) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
    }
}
