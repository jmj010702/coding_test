import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<edge>[] graph;
    static int[] dist;
    static int n, m;
    static int INF = Integer.MAX_VALUE;

    static void dijk(int start) {
        PriorityQueue<edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

        Arrays.fill(dist, INF);
        dist[start] = 0;
pq.offer(new edge(start,0));
        while (!pq.isEmpty()) {
            edge cur = pq.poll();
            int now = cur.to;
            int nowcost = cur.cost;

            if(dist[now] < nowcost) continue;

            for(edge e : graph[now]) {
                int next = e.to;
                int nextcost = nowcost + e.cost;

                if(dist[next] > nextcost) {
                    dist[next] = nextcost;

                    pq.offer(new edge(next,nextcost));
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new int[n + 1];
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new edge(v, w));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijk(start);

        System.out.println(dist[end]);

    }

    static class edge {
        int to, cost;

        public edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}
