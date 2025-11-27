import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public  static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ac[] = new int[8];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<8; i++) {
            ac[i] =Integer.parseInt(st.nextToken());
        }
        boolean acrs = true;
        boolean dcrs = true;
        for(int i=0; i<7; i++) {
            if(ac[i+1] > ac[i]) dcrs =false;

            if(ac[i+1] < ac[i]) acrs = false;
        }
        if(acrs) {
            System.out.print("ascending");
        } else if(dcrs) {
            System.out.print("descending");
        } else {
            System.out.print("mixed");
        }
    }
}
