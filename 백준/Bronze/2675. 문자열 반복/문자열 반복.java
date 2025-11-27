import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public  static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());

    for(int i =0; i <t; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        String v = st.nextToken();

        for(int j =0; j<v.length(); j++) {
            for(int y =0; y<r; y++) {
                System.out.print(v.charAt(j));
            }
        }
        System.out.print("\n");
    }
    }
}
