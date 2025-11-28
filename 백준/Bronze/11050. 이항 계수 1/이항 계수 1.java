import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().trim().split(" ");

        int n = Integer.parseInt(arr[0]);
        int k = Integer.parseInt(arr[1]);

        int rs = fact(n)/(fact(k)*fact(n-k));
        System.out.println(rs);
    }

    public static int fact(int a) {
        int fac =1 ;
        if(a!=0) {
            for(int i= 1; i<=a; i++) {
                fac *= i;
            }
        }
        return fac;
    }
}
