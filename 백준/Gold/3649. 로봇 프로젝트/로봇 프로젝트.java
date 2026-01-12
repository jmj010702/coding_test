import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        while (true) {
            String a = br.readLine();
            if (a == null) break;
            long x = Integer.parseInt(a);
            x *= 10000000;
            int n = Integer.parseInt(br.readLine());
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(arr);
            int s = 0;
            int e = n - 1;
            long ans = -1;
            long b1 = 0;
            long b2 = 0;
            while (s < e) {
                long mid = (arr[e] + arr[s]);

                if (mid == x) {
                    long diff = arr[e]-arr[s];
                    if (diff > ans) {
                        ans = diff;
                        b1 = arr[s];
                        b2 = arr[e];
                    }
                    s++;
                    e--;
                } else if (mid < x) {
                    s++;
                } else {
                    e--;
                }
            }
            if (ans == -1) {
                System.out.println("danger");
            } else {
                System.out.println("yes " + b1 + " " + b2);
            }
        }
    }

}


