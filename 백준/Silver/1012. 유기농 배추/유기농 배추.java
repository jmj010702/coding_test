import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[][] maze;
    static int m, n;
    static boolean[][] visit;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    static void bfs(int startx, int starty) {
        Deque<int[]> dq = new ArrayDeque<>();

        dq.offer(new int[]{startx, starty});
        visit[startx][starty] = true;

        while(!dq.isEmpty()) {
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i = 0; i<4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx<0 || ny <0 || nx>=m || ny>=n) continue;

                if(visit[nx][ny] || maze[nx][ny] != 1) continue;

                visit[nx][ny] = true;
                dq.offer(new int[]{nx,ny});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
//        테스트 케이스
        int t = Integer.parseInt(br.readLine());

        for(int c = 0; c<t; c++) {
            st = new StringTokenizer(br.readLine());
//        가로길이
            m = Integer.parseInt(st.nextToken());
//                세로길이
            n = Integer.parseInt(st.nextToken());
//                배추 개수
            int k = Integer.parseInt(st.nextToken());

            maze = new int[m][n];
            visit = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    maze[i][j] = 0/* 지렁이 */;
                }
            }

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int q = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                maze[q][w] = 1/* 지렁이 */;
            }

            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (maze[i][j] == 1 && !visit[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
