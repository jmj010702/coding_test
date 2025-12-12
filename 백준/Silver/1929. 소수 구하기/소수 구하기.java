import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean [] dp = new boolean[n+1];

        for(int i =2; i<=n; i++) {
            dp[i] = true;
        }
        for(int i= 2; i*i<=n; i++) {
            if(dp[i]) {
                for(int j = i*i; j<=n; j+=i) {
                    dp[j] = false;
                }
            }
        }
        for(int i =m; i<=n; i++) {
            if(dp[i]) {
                bw.write(i+"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}

/*    출력 초과남
 StringBuilder sb = new StringBuilder();

        List<Integer> list = new ArrayList<>();

        for(int i=m; i<=n; i++) {
            list.add(i);
        }
        int index =0;
        for(int i=m; m<=n; m++) {
            boolean tf = false;
            int a = list.get(index);

            if(a == 2 || a==3) {
                sb.append(a).append("\n");
            } else  if(a % 2 != 0  && a%3 !=0) {
                    sb.append(a).append("\n");
            }
            index++;
        }
        System.out.println(sb);

 */