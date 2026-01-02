import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0 ; i<n; i++  ) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int target = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();
        Arrays.sort(arr);
        int s= 0;
        int e = arr.length-1;
        while (s < e) {
            int sum = arr[s] + arr[e];
            if(sum == target) {
                list.add(new int[]{arr[s], arr[e]});
                s++;
            } else if(sum<target) {
                s++;
            } else {
                e--;
            }
        }
        System.out.println(list.size());
    }
}
