import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int max = 1000000;
    static boolean[] visit = new boolean[max + 1];
    static int[] dist = new int[max + 1];
    static int INF = Integer.MAX_VALUE;

    static int bfs(int start, int end) {
        Arrays.fill(dist, INF);
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(start);
        dist[start] = 0;
        visit[start] = true;

        while (!dq.isEmpty()) {
            int x = dq.poll();

            if (x == end) {
                return dist[x];
            }

//       순간이동 ((0)초
            int nx = x * 2;
            if (nx <= max && dist[nx] > dist[x]) {
                dist[nx] = dist[x];
                dq.offerFirst(nx);
            }

//        x-1(1초)
            nx = x - 1;
            if (nx >= 0 && dist[nx] > dist[x] + 1) {
                dist[nx] = dist[x] + 1;
                dq.offerLast(nx);
            }

//        x+1 (1초)
            nx = x + 1;
            if (nx <= max && dist[nx] > dist[x] + 1) {
                dist[nx] = dist[x] + 1;
                dq.offerLast(nx);
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(bfs(n, k));

    }
}
