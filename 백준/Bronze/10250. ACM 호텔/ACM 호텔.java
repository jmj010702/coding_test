import com.sun.jdi.Value;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int Y = N % H;
            int XX = N / H;
            if(N% H ==0) {
                Y = H;
                XX = N /H;
            } else {
                Y = N % H;
                XX = N/H +1;
            }

            int YXX = Y * 100 + XX;

            System.out.print(YXX+ "\n");
        }

    }
}
