import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visit;
    static int answer;
    static int[][] maze = new int[11][11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int z = 0; z < t; z++) {
            answer = 0;
            visit = new boolean[11];
            for (int i = 0; i < 11; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    maze[i][j] = Integer.parseInt(st.nextToken());
                }
            }
//            첫번째 선수의 포지션부터 시작
            permu(0, 0);
            System.out.println(answer);
        }
    }

    static void permu(int p, int c) {
//        11명이 되면 리턴
        if (p == 11) {
            answer = Math.max(answer, c);
            return;
        }
//11명을 구하는데 방문한적이 없고 i번째 선수의 포지션의 값이 0보다 커야됨
        for (int i = 0; i < 11; i++) {
            if (!visit[i] && maze[i][p] > 0) {
                visit[i] = true;
//                다음 포지션
                permu(p + 1, c + maze[i][p]);
//                백트래킹
                visit[i] = false;
            }
        }
    }
}
