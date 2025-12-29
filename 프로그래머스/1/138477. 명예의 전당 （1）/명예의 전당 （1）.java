import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1-o2);
        int[] answer = new int[score.length];
       for(int i =0; i<score.length; i++) {
           pq.offer(score[i]);
           if(pq.size() > k) {
               pq.poll();
           }
           answer[i] = pq.isEmpty() ? 0 : pq.peek();
       }
        return answer;
    }
}