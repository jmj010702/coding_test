import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
상한액 * 모든 요청 == 예산 총액 일경우만 answer 를 구하면 안됨
int start =0;
int end = 최대값 ;
while() {
int mid = start + end/2;
int 금액 = ; // for 문을 통해
if(금액 == 예산총액) // 또는 < 또는 >

 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int s =1;
        int answer = -1;
        int e = arr[arr.length - 1];
        
        while (s <= e) {
            int mid = (s+e) /2;
            int total = 0;
            for(int i=0; i<arr.length; i++) {
                total += Math.min(arr[i],mid);
            }
            if(total < m) {
                s = mid +1;
                answer = mid;
            } else if(total > m) {
                e = mid-1;
            } else {
                answer  = mid;
                break;
            }

        }

        System.out.println(answer);
    }
}
