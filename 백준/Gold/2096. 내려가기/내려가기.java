import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][3];
        int[][] minDP = new int[n][3];
        int[][] maxDP = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        // 초기값
        minDP[0][0] = maxDP[0][0] = arr[0][0];
        minDP[0][1] = maxDP[0][1] = arr[0][1];
        minDP[0][2] = maxDP[0][2] = arr[0][2];

        for (int i = 1; i < n; i++) {
            // 최소값 DP
            minDP[i][0] = Math.min(minDP[i-1][0], minDP[i-1][1]) + arr[i][0];
            minDP[i][1] = Math.min(Math.min(minDP[i-1][0], minDP[i-1][1]), minDP[i-1][2]) + arr[i][1];
            minDP[i][2] = Math.min(minDP[i-1][1], minDP[i-1][2]) + arr[i][2];

            // 최대값 DP
            maxDP[i][0] = Math.max(maxDP[i-1][0], maxDP[i-1][1]) + arr[i][0];
            maxDP[i][1] = Math.max(Math.max(maxDP[i-1][0], maxDP[i-1][1]), maxDP[i-1][2]) + arr[i][1];
            maxDP[i][2] = Math.max(maxDP[i-1][1], maxDP[i-1][2]) + arr[i][2];
        }

        int min = Math.min(minDP[n-1][0], Math.min(minDP[n-1][1], minDP[n-1][2]));
        int max = Math.max(maxDP[n-1][0], Math.max(maxDP[n-1][1], maxDP[n-1][2]));

        System.out.println(max + " " + min);
    }
}
