import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n =Long.parseLong(st.nextToken());
        long m =Long.parseLong(st.nextToken());

        long[] arr= new long[Math.toIntExact(n)];

        for(int i =0; i< n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        long s= 0;
        long e = arr[arr.length-1] *m;

        long answer = 0;
        while (s<=e) {
//            mid = 지금 가정한 시간 t
//            total = 이 시간동안 처리 가능한 사람 수
//            total 과 m을 비교해서 시간을 줄일지 늘릴지 결정
            long mid = ((long) s+e) /2;
            long total=0;
            for(int i=0; i<n; i++) {
                total += (mid/arr[i]);
                if(total>= m) break;
            }
//            시간 부족 시간 늘려야됨
            if(total < m) {
                s= mid + 1;
            }
//            시간 널널 줄일 수 있으면 줄여야됨
            else if( total >=m) {
            answer = mid;
            e = mid -1;
            }

        }
        System.out.println(answer);


    }
}
/* 이분 탐색 템플릿
s = 0
e = 최대가능시간
answer = 0

while (s <= e):
    mid = (s + e) / 2
    total = f(mid)

    if total < m:        // 시간이 부족
        s = mid + 1
    else:               // 시간이 충분
        answer = mid
        e = mid - 1
 */