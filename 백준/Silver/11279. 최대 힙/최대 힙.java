import java.io.*;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringBuilder sb = new StringBuilder();
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        int x = Integer.parseInt(br.readLine());

        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0; i<x; i++) {
         int n = Integer.parseInt(br.readLine());
         if(n ==0) {
             if (pq.isEmpty()) {
                 sb.append(0).append("\n");
             }else {
                 sb.append(pq.poll()).append("\n");
             }
         } else {
             pq.offer(n);
         }
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
