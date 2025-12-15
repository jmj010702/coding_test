import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for(int i =1; i<=n; i++) {
            q.offer(i);
        }
sb.append("<");
        while(!q.isEmpty()) {
            //k번째 사람을 찾기위해 k번째가 나올떄까지 뒤로보냄
           for(int i=1;i<k; i++) {
               q.offer(q.poll());
           }
           sb.append(q.poll());
           if(!q.isEmpty()) sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}
