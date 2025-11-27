import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s[] = new String[n];

        for(int i = 0; i<n; i++) {
            s[i] = br.readLine();
        }
        for(int i =0; i<n;i++) {
            int sum =0;
            int rs =0;
            for(int j=0; j<s[i].length(); j++) {
                if(s[i].charAt(j) == 'O') {
                    rs++;
                } else {
                    rs = 0;
                }
                sum +=rs;
            }
         
            System.out.println(sum);
        }

    }
}
