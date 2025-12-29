import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visit;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        visit = new boolean[n + 1];
        graph = new List[n + 1];
        dist = new int[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        bfs(a);
        if (visit[b]) System.out.println(dist[b]);
        else System.out.println(-1);
    }

    static void bfs(int start) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(start);
        visit[start] = true;
        dist[start] = 0;

        while (!dq.isEmpty()) {
            int cur = dq.poll();

            for (int next : graph[cur]) {
                if (visit[next]) continue;
                visit[next] = true;
                dist[next] = dist[cur] + 1;
                dq.offer(next);
            }
        }
    }
}
