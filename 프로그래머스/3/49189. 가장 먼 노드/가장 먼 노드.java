import java.io.IOException;
import java.util.*;
class Solution {
     static List<Integer>[] graph;
static boolean[] visit ;
static int[] dist;
    public int solution(int n, int[][] edge) {
          Deque<int[]> dq = new ArrayDeque<>();
        graph = new List[n + 1];
        dist = new int[n+1];
        visit = new boolean[n+1];

        Arrays.fill(dist, -1);

        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int[] a : edge) {
        int start = a[0];
        int end = a[1];
        graph[start].add(end);
        graph[end].add(start);
        }
int count = 0;
        for (int i = 1; i<=n; i++) {
            Collections.sort(graph[i]);
        }
        dq.offer(new int[]{1,0});
        visit[1] = true;
dist[1] = 0;
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int x = cur[0];
            int cost = cur[1];

            for(int a : graph[x]) {
                if(visit[a]) continue;
                dq.offer(new int[]{a,cost+1});
                dist[a] = cost +1;
                visit[a] = true;
            }
        }
        int maxcount = 0; 
        for(int a : dist) {
            if(maxcount <a ) {
                maxcount = a;
            }
        }
        for(int a : dist) {
            if(a == maxcount) {
                count ++;
            }
        }
int answer = count;
        return answer;
    }
}