import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
조합을 구하는 문제
ㅎ나씩만 넣을 수 있음
7n-1을 가진 가방이 여러개 있다고 칠 때
dp[i] = max(dp[i], dp[i-x]+v
 */
//배낭문제 : 여러개의 선택대상이 있고, 전체 자원 한도 내에서 선택 조합을 구성하여 최대값/최소값을 구하는 문제

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][2];
        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[i][0] = w;
            arr[i][1] = v;
        }
//물건의 개수만큼 루프
        for(int i=0; i<n; i++) {
//            최대 무게의 가방부터 접근을 해서 첫번째 물건의 무게까지 채우기
//            ex) j=7일때 i=0 (arr[i][0] = 6) 해당 무게까지 값을 채움
            for(int j = k; j>=arr[i][0]; j--) {
//              dp[j - arr[i][0]] == 이 물건을 넣기 전, 가방이 j- itemweight만큼 차 있었을 때의 가치
//                고로 dp[j] == 이 물건을 안 넣었을 때 dp[j-arr[i][0]] ==  이 물건을 넣었을 때
                dp[j]= Math.max(dp[j],dp[j-arr[i][0]] + arr[i][1]);
            }
        }
        System.out.println(dp[k]);
    }
}
//주어진 데이터를 1번만 사용가능 하면 배낭처럼 풀기
//벼락치기 - 백준 14728
//주어진 데이터를 여러번 사용 가능하면 호텔처럼 풀기
//호텔 -백준
