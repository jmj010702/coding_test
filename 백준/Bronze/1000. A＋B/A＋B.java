import java.io.BufferedReader;
import java.io.IOException;
import java.nio.Buffer;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] arr = input.split(" ");
        int first = Integer.parseInt(arr[0]);
        int sec = Integer.parseInt(arr[1]);
        System.out.println(first + sec);
    }
}
