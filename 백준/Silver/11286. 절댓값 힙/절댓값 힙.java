import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb=  new StringBuilder();
        Queue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
              if(Math.abs(o1) - Math.abs(o2) == 0) {
                  return o1-o2;
              } else {
                  return Math.abs(o1) - Math.abs(o2);
              }
            };
        });

        for(int i =0; i <n; i++) {
            int x = Integer.parseInt(br.readLine());

            if(q.isEmpty() && x ==0) {
                sb.append(0).append("\n");
            } else if (x == 0) {
               sb.append(q.poll()).append("\n");
            } else {
                q.offer(x);
            }
        }


        System.out.println(sb);

    }
}
