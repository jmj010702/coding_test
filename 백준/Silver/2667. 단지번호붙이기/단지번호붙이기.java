import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] maze;
    static int count;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visit;
    static List<Integer> countlist = new ArrayList<>();

    static int bfs(int startx, int startj) {
        Deque<int[]> dq = new ArrayDeque<>();
        int size = 1;
        dq.offer(new int[]{startx, startj});
        visit[startx][startj] = true;

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];


            for (int i = 0; i < 4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                if (maze[nx][ny] != 1 || visit[nx][ny]) continue;

                visit[nx][ny] = true;
                size++;
                dq.offer(new int[]{nx, ny});
            }

        }
        return size;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        maze = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 0; j < n; j++) {

                maze[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (maze[i][j] == 1 && !visit[i][j]) {
                    countlist.add(bfs(i, j));
                    count++;

                }
            }
        }
        countlist.sort(Comparator.naturalOrder());
        sb.append(count).append("\n");
        for (int a : countlist) {
            sb.append(a).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}
