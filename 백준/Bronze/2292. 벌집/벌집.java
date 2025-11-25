import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        int sum = 1;
        int count =1;
        while(n>sum) {
            sum += 6*count;
            count++;

        }
        System.out.print(count);
    }
}