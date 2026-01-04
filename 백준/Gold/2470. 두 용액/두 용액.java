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
        ;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        List<int[]> list = new ArrayList<>();
        int index = 0;
        Arrays.sort(arr);
        int s = 0;
        int e = arr.length - 1;
//        0에 가장 가까운 용액
        int answer = 0;
//        해당 용액의 인덱스 번호를 담을 배열
        int[] rs = new int[2];
        int temp = Integer.MAX_VALUE;
        while (s<e ) {
            int total = arr[s] + arr[e];
            if (total< 0) {
                if(Math.abs(total) < temp) {
                    temp = Math.abs(total);
                    rs[0] = s;
                    rs[1] = e;
                }
                s++;
            }  else if(total > 0) {
                if(Math.abs((total) )<temp) {
                    temp = Math.abs(total);
                    rs[0] = s;
                    rs[1] = e;
                }
                e--;
            } else if(total == 0) {
                rs[0] = s;
                rs[1] = e;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(arr[rs[0]]).append(" ").append(arr[rs[1]]);

        System.out.println(sb);
    }
}
