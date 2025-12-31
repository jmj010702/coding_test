import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
//          홍보로 얻는 고객의 수
            arr[i][0] = c2;
//            홍보할 때 드는 비용
            arr[i][1] = c1;
        }
        int max = c + 100;
        int[] dp = new int[max + 1];
        int INF = 1000000;
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i][0]; j <= max; j++) {
//                같은 비용대비 최대  인구
//                같은 인구 대비 최소 비용
//                dp는 1원부터 n원까지 비용이 들것이다
//                각 금액당 최데 인원수 찾기
//                1 비용 = 배낭
//                2 앞에서부터 값을 채움
//                dp[x] = min(dp[x], dp[x-customers] + cost
//                dp[j] == 고객 x명을 얻는 최소 비용
//               dp[j]는 
                dp[j] = Math.min(dp[j], dp[j - arr[i][0]] + arr[i][1]);
//                  강사님 기준 dp의 인덱스를 비용으로 쓰고 값을 비용대비 최고 인원으로 푼다
//                dp[j] = Math.max(dp[j], dp[j-arr[i][1]] +arr[i][0]);
            }
        }
        int rs = INF;
        for (int i = c; i <= max; i++) {
            rs = Math.min(rs, dp[i]);
        }
        System.out.println(rs);
    }
}
