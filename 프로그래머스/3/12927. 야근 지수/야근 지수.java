import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
         PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int a : works) {
            pq.offer(a);
        }
       while (n--> 0 && !pq.isEmpty()) {
           int x = pq.poll();
           if (x ==0) break;
           pq.offer(x-1);
       }
        while(!pq.isEmpty()) {
            long x = pq.poll();
            answer += x*x;
        }
        return answer;

    }
}