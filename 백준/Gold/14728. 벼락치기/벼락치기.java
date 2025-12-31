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
        int t = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][2];
        for(int i=0; i< n; i++) {
             st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            arr[i][0] = k;
            arr[i][1] = s;
        }
        int[] dp = new int[t+1];

        for(int i=0; i<n; i++) {
            for(int j = t; j>=arr[i][0]; j-- /*-= arr[i][0]*/) {
                dp[j]= Math.max(dp[j], dp[j-arr[i][0]] +arr[i][1]);
            }
        }

        System.out.println(dp[t]);


    }
}
