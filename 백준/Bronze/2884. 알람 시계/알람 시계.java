import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int HH = 0;
        int MM = 0;
        if(M >= 45 ) {
            MM = M-45;
                     HH = H;
        } else {
            HH = H-1;
            if(HH<0) {
                HH = 23;
            }
            MM = 60-(45-M);

        }
        System.out.print(HH +" " + MM );

    }
}
