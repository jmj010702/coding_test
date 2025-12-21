import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] maze;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void bfs() {
        Deque<int[]> dq = new ArrayDeque<>();

        dq.offer(new int[]{0,0});

       while(!dq.isEmpty()) {
           int[] cur = dq.poll();
           int x = cur[0];
           int y = cur[1];

           for(int i =0; i<4; i++) {
               int nx = x+ dx[i];
               int ny = y+dy[i];

               if(nx < 0 || ny < 0|| nx >=n || ny >=m) continue;

               if(maze[nx][ny] != 1) continue;

               maze[nx][ny] = maze[x][y] +1;

               dq.offer(new int[]{nx,ny});
           }
       }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());

         maze = new int[n][m];
         
        for(int i=0; i<n; i++) {
            String line = br.readLine();

            for(int j=0; j<m; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }

           

        } 
        bfs();

        System.out.println(maze[n-1][m-1]);
    }
}