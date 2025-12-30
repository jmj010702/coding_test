import java.util.ArrayDeque;
import java.util.Deque;
class Solution {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
static int INF = Integer.MAX_VALUE;
    public int solution(int[][] maps) {
int n = maps.length;
int m = maps[0].length;
        Deque<int[] > dq = new ArrayDeque<>();
        boolean[][] visit = new boolean[n][m];
        dq.offer(new int[]{0,0});
        visit[0][0] = true;
        maps[0][0] = 1;
        while ((!dq.isEmpty())) {
            int[] cur = dq.poll();
            int x = cur[0];
            int y = cur[1];

            for(int i =0; i<4; i++ ) {
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx<0 || nx >= maps.length || ny<0 || ny>= maps[0].length) continue;

                if(maps[nx][ny] != 1 || visit[nx][ny]) continue;

                visit[nx][ny] = true;
                maps[nx][ny] = maps[x][y] +1;
dq.offer(new int[]{nx,ny});
            }
        }
if(!visit[n-1][m-1]) return -1;

        int answer = maps[n-1][m-1];
        return answer;
    }
}