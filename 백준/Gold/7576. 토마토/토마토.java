import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //    각 좌표마다 거리 갱신
//    그 후에 좌표 최대값 저장
//    만약 좌표 중 0이 있으면 -1
    public static int[][] maze;
    public static int n, m;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void bfs() {
        Deque<int[]> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == 1) {
                    dq.offer(new int[]{i, j});
                }
            }
        }
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (maze[nx][ny] != 0) continue;

                maze[nx][ny] = maze[x][y] + 1;
                dq.offer(new int[]{nx, ny});

            }

        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        maze = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, maze[i][j]);
            }

        }
        System.out.println(max - 1);
    }
}

