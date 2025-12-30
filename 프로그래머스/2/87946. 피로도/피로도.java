import java.util.*;
public class Solution {
    static int[][] dungeons;
    static int max =0;
    static boolean[] visit;
    static int dfs(int m , int count){
         max = Math.max(max,count);
        for(int i =0; i<dungeons.length; i++) {
            if (visit[i]) continue;
            if(m >= dungeons[i][0]) {
                visit[i] = true;
                dfs(m-dungeons[i][1], count +1);
                visit[i] = false;
            }
        }
        return max;
    }
    public int solution(int k, int[][] input) {
dungeons = input;
        visit = new boolean[dungeons.length];
        max = 0;
 dfs(k,0);
        return max;
    }
}
