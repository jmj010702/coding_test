import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    static String[][] maze;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visit;
    static Deque<int[]> dq = new ArrayDeque<>();
    static int n, m;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new String[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String chr = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = String.valueOf(chr.charAt(j));
                if (maze[i][j].equals("I")) {
                    dq.offer(new int[]{i, j});
                    visit[i][j] = true;
                }
            }
        }
        bfs();
        if (count == 0) {
            System.out.println("TT");
        } else {
            System.out.println(count);
        }

    }


    static int bfs() {
        count = 0;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (Objects.equals(maze[nx][ny], "X") || visit[nx][ny]) continue;
                if (maze[nx][ny].equals("P")) count++;
                visit[nx][ny] = true;
                dq.offer(new int[]{nx, ny});
            }
        }
        return count;
    }
}
