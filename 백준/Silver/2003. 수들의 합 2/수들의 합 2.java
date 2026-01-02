import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int s = 0;
        int e = 0;
        int count = 0;
        int sum = 0;

        sum = arr[s];
        /*
        while (e < arr.length) {
            if (sum == m) {
                count++;
                sum -= arr[s];
                s++;
            } else if (sum > m) {
                sum -= arr[s];
                s++;
            } else if (sum < m) {
                e++;
                if (e == arr.length) break;
                sum += arr[e];
            }
        }
         */
        while(s<=e &&e<arr.length) {
            if(sum==m) {
                count++;
                e++;
                if(e==arr.length)break;
                sum += arr[e];
            } else if(sum > m) {
                sum -= arr[s];
                s++;
                if(s>e) {
                   e++;
                    if(e==arr.length)break;
                    sum += arr[e];
                }
            } else if(sum < m) {
                e ++;
                if(e==arr.length)break;
                sum += arr[e];
            }
        }
        System.out.println(count);
    }
}
