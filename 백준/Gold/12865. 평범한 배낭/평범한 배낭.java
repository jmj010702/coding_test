import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr= new int[n][2];
        for(int i =0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
             arr[i][0] = Integer.parseInt(st.nextToken());
             arr[i][1] = Integer.parseInt(st.nextToken());
            }
             Arrays.sort(arr, (o1, o2) -> o2[0] - o1[0]);

        int[] dp = new int[k+1];
        dp[0] = 0;

        for(int i= 0; i<n; i++) {
            for(int j =k; j>=arr[i][0]; j--){
                if(j-arr[i][0] >=0){
                dp[j] =Math.max(dp[j],dp[j -arr[i][0]] + arr[i][1]) ;
                }
            }
        }

        System.out.println(dp[k]);

    }
}
