import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, x;
    static List<edge>[] graph;
    static int[] dist;
    static int INF = Integer.MAX_VALUE;

    static class edge {
        int to, cost;

        edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
        static void dijk(int start) {
            PriorityQueue<edge> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
            pq.offer(new edge(start, 0));
            Arrays.fill(dist, INF);
            dist[start] = 0;

            while (!pq.isEmpty()) {
                edge cur = pq.poll();
                int nowto = cur.to;
                int nowcost = cur.cost;

                if (dist[nowto] < nowcost) continue;

                for (edge e : graph[nowto]) {
                    int next = e.to;
                    int ncost = e.cost + nowcost;

                    if (dist[next] > ncost) {
                        dist[next] = ncost;
                        pq.offer(new edge(next, ncost));
                    }
                }
            }
        }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            graph = new List[n + 1];
            dist = new int[n + 1];
            for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

            for (int i = 1; i <= m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                graph[a].add(new edge(b, c));
            }
            int[][] result = new int[n+1][2];
                dijk(x);
                for(int i =1;i<=n; i++) {
                   result[i][0] = dist[i];
                }
            for(int i=1; i<=n; i++) {
               dijk(i);
               result[i][1] = dist[x];

            }
int rss =0 ;
            for(int i=1; i<=n; i++) {
                int rs = result[i][0] + result[i][1];
            rss = Math.max(rss, rs);
            }

            System.out.println(rss);
    }

    }

