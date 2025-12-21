import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer>[] graph;
    static boolean[] visit;


    static void dfs(int start) {
        Stack<Integer> stack = new Stack<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int next = stack.pop();
            if (visit[next]) continue;
            else {
                visit[next] = true;

                for (int i = graph[next].size() - 1; i >= 0; i--) {
                    int node = graph[next].get(i);
                    if (!visit[node]) {
                        stack.push(node);
                    }
                }
            }
        }
    }

/*
    static void bfs(int start) {
        Deque<Integer> dq = new ArrayDeque<>();

        visit[start] = true;
        dq.offer(start);
        while (!dq.isEmpty()) {
            int node = dq.poll();
            for (int next : graph[node]) {
                if (visit[next]) {
                    continue;
                } else {
                    visit[next] = true;
                    dq.offer(next);
                }
            }
        }
    }*/

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] str = new String[m];

        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
//            graph[i] = new ArrayList<Integer>();

            graph[a].add(b);
            graph[b].add(a);

        }
        for (int i = 1; i <= n; i++) {
            Collections.sort(graph[i]);
        }
        int count = 0;
        visit = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                dfs(i);
                count++;
            }
        }


        /*
        visit = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                bfs(i);
            }
        }
        */
         


        System.out.println(count);

    }
}


