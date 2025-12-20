import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            arr[i][0] = Math.min(X,Y);
                    arr[i][1] = Math.max(X,Y);
        }
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0],b[0]));

            int start = arr[0][0];
        int end = arr[0][1];


int length = 0;
        for (int i = 1; i < n; i++) {
            int x = arr[i][0];
            int y = arr[i][1];
            if(end >= x) {
//                겹치는 파트
                end = Math.max(end,y);
            } else {
                length += end  -start;
                start =x;
                end = y;
            }
        }

        length += end  -start;

        System.out.println(length);

    }
}
