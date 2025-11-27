import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] n =  new boolean[42];

        for(int i=0; i<10; i++ ) {
            n[Integer.parseInt(br.readLine()) % 42] = true;     
        }
        int j =0;
        for(boolean arr : n) {
            if (arr) {
                j++;
            }
        }
        System.out.print(j);

    }
}
