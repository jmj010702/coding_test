import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] maze;

    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Deque<int[]> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String a = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = a.charAt(j) - '0';
            }
        }
        for (int j = 0; j < m; j++) {
            if (maze[0][j] == 0) {
                dq.offer(new int[]{0, j});
                visit[0][j] = true;
            }
        }
        bfs();

//        System.out.println(Arrays.deepToString(maze));
        for (int i = 0; i < m; i++) {
            if (visit[n - 1][i]) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

    static void bfs() {

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];
            if (x == n - 1) return;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (maze[nx][ny] != 0 || visit[nx][ny]) continue;

                visit[nx][ny] = true;
                dq.offer(new int[]{nx, ny});
            }
        }
    }
}
