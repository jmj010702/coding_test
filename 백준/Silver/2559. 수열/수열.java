import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i< n; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
        }
        int s = 0;
        int e = k-1;
        int ans = Integer.MIN_VALUE;
        while(e<arr.length) {
            int total = 0;
            for(int i=s; i<=e; i++) {
                total += arr[i];
            }
            if(total > ans) {
                ans = total;
            }
            e++;
            s++;
        }
        System.out.println(ans);
    }
}
