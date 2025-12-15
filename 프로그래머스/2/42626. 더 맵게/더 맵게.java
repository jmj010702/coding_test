import java.util.*; 
class Solution {
    public int solution(int[] scoville, int k) {
 Queue<Integer> pq = new PriorityQueue<>();
       
        for(int a : scoville) {
            pq.offer(a);
        }
        int rs = 0, count = 0;
     
        while(pq.peek() <k && pq.size()>=2) {

                int one = pq.poll();
                int two = pq.poll();
                rs = one + (two*2);
                pq.offer(rs);
                count++;
        }
            if (pq.peek()>=k) {
                return count;
            } else {
                return -1;
            }
        }

    }
