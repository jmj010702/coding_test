import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[][][] maze;
    static int n, m, h;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static Deque<int[]> dq = new ArrayDeque<>();
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        maze = new int[m][n][h];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    maze[k][j][i] = Integer.parseInt(st.nextToken());
                    if (maze[k][j][i] == 1) dq.offer(new int[]{k,j,i});
                }
            }
        }

        bfs();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (maze[k][j][i] == 0) {
                        System.out.println(-1);
                        return;
                    }
                        max = Math.max(max, maze[k][j][i]);
                }
            }
        }
        System.out.println(max-1);
    }

    static void bfs() {

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];
            int z = cur[2];

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n || nz < 0 || nz >= h) continue;
                if (maze[nx][ny][nz] != 0) continue;

                maze[nx][ny][nz] = maze[x][y][z] + 1;
                dq.offer(new int[]{nx, ny, nz});
            }
        }
    }

}
