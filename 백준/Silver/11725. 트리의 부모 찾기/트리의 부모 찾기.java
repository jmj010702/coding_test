import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visit;
    static int n;
    static List<Integer>[] graph;
static int[] parent;
    static void dfs(int start) {
        visit[start] = true;
        for(int target : graph[start]) {
            if(visit[target]) continue;
            parent[target] = start;
            dfs(target);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        visit = new boolean[n + 1];
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
parent = new int[n+1];
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        dfs(1);

        for(int i =2; i<=n; i++) {
            System.out.println(parent[i]);
        }
    }
}
