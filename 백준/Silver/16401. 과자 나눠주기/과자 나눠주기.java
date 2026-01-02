import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//    과자 나눠주기 : 백준 -> 과자 길이를 이분 탐색의 대상으로 선정. 계산한 값이 조카사람 수보다 크거나 같으면 answer 세팅
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int s = 1;
        int e = arr[arr.length - 1];
        int answer = 0;
        while (s <= e) {
//            나눠줄 과자 길이
            int mid = (s + e) / 2;
            int total = 0;
            for (int i = 0; i < n; i++) {
//                과자를 최대 몇명한테 나눠줄 수 있는지
                total += arr[i]/mid;
            }
             if(total >=m) {
                s = mid +1;
                answer = mid;
            } else {
                e= mid -1;
            }
        }
        System.out.println(answer);
    }
}
