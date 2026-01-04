import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int s = 0;
        int e = 0;
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();

        while (e < arr.length) {
            int total = arr[e] - arr[s];
            if (total < m) {
                e++;
                if(e==arr.length) break;
            } else if (total>=m) {
                list.add(total);
                s++;
                if(s == arr.length) break;
            }
        }
        list.sort(Comparator.naturalOrder());

        System.out.println(list.get(0));
    }
}
