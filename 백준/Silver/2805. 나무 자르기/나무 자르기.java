import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

         st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long s = 1;
        long e = arr[arr.length-1];

        long answer = 0L;

        while (s<=e) {
            long mid = (s+e) /2 ;
            long total = 0;

            for(int i=0; i<n; i++) {
                if (arr[i] > mid) {
                    total += arr[i] - mid;
                    if (total >= m) break;
                }
            }
            if(total < m) {
//                나무가 부족 높이가 너무 높음
                e  = mid -1;
            } else if (total >=m) {
//                나무가 충분하다 -> 높이를 더 높여도 됨
                answer = mid;
                s = mid +1;
            }
        }
        System.out.println(answer);

    }
}
