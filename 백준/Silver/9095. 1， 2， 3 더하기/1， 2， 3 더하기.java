import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i =0; i<t; i++) {
            //입력받은 값을 n에 저장
            int n = Integer.parseInt(br.readLine());
            //배열이 dp[n]을 담으려면 길이가 n+1이여야함
            if(n<4) {
                if (n == 1) {
                    sb.append(1).append("\n");
                } else if (n == 2) {
                    sb.append(2).append("\n");
                } else if (n == 3) {
                    sb.append(4).append("\n");
                }
            } else {
            int[] dp = new int[n+1];
            //점화식을 만들 수 있도록 DP의 기초값을 직접 설정해야 하기 떄문
            dp[0] = 1;
            dp[1] = 2;
            dp[2] = 4;

            for(int j=3; j<n; j++) {
                //점화식
                dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
            }
            dp[n-1] = dp[n-2]+dp[n-3]+dp[n-4];
            sb.append(dp[n-1]).append("\n");
                }}
        System.out.print(sb);
            }}



/*
int[] numbers = {1, 2, 3};
int target;
int answer;


//n을 만들 수 있는 모든 경우의 수
public int dp(int target) {
    //dfs가 목표값을 알 수 있도록 저장
    this.target = target;
    //테스트마다 결과 초기회
    this.answer = 0;
    dfs(0);
    return answer;
}

void dfs(int sum) {
    //종료 조건
    if (sum == target) {
        answer++;
        return;
    }
    if (sum > target) {
        return;
    }
    //찾는 조건

    for (int i : numbers) {
        dfs(sum +i);
    }
}

public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int t = Integer.parseInt(br.readLine());

    plus123_9095 solve = new plus123_9095();

    for (int i = 0; i < t; i++) {
        int n = Integer.parseInt(br.readLine());
        int rs = solve.dp(n);
        sb.append(rs).append("\n");
    }
    System.out.print(sb);*/