import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public int count;
    public static void main(String[] args) throws IOException {
       /* BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];

        for(int i=2; i<=n; i++) {
            int first = 0;
            int second = 0;
            int third = 0;
            if(i%3 == 0) third = arr[i/3] ;
            if(i%2 ==0) second = arr[i/2] ;
            if(i-1> 1) first = arr[i-1] ;
            int min = Math.min(Math.min(second,third),first);
            // +1 은 계산 횟수
            arr[i] = min+1;
        }
        System.out.println(arr[n]);
*/   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num+1];
        for(int i=2; i<=num; i++){
            int three = Integer.MAX_VALUE;
            int two = Integer.MAX_VALUE;
            int one = Integer.MAX_VALUE;
            if(i%3==0)three=arr[i/3];
            if(i%2==0)two=arr[i/2];
            if(i-1>=1)one=arr[i-1];
            int min = Math.min(Math.min(three, two), one);
            arr[i] = min+1;
        }
        System.out.println(arr[num]);
        
    }
}