import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deq = new ArrayDeque<>();

        for (int i = n; i > 0; i--) {
            deq.offerFirst(i);
        }

        while (deq.size()>=2) {

                deq.remove();
                deq.offerLast(deq.pollFirst());

            }


        System.out.println(deq.pollFirst());

    }
}